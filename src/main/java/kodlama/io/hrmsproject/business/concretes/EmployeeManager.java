package kodlama.io.hrmsproject.business.concretes;

import kodlama.io.hrmsproject.business.abstracts.EmployeeService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.core.utilities.result.SuccessDataResult;
import kodlama.io.hrmsproject.core.utilities.result.SuccessResult;
import kodlama.io.hrmsproject.dataAccess.abstracts.EmployeeDao;
import kodlama.io.hrmsproject.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeDao employeeDao;
    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public DataResult<List<Employee>> getall() {
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Employee listed") ;
    }

    @Override
    public Result add(Employee employee) {
        this.employeeDao.save(employee);
        return new SuccessResult("Employee saved");
    }

    @Override
    public Result delete(int id) {
        Optional<Employee> findEmployee = this.employeeDao.findById(id);
        if(findEmployee.isPresent()){
            Employee deleteEmployee = findEmployee.get();
            this.employeeDao.delete(deleteEmployee);
        }
        return new SuccessResult("Employee deleted");
    }

    @Override
    public Result update(int id, Employee employee) {
        Employee savedEmployee = this.employeeDao.findById(id).get();
        savedEmployee.setId(employee.getId());
        savedEmployee.setEmail(employee.getEmail());
        savedEmployee.setFirstName(employee.getFirstName());
        savedEmployee.setLastName(employee.getLastName());
        savedEmployee.setPassword(employee.getPassword());
        savedEmployee.setPasswordAgain(employee.getPasswordAgain());
        savedEmployee.setVerified(employee.isVerified());
        this.employeeDao.save(savedEmployee);
        return new SuccessResult("Employee updated");
    }
}

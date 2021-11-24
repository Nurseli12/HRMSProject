package kodlama.io.hrmsproject.business.abstracts;

import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    DataResult<List<Employee>> getall();
    Result add(Employee employee);
    Result delete(int id);
    Result update(int id, Employee employee);
}

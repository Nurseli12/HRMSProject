
package kodlama.io.hrmsproject.api;



import kodlama.io.hrmsproject.business.abstracts.EmployeeService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeesController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/getall")
    public DataResult<List<Employee>> getall(){
        return this.employeeService.getall();
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Employee employee){
        return new ResponseEntity<>(this.employeeService.add(employee), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") int id){
        return new ResponseEntity<>(this.employeeService.delete(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Result> update(@PathVariable("id") int id,@RequestBody Employee employee){
        return  new ResponseEntity<>(this.employeeService.update(id,employee),HttpStatus.OK);
    }
}


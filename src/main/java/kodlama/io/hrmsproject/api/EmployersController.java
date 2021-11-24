package kodlama.io.hrmsproject.api;

import kodlama.io.hrmsproject.business.abstracts.EmployerService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

    @GetMapping("/getEmployerByCompanyNameAndEmail")
    public DataResult<Employer> getEmployerByCompanyNameAndEmail(@RequestParam  String companyName, String email) {
        return this.employerService.getEmployerByCompanyNameAndEmail(companyName,email);
    }
    @PostMapping ("/add")
    public Result add(@RequestBody Employer employer){
        return this.employerService.add(employer);
    }

    @GetMapping("/getEmployerById")
    public  DataResult<Employer> getEmployerById(@RequestParam int id)
    {
        return this.employerService.getEmployerById(id);
    }
    public Result delete(int id){
        return this.employerService.delete(id);
    }
    public Result update(int id, Employer employer){
        return this.employerService.update(id,employer);
    }



}

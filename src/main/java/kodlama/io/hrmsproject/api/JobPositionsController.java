package kodlama.io.hrmsproject.api;

import kodlama.io.hrmsproject.business.abstracts.JobPositionService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private JobPositionService jobPositionService;
    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition){
       return this.jobPositionService.add(jobPosition);
    }
    @PutMapping("update/{id}")
    public Result update(@RequestBody JobPosition jobPosition,@PathVariable("id") int id){
        return this.jobPositionService.update(jobPosition,id);
    }
    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable("id")int id){
        return  this.jobPositionService.delete(id);
    }
    @GetMapping("getId/{id}")
    public DataResult<JobPosition> getJobPositionById(@PathVariable("id") int id){
        return this.jobPositionService.getJobPositionById(id);
    }

}

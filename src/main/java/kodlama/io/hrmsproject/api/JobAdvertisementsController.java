package kodlama.io.hrmsproject.api;

import kodlama.io.hrmsproject.business.abstracts.JobAdvertisementService;
import kodlama.io.hrmsproject.business.abstracts.JobPositionService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.JobAdvertisement;
import kodlama.io.hrmsproject.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController( JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;

    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @PutMapping("/updateAdvert/{id}")
    public Result update (@RequestBody JobAdvertisement jobAdvertisement,@PathVariable("id") int id){
        return this.jobAdvertisementService.update(jobAdvertisement,id);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(int id){
        return this.jobAdvertisementService.delete(id);
    }
    @GetMapping("/getJobAdvertById")
    public DataResult<JobAdvertisement> getJobAdvertById(int id){
        return this.jobAdvertisementService.getJobAdvertById(id);
    }
    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/findAllByEmployer_IdAndStatusTrue")
    public DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndStatusTrue(int id){
        return this.jobAdvertisementService.findAllByEmployer_IdAndStatusTrue(id);
    }
    @GetMapping("/getJobAdvertisementWithEmpDetails")
    public ResponseEntity<DataResult<List<JobAdvertisementDto>>> getJobAdvertisementWithEmpDetails(){
        return new ResponseEntity<>(this.jobAdvertisementService.getJobAdvertisementWithEmpDetails(), HttpStatus.OK);
    }


}

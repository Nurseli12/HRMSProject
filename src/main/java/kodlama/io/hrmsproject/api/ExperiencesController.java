package kodlama.io.hrmsproject.api;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.hrmsproject.business.abstracts.ExperienceService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {
    private ExperienceService experienceService;
    @Autowired
    public ExperiencesController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }


    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Experience experience){
        var result = this.experienceService.add(experience);
        if(result.isSuccess()){
            return  ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping("/descDate")
    public DataResult<List<Experience>> getAllSorted(){
        return this.experienceService.getAllSorted();
    }
    @GetMapping("/getExperienceByWorkStartingDateStartsWith")
    public DataResult<List<Experience>> getExperienceByWorkStartingDateStartsWith( @RequestParam Date workStartingDate){
        return this.experienceService.getExperienceByWorkStartingDateStartsWith(workStartingDate);
    }

}

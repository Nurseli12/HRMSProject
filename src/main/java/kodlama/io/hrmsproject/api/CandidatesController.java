package kodlama.io.hrmsproject.api;

import kodlama.io.hrmsproject.business.abstracts.CandidateService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.logging.ErrorManager;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }


    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getall(){
        return this.candidateService.getall();
    }

    public DataResult<List<Candidate>> getCandidateByFirstNameIsContaining(String firstname) {
        return this.candidateService.getCandidateByFirstNameIsContaining(firstname);
    }

    @PostMapping("/addCandidate")
    public Result add(@RequestBody Candidate candidate){
        return this.candidateService.add(candidate);
    }
    @DeleteMapping("/deleteCandidate/{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") int id){
        return new ResponseEntity<>(this.candidateService.delete(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public Result update(@PathVariable("id") int id,@RequestBody Candidate candidate){
    try{
        return this.candidateService.update(id, candidate);
    }
    catch (Exception e) {
			String msg = "An error occurred while trying to update customer data.";
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
		}

    }


}

package kodlama.io.hrmsproject.api;

import kodlama.io.hrmsproject.business.abstracts.EdicationService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Edication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/edications")
public class EdicationsController {
    private EdicationService edicationService;

    @Autowired
    public EdicationsController(EdicationService edicationService) {
        this.edicationService = edicationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody Edication edication){
        var result = this.edicationService.add(edication);
        if(result.isSuccess()){
            return  ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<DataResult<Edication>> getAll(){

        return new ResponseEntity<>(this.edicationService.getAll(),HttpStatus.OK);

    }
    @GetMapping("/getById")
    public ResponseEntity<DataResult<Edication>> getEdicationById(@RequestParam int id){
        return new ResponseEntity<>(this.edicationService.getEdicationById(id),HttpStatus.OK);
    }

}

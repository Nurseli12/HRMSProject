package kodlama.io.hrmsproject.api;

import kodlama.io.hrmsproject.business.abstracts.ResumeService;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
public class ResumesController {
    private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Resume resume){
        var result = this.resumeService.add(resume);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") int id){
        var result = this.resumeService.delete(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Result> update(@PathVariable int id,@RequestBody Resume resume){
        var result = this.resumeService.update(id,resume);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @PutMapping("/saveImage")
    public ResponseEntity<Result> saveImage(@RequestBody MultipartFile file, @RequestParam int id) {
        var result = this.resumeService.saveImage(file,id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

    }
    @GetMapping("/getById")
    public ResponseEntity<Result> getResumeById(@PathVariable("id") int id){
        return new ResponseEntity<>(this.resumeService.getResumeById(id),HttpStatus.OK );
    }

}

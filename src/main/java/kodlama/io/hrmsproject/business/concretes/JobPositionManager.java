package kodlama.io.hrmsproject.business.concretes;

import kodlama.io.hrmsproject.business.abstracts.JobPositionService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.core.utilities.result.SuccessDataResult;
import kodlama.io.hrmsproject.core.utilities.result.SuccessResult;
import kodlama.io.hrmsproject.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrmsproject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobPositionManager implements JobPositionService {
    @Autowired
    private JobPositionDao jobPositionDto;

    @Override
    public Result add(JobPosition jobPosition) {
        this.jobPositionDto.save(jobPosition);
        return new SuccessResult("Job Position saved");
    }

    @Override
    public Result update(JobPosition jobPosition, int id) {
        JobPosition savedJobPosition = this.jobPositionDto.findById(id).get();
        savedJobPosition.setId(jobPosition.getId());
        savedJobPosition.setJobName(jobPosition.getJobName());
        this.jobPositionDto.save(savedJobPosition);
        return new SuccessResult("Job Position updated");
    }

    @Override
    public Result delete(int id) {
        Optional<JobPosition> findJobPosition =this.jobPositionDto.findById(id);
        if(findJobPosition.isPresent()){
            JobPosition deleteJob = findJobPosition.get();
            this.jobPositionDto.delete(deleteJob);
        }
        return new SuccessResult("Job Position deleted");
    }

    @Override
    public DataResult<JobPosition> getJobPositionById(int id) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDto.getJobPositionById(id));
    }
}

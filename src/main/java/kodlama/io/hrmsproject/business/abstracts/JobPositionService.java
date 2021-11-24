package kodlama.io.hrmsproject.business.abstracts;

import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.JobPosition;

public interface JobPositionService {
    Result add(JobPosition jobPosition);
    Result update(JobPosition jobPosition,int id);
    Result delete(int id);
    DataResult<JobPosition> getJobPositionById(int id);
}

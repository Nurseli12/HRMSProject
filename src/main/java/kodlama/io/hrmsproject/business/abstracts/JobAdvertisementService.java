package kodlama.io.hrmsproject.business.abstracts;

import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.JobAdvertisement;
import kodlama.io.hrmsproject.entities.dtos.JobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    Result update (JobAdvertisement jobAdvertisement,int id);
    Result delete(int id);
    DataResult<JobAdvertisement> getJobAdvertById(int id);
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndStatusTrue(int id);
    DataResult<List<JobAdvertisementDto>> getJobAdvertisementWithEmpDetails();


}

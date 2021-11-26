package kodlama.io.hrmsproject.business.concretes;

import kodlama.io.hrmsproject.business.abstracts.JobAdvertisementService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.core.utilities.result.SuccessDataResult;
import kodlama.io.hrmsproject.core.utilities.result.SuccessResult;
import kodlama.io.hrmsproject.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrmsproject.entities.concretes.JobAdvertisement;
import kodlama.io.hrmsproject.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private  JobAdvertisementDao jobAdvertisementDao;
    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao){
        this.jobAdvertisementDao =jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        try{
            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("Job advertisement saved");
        }
        catch (Exception e){
            return  null;
        }
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement, int id) {
        JobAdvertisement savedAdvert = this.jobAdvertisementDao.findById(id).get();
        savedAdvert.setId(jobAdvertisement.getId());
        savedAdvert.setConfirmed(jobAdvertisement.isConfirmed());
        savedAdvert.setCities(jobAdvertisement.getCities());
        savedAdvert.setEmployer(jobAdvertisement.getEmployer());
        savedAdvert.setEndOfJobDate(jobAdvertisement.getEndOfJobDate());
        savedAdvert.setJobDescription(jobAdvertisement.getJobDescription());
        savedAdvert.setJobPosition(jobAdvertisement.getJobPosition());
        savedAdvert.setMaxSalary(jobAdvertisement.getMaxSalary());
        savedAdvert.setFullDescription(jobAdvertisement.getFullDescription());
        savedAdvert.setNumberPosition(jobAdvertisement.getNumberPosition());
        savedAdvert.setStatus(jobAdvertisement.isStatus());
        savedAdvert.setMinSalary(jobAdvertisement.getMinSalary());
        this.jobAdvertisementDao.save(savedAdvert);
        return new SuccessResult("Job advertisement updated");
    }

    @Override
    public Result delete(int id) {
        Optional<JobAdvertisement> findAdvert = this.jobAdvertisementDao.findById(id);
        if(findAdvert.isPresent()){
            JobAdvertisement deleteAdvert = findAdvert.get();
            this.jobAdvertisementDao.delete(deleteAdvert);
        }
        return new SuccessResult("Job advertisement deleted");
    }

    @Override
    public DataResult<JobAdvertisement> getJobAdvertById(int id) {
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getJobAdvertisementById(id));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndStatusTrue(int id) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByEmployer_IdAndStatusTrue(id));
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getJobAdvertisementWithEmpDetails() {
        return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementWithEmpDetails());
    }

/*    @Override
    public DataResult<List<JobAdvertisement>> findAllByMaxSalaryBetweenMinSalary(int maxSalary, int minSalary) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByMaxSalaryBetweenMinSalary(maxSalary,minSalary));

    }*/
}

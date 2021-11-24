
package kodlama.io.hrmsproject.business.concretes;

import kodlama.io.hrmsproject.business.abstracts.EmployerService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.core.utilities.result.SuccessDataResult;
import kodlama.io.hrmsproject.core.utilities.result.SuccessResult;
import kodlama.io.hrmsproject.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrmsproject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employer listed");
    }

    @Override
    public Result add(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult("Employer Added");
    }

    @Override
    public Result delete(int id) {
        Optional<Employer> findEmployer =this.employerDao.findById(id);
        if (findEmployer.isPresent()){
            Employer deleteEmployer = findEmployer.get();
            this.employerDao.delete(deleteEmployer);
        }
        return new SuccessResult("Employer deleted");
    }

    @Override
    public Result update(int id, Employer employer) {
        Employer savedEmployer = this.employerDao.findById(id).get();
        savedEmployer.setEmail(employer.getEmail());
        savedEmployer.setCompanyName(employer.getCompanyName());
        savedEmployer.setConfirmed(employer.isConfirmed());
        savedEmployer.setPassword(employer.getPassword());
        savedEmployer.setId(employer.getId());
        savedEmployer.setPasswordAgain(employer.getPasswordAgain());
        savedEmployer.setJobAdvertisements(employer.getJobAdvertisements());
        savedEmployer.setSector(employer.getSector());
        savedEmployer.setWebAddress(employer.getWebAddress());
        savedEmployer.setPhoneNumber(employer.getPhoneNumber());
        savedEmployer.setVerified(employer.isVerified());
        this.employerDao.save(savedEmployer);
        return new SuccessResult("Employer updated");
    }

    @Override
    public DataResult<Employer> getEmployerByCompanyNameAndEmail(String companyName, String email) {
        return new SuccessDataResult<Employer>(this.employerDao.getEmployerByCompanyNameAndEmail(companyName,email));
    }

    @Override
    public DataResult<Employer> getEmployerById(int id) {
        return new SuccessDataResult<Employer>(this.employerDao.getEmployerById(id));
    }

}


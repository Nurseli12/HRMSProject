package kodlama.io.hrmsproject.business.concretes;

import kodlama.io.hrmsproject.business.abstracts.CandidateService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.core.utilities.result.SuccessDataResult;
import kodlama.io.hrmsproject.core.utilities.result.SuccessResult;
import kodlama.io.hrmsproject.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrmsproject.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    @Autowired
    public CandidateManager(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    @Override
    public DataResult<List<Candidate>> getall() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
    }

    @Override
    public DataResult<List<Candidate>> getCandidateByFirstNameIsContaining(String firstname) {
        return new SuccessDataResult<List<Candidate>>
                (this.candidateDao.getCandidateByFirstNameIsContaining(firstname));
    }

    @Override
    public Result add(Candidate candidate) {
        this.candidateDao.save(candidate);
        return new SuccessResult("Candidate Saved");
    }

    @Override
    public Result delete(int id) {
     Optional<Candidate> result=  this.candidateDao.findById(id);
     if(result.isPresent()){
         Candidate deleteCandidate = result.get();
         this.candidateDao.delete(deleteCandidate);
     }
        return new SuccessResult("Candidate deleted");
    }

    @Override
    public Result update(int id,Candidate candidate) {
        Candidate saved = this.candidateDao.findById(id).get();
        saved.setId(candidate.getId());
        saved.setFirstName(candidate.getFirstName());
        saved.setLastName(candidate.getLastName());
        saved.setBirthYear(candidate.getBirthYear());
        saved.setIdentityNumber(candidate.getIdentityNumber());
        saved.setEmail(candidate.getEmail());
        saved.setPassword(candidate.getPassword());
        saved.setPasswordAgain(candidate.getPasswordAgain());
        this.candidateDao.save(saved);
        return new SuccessResult("Candidate updated");
    }
    @Override
    public DataResult<Candidate> getByCandidateId(int id) {
        return new SuccessDataResult<Candidate>(this.candidateDao.getCandidateById(id));
    }



}

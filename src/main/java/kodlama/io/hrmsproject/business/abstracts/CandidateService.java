package kodlama.io.hrmsproject.business.abstracts;

import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Candidate;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getall();
    DataResult<List<Candidate>> getCandidateByFirstNameIsContaining(String firstname);
    Result add(Candidate candidate);
    Result delete(int id);
    Result update(int id,Candidate candidate);
    DataResult<Candidate> getByCandidateId(int id);

}

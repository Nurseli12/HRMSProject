
package kodlama.io.hrmsproject.business.abstracts;

import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result add(Employer employer);
    Result delete(int id);
    Result update(int id, Employer employer);
    DataResult<Employer> getEmployerByCompanyNameAndEmail(String companyName, String email);
    DataResult<Employer> getEmployerById(int id);
}


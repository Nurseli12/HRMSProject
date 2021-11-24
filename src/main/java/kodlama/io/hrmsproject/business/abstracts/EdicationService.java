package kodlama.io.hrmsproject.business.abstracts;

import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Edication;

public interface EdicationService {
    Result add(Edication edication);
    DataResult<Edication> getAll();
    DataResult<Edication> getEdicationById(int id);
}

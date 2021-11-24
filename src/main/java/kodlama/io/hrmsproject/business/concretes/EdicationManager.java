package kodlama.io.hrmsproject.business.concretes;

import kodlama.io.hrmsproject.business.abstracts.EdicationService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.core.utilities.result.SuccessDataResult;
import kodlama.io.hrmsproject.core.utilities.result.SuccessResult;
import kodlama.io.hrmsproject.dataAccess.abstracts.EdicationDto;
import kodlama.io.hrmsproject.entities.concretes.Edication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdicationManager implements EdicationService {
    private EdicationDto edicationDto;
    @Autowired
    public EdicationManager(EdicationDto edicationDto) {
        this.edicationDto = edicationDto;
    }

    @Override
    public Result add(Edication edication) {
        this.edicationDto.save(edication);
        return new SuccessResult("Edication added");
    }

    @Override
    public DataResult<Edication> getAll() {
        return null;
    }

    @Override
    public DataResult<Edication> getEdicationById(int id) {
        return new SuccessDataResult<Edication>(this.edicationDto.getEdicationById(id),"Edication listed");
    }


}

package kodlama.io.hrmsproject.business.concretes;

import kodlama.io.hrmsproject.business.abstracts.LanguageService;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.core.utilities.result.SuccessResult;
import kodlama.io.hrmsproject.dataAccess.abstracts.LanguageDto;
import kodlama.io.hrmsproject.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager implements LanguageService {
    private LanguageDto languageDto;
    @Autowired
    public LanguageManager(LanguageDto languageDto) {
        this.languageDto = languageDto;
    }

    @Override
    public Result add(Language language) {
        this.languageDto.save(language);
        return new SuccessResult("Language added");
    }

    @Override
    public Result addMultiple(Language[] languages) {
        for ( Language language:languages) {
            this.languageDto.save(language);
        }
        return new SuccessResult("Languages added");
    }
}

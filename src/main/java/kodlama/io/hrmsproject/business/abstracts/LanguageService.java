package kodlama.io.hrmsproject.business.abstracts;

import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Language;


public interface LanguageService {
    Result add(Language language);
    Result addMultiple (Language[] languages);
}

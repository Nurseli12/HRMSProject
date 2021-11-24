package kodlama.io.hrmsproject.business.abstracts;

import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Experience;

import java.sql.Date;
import java.util.List;


public interface ExperienceService {
    Result add(Experience experience);
    DataResult<List<Experience>> getAllSorted();
    DataResult<List<Experience>> getExperienceByWorkStartingDateStartsWith(Date workStartingDate);
}

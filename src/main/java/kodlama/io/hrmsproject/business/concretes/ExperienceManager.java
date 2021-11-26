package kodlama.io.hrmsproject.business.concretes;

import kodlama.io.hrmsproject.business.abstracts.ExperienceService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.core.utilities.result.SuccessDataResult;
import kodlama.io.hrmsproject.core.utilities.result.SuccessResult;
import kodlama.io.hrmsproject.dataAccess.abstracts.ExperienceDao;
import kodlama.io.hrmsproject.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {
    private ExperienceDao experienceDto;
    @Autowired
    public ExperienceManager(ExperienceDao experienceDto) {
        this.experienceDto = experienceDto;
    }

    @Override
    public Result add(Experience experience) {
        this.experienceDto.save(experience);
        return new SuccessResult("Experience added");
    }

    @Override
    public DataResult<List<Experience>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"workStartingDate");
        return new SuccessDataResult<List<Experience>>(this.experienceDto.findAll(sort));
    }

    @Override
    public DataResult<List<Experience>> getExperienceByWorkStartingDateStartsWith(Date workStartingDate) {
        return new SuccessDataResult<List<Experience>>(this.experienceDto.getExperienceByWorkStartingDateStartsWith(workStartingDate));
    }
}

package kodlama.io.hrmsproject.business.abstracts;

import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Resume;

public interface ResumeService {
    Result add(Resume resume);
    Result delete(int id);
    Result update(int id,Resume resume);
}

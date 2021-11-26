package kodlama.io.hrmsproject.business.abstracts;

import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.entities.concretes.Resume;
import org.springframework.web.multipart.MultipartFile;

public interface ResumeService {
    Result add(Resume resume);
    Result delete(int id);
    Result update(int id,Resume resume);
    Result saveImage(MultipartFile file, int id);
    DataResult<Resume> getResumeById(int id);
}

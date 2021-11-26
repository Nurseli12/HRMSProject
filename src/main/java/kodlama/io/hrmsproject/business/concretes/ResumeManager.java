package kodlama.io.hrmsproject.business.concretes;

import kodlama.io.hrmsproject.business.abstracts.ResumeService;
import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import kodlama.io.hrmsproject.core.utilities.result.Result;
import kodlama.io.hrmsproject.core.utilities.result.SuccessDataResult;
import kodlama.io.hrmsproject.core.utilities.result.SuccessResult;
import kodlama.io.hrmsproject.core.utilities.result.fileuploadvalidator.CloudinaryService;
import kodlama.io.hrmsproject.dataAccess.abstracts.ResumeDao;
import kodlama.io.hrmsproject.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Optional;

@Service
public class ResumeManager implements ResumeService {
    private ResumeDao resumeDto;
    private CloudinaryService cloudinaryService;
    @Autowired
    public ResumeManager(ResumeDao resumeDto) {
        this.resumeDto = resumeDto;
        this.cloudinaryService=cloudinaryService;
    }


    @Override
    public Result add(Resume resume) {
        this.resumeDto.save(resume);
        return new SuccessResult("Resume added");
    }

    @Override
    public Result delete(int id) {
        Optional<Resume> findResume = this.resumeDto.findById(id);
        if(findResume.isPresent())
        {
            Resume deleteResume = findResume.get();
            this.resumeDto.delete(deleteResume);
        }
        return new SuccessResult("Resume deleted");
    }

    @Override
    public Result update(int id, Resume resume) {
        Resume savedResume = this.resumeDto.findById(id).get();
        savedResume.setCoverLetter(resume.getCoverLetter());
        savedResume.setEdications(resume.getEdications());
        savedResume.setExperiences(resume.getExperiences());
        savedResume.setId(resume.getId());
        savedResume.setLanguages(resume.getLanguages());
        savedResume.setGitHubAddress(resume.getGitHubAddress());
        savedResume.setLinkedinAddress(resume.getLinkedinAddress());
        savedResume.setPhoto(resume.getPhoto());
        this.resumeDto.save(savedResume);
        return new SuccessResult("Resume upadted");
    }

    @Override
    public Result saveImage(MultipartFile file, int id) {
        Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
        String imageUrl= uploader.get("url");
        Resume resume = resumeDto.getOne(id);
        resume.setPhoto(imageUrl);
        resumeDto.save(resume);
        return new SuccessResult("Image Saved");
    }

    @Override
    public DataResult<Resume> getResumeById(int id) {
        return new SuccessDataResult<Resume>(this.resumeDto.getResumeById(id));
    }
}

package kodlama.io.hrmsproject.dataAccess.abstracts;

import kodlama.io.hrmsproject.entities.concretes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeDao extends JpaRepository<Resume,Integer> {
    Resume getResumeById(int id);
}

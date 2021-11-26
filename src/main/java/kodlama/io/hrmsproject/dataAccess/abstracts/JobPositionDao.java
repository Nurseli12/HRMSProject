package kodlama.io.hrmsproject.dataAccess.abstracts;

import kodlama.io.hrmsproject.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
    JobPosition getJobPositionById(int id);
}

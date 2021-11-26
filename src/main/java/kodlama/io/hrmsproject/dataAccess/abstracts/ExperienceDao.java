package kodlama.io.hrmsproject.dataAccess.abstracts;

import kodlama.io.hrmsproject.entities.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ExperienceDao extends JpaRepository<Experience,Integer> {
    List<Experience> getExperienceByWorkStartingDateStartsWith(Date workStartingDate);




}

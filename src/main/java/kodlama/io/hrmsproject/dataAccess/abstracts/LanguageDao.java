package kodlama.io.hrmsproject.dataAccess.abstracts;

import kodlama.io.hrmsproject.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageDao extends JpaRepository<Language,Integer> {
}

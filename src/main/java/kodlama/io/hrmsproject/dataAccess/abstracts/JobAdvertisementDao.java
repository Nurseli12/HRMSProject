package kodlama.io.hrmsproject.dataAccess.abstracts;

import kodlama.io.hrmsproject.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    JobAdvertisement getJobAdvertisementById(int id);
    List<JobAdvertisement> findAllByEmployer_IdAndStatusTrue(int id);
    //List<JobAdvertisement> findAllByMaxSalaryBetweenMinSalary(int maxSalary, int minSalary);


}
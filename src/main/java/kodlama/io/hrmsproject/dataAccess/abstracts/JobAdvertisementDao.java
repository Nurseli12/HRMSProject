package kodlama.io.hrmsproject.dataAccess.abstracts;

import kodlama.io.hrmsproject.entities.concretes.JobAdvertisement;
import kodlama.io.hrmsproject.entities.dtos.JobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    JobAdvertisement getJobAdvertisementById(int id);
    List<JobAdvertisement> findAllByEmployer_IdAndStatusTrue(int id);


    @Query("Select new  kodlama.io.hrmsproject.entities.dtos.JobAdvertisementDto"
            + "(  p.numberPosition, p.publishDate, p.endOfJobDate, e.companyName,jo.jobName) "
            + "From Employer e Inner join e.jobAdvertisements p inner join p.jobPosition jo Where p.status='true'")
    List<JobAdvertisementDto> getJobAdvertisementWithEmpDetails();


}
package kodlama.io.hrmsproject.entities.dtos;

import kodlama.io.hrmsproject.entities.concretes.City;
import kodlama.io.hrmsproject.entities.concretes.Employer;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {

    private String jobOfNumberPosition;
    private Date publishDate;
    private Date endOfJobDate;
    private String companyName;
    private String jobName;



}

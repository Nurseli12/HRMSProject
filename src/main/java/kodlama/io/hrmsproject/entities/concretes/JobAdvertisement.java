package kodlama.io.hrmsproject.entities.concretes;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")

public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary")
    private String minSalary;

    @Column(name = "max_salary")
    private String maxSalary;

    @Column(name = "number_position")
    private String numberPosition;

    @Column(name = "end_of_job_date")
    @Temporal(TemporalType.DATE)
    private Date endOfJobDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "publish_date")
    @Temporal(TemporalType.DATE)
    private Date publishDate;

    @Column(name = "full_description")
    private String fullDescription;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City cities;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "jobposition_id")
    private JobPosition jobPosition;


}
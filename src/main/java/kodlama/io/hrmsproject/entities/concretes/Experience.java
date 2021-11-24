package kodlama.io.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="experience_id")
    private int id;

    @Column(name="experience")
    private String workExperience;

    @Column(name="work_end_date")
    private Date workEndDate;

    @Column(name="work_starting_date")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date workStartingDate;

    @Column(name="is_keepon_work")
    private boolean isKeepOnWork;

    @JsonIgnore
    @OneToMany(mappedBy = "experiences")
    private List<Resume> resumes;

}

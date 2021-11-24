package kodlama.io.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "edications")
public class Edication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="edication_id")
    private int id;

    @Column(name="edication")
    private String edication;

    @Column(name="edication_end_date")
    private Date edicationEndDate;

    @Column(name="edication_starting_date")
    private Date edicationStartingndDate;

    @Column(name="graduate")
    private boolean graduate;

    @JsonIgnore
    @OneToMany(mappedBy = "edications")
    private List<Resume> resumes;






}

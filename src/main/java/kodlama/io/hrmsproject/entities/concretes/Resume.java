package kodlama.io.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="resumes")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="resume_id")
    private int id;

    @Column(name="photo")
    private String photo;

    @Column(name="github_address")
    private String gitHubAddress;

    @Column(name="linkedin_address")
    private String linkedinAddress;

    @Column(name="cover_letter")
    private String coverLetter;

    @ManyToOne()
    @JoinColumn(name="experience_id")
    private Experience experiences;

    @ManyToOne()
    @JoinColumn(name="language_id")
    private  Language languages;

    @ManyToOne()
    @JoinColumn(name="edication_id")
    private Edication edications;

}

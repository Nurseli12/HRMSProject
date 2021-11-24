package kodlama.io.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id")
    private int id;

    @Column(name="language")
    private String language;

    @Column(name="language_level")
    private short languageLevel;

    @Column(name="programmer_language")
    private String programmerLanguage;

    @JsonIgnore
    @OneToMany(mappedBy = "languages")
    private List<Resume> resumes;
}

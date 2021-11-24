package kodlama.io.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cities")
@NoArgsConstructor
@AllArgsConstructor

public class City {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "city_name")
    String cityName;

    @OneToMany(mappedBy = "cities")
    @JsonIgnore
    List<JobAdvertisement> jobAdvertisements;


}

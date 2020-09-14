package track.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class TrackFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer id;

    private String duration_ms;
    private Integer loudness;

}

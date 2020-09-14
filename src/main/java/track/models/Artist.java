package track.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist_seq")
    private Integer id;
    private String name;

    @JsonIgnoreProperties("artists")
    @ManyToMany(mappedBy = "artists", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Track> tracks;

    public Artist(){

    }

    public Artist(String name) {
        this.name = name;
    }
}

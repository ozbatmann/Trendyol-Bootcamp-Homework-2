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
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_seq")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "imageID", referencedColumnName = "id")
    private Image cover;

    @JsonIgnoreProperties("albums")
    @ManyToMany(mappedBy = "albums", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Track> tracks;
}

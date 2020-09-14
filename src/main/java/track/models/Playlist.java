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
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playlist_seq")
    private Integer id;
    private String name;

    @JsonIgnoreProperties("playlists")
    @ManyToMany(mappedBy = "playlists", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Track> tracks;




}

package track.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "track_seq")
    private Integer id;
    private String name;
    private String genre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "featureID", referencedColumnName = "id")
    private TrackFeature features;

    @JsonIgnoreProperties("tracks")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "track_artists",
            joinColumns = @JoinColumn(name = "trackID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artistID", referencedColumnName = "id")
    )
    private Set<Artist> artists;

    @JsonIgnoreProperties("tracks")
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "track_albums",
            joinColumns = @JoinColumn(name = "trackID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "albumID", referencedColumnName = "id")
    )
    private Set<Album> albums;

    @JsonIgnoreProperties("tracks")
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "track_playlists",
            joinColumns = @JoinColumn(name = "trackID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "playlistID", referencedColumnName = "id")
    )
    private Set<Playlist> playlists;


    @Builder(toBuilder = true)
    public Track(Integer id, String name, String genre, TrackFeature features, Set<Artist> artists, Set<Album> albums, Set<Playlist> playlists) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.features = features;
        this.artists = artists;
        this.albums = albums;
        this.playlists = playlists;
    }

    public Track(){
    }

}

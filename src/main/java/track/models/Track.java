package track.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Track {

    private Integer id;
    private String name;
    private String genre;

    private TrackFeature features;
    @Singular private List<Artist> artists;
    @Singular private List<Album> albums;
    @Singular private List<Playlist> playlists;

    @Builder(toBuilder = true)
    public Track(@NonNull Integer id, @NonNull String name, @NonNull TrackFeature features, @NonNull List<Artist> artists) {
        this.id = id;
        this.name = name;
        this.features = features;
        this.artists = artists;
    }
}

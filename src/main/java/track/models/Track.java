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
    private List<Artist> artists;
    private List<Album> albums;
    private List<Playlist> playlists;

    @Builder
    public Track(@NonNull String name, @NonNull TrackFeature features, @NonNull List<Artist> artists) {
        this.name = name;
        this.features = features;
        this.artists = artists;
    }
}

package track.dtos;


import lombok.Data;


import track.models.Album;
import track.models.Artist;
import track.models.Playlist;
import track.models.TrackFeature;

import java.util.Set;


@Data
public class TrackDTO {

    private String name;
    private TrackFeature features;
    private Set<Artist> artists;

    private Set<Album> albums;
    private Set<Playlist> playlists;


}

package track.dtos;


import lombok.Data;


import track.models.Artist;
import track.models.TrackFeature;

import java.util.List;


@Data
public class TrackDTO {

    private String name;
    private TrackFeature features;
    private List<Artist> artists;


}

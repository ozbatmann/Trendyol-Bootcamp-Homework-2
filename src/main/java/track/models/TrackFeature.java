package track.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TrackFeature {

    @NonNull
    private String duration_ms;
    @NonNull
    private Integer loudness;

}

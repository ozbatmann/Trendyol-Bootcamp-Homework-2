package track.services;

import org.springframework.stereotype.Service;
import track.dtos.TrackDTO;
import track.models.Track;

import java.util.Collection;


public interface TrackService {

    Track create(TrackDTO trackDTO);
    Track update(Integer id, TrackDTO trackDTO);
    void delete(Integer id);
    Collection<Track> getItems();
    Track getItem(Integer id);
}

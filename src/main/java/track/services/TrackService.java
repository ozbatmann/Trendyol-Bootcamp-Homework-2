package track.services;

import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import track.dtos.TrackDTO;
import track.models.Track;


import java.util.List;


public interface TrackService {

    Track create(TrackDTO trackDTO);
    Track update(Integer id, TrackDTO trackDTO);
    void delete(Integer id);
    List<Track> getItems(Pageable pageable);
    Track getItem(Integer id);

}

package track.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import track.dtos.TrackDTO;
import track.models.Track;
import track.repository.TrackRepository;

import java.util.Collection;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    public TrackRepository trackRepository;


    @Override
    public Track create(TrackDTO trackDTO) {

        Track track = Track.builder()
                .name(trackDTO.getName())
                .features(trackDTO.getFeatures())
                .artists(trackDTO.getArtists())
                .id(trackRepository.trackID).build();


        trackRepository.save(trackRepository.trackID, track);
        return track;
    }

    @Override
    public Track update(Integer id, TrackDTO trackDTO) {

        Track track = trackRepository.data.get(id).toBuilder()
                .name(trackDTO.getName())
                .features(trackDTO.getFeatures())
                .artists(trackDTO.getArtists()).build();

        trackRepository.save(trackRepository.trackID, track);

        return track;
    }

    @Override
    public void delete(Integer id) {

        trackRepository.delete(id);
    }

    @Override
    public Track getItem(Integer id) {
        return trackRepository.data.get(id);
    }
    @Override
    public Collection<Track> getItems() {
        return trackRepository.data.values();
    }
}

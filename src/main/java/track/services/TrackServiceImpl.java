package track.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import track.dtos.TrackDTO;
import track.models.Track;
import track.repository.TrackRepository;

import java.util.Collection;
import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository trackRepository;

//    @Autowired
//    public TrackServiceImpl(TrackRepository trackRepository){
//        this.trackRepository = trackRepository;
//    }

    @Override
    public Track create(TrackDTO trackDTO) {

        Track track = Track.builder()
                .name(trackDTO.getName())
                .features(trackDTO.getFeatures())
                .artists(trackDTO.getArtists()).build();

        trackRepository.save(track);
        return track;
    }

    @Override
    public Track update(Integer id, TrackDTO trackDTO) {

        Track track = trackRepository.findById(id).get().toBuilder()
                .name(trackDTO.getName())
                .features(trackDTO.getFeatures())
                .artists(trackDTO.getArtists())
                .albums(trackDTO.getAlbums())
                .playlists(trackDTO.getPlaylists()).build();

        trackRepository.save(track);

        return track;
    }

    @Override
    public void delete(Integer id) {

        trackRepository.deleteById(id);

    }

    @Override
    public Track getItem(Integer id) {
        return trackRepository.findById(id).get();
    }

    @Override
    public List<Track> getItems(Pageable pageable) {
        return (List<Track>) trackRepository.findAll(pageable);
    }



}

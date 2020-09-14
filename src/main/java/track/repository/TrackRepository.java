package track.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import track.models.Track;

import java.util.List;


@Repository
public interface TrackRepository extends PagingAndSortingRepository<Track, Integer> {

}

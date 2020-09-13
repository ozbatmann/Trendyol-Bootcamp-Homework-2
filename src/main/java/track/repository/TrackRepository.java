package track.repository;

import org.springframework.stereotype.Repository;
import track.models.Track;

import java.util.HashMap;

@Repository
public class TrackRepository {


    public static HashMap<Integer, Track> data = new HashMap<>();
    public static Integer trackID = 0;

    public void save(Integer id, Track track){
        data.put(id, track);
        trackID += 1;
    }

    public void delete(Integer id){
        data.remove(id);
    }


}

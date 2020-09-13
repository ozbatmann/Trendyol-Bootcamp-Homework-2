package track.controllers;

import track.dtos.TrackDTO;


import track.models.Track;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/tracks")
public class TrackController {


    @PostMapping("/")
    public ResponseEntity create(@RequestBody TrackDTO trackDTO){

        Track track = Track.builder()
                .name(trackDTO.getName())
                .features(trackDTO.getFeatures())
                .artists(trackDTO.getArtists()).build();
        return  ResponseEntity.accepted().build();

    }

    @PatchMapping("/tracks/{id}")
    public ResponseEntity update(@PathVariable("id") Integer trackID){
        return  ResponseEntity.accepted().build();
    }

    @DeleteMapping("/tracks/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer trackID){
        return  ResponseEntity.accepted().build();
    }

    @GetMapping()
    public ResponseEntity<TrackDTO> list(@PathVariable Integer pageOffset, @PathVariable Integer pageSize, String name, Integer trackID){
        return  ResponseEntity.accepted().build();
    }
}

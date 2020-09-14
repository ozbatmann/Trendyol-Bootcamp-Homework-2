package track.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import track.dtos.TrackDTO;


import track.models.Track;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import track.services.TrackService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Controller
@RequestMapping("/v1/tracks")
public class TrackController {

    private TrackService trackService;
    private static final Integer DefaultPageSize = 5;

    @Autowired
    public TrackController(TrackService trackService){
        this.trackService = trackService;
    }


    @PostMapping("/")
    public ResponseEntity addItem(@RequestBody TrackDTO trackDTO){


        Track track = trackService.create(trackDTO);
        URI location = URI.create(String.format("/tracks/%d", track.getId()));

        return  ResponseEntity.created(location).build();

    }

    @PatchMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable("id") Integer trackID, @RequestBody TrackDTO trackDTO){

        trackService.update(trackID, trackDTO);

        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable("id") Integer trackID){

        trackService.delete(trackID);

        return  ResponseEntity.noContent().build();
    }

    @GetMapping(value={"/{id}"})
    public ResponseEntity getItem(@PathVariable("id") Integer trackID){

        Track track = trackService.getItem(trackID);

        return  ResponseEntity.ok().body(track);
    }

    @GetMapping(value={"/{pageOffset}&{pageSize}", "/"})
    public ResponseEntity listItems(@PathVariable(required=false) Optional<Integer> pageOffset, @PathVariable(required=false) Optional<Integer> pageSize, String name, Integer trackID){

        Pageable pageRequest;
        if(!(pageOffset.isEmpty() && pageSize.isEmpty())){
            pageRequest = PageRequest.of(0, DefaultPageSize);
        }
        else if(!pageSize.isEmpty()){
             pageRequest = PageRequest.of(0, pageSize.get());

        }
        else{
            pageRequest = PageRequest.of(pageOffset.get(), pageSize.get());
        }

        List<Track> tracks = trackService.getItems(pageRequest);

        return  ResponseEntity.ok().body(tracks);
    }

}

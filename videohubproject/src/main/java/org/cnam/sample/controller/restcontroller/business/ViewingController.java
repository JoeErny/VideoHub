package org.cnam.sample.controller.restcontroller.business;


import org.cnam.sample.controller.dto.*;
import org.cnam.sample.domain.entity.Video;
import org.cnam.sample.domain.entity.Viewing;
import org.cnam.sample.domain.entity.ViewingToCreate;
import org.cnam.sample.domain.service.unitservice.VideoService;
import org.cnam.sample.domain.service.businessservice.ViewingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/view")
public class ViewingController {


    @Autowired
    ViewingService viewingService;

    @Autowired
    VideoService videoService;

    //Va ajouter un visionnage (une vue) à la vidéo
    @PostMapping("/add_view")
    @ResponseBody
    public ResponseEntity<ViewingResponse> addViewing(@RequestBody ViewingRequest viewingRequest) {
        ViewingToCreate viewingToCreate = new ViewingToCreate(viewingRequest.userId, viewingRequest.videoId, new Date());
        Viewing viewingCreated = viewingService.create(viewingToCreate);
        ViewingResponse viewingResponse = new ViewingResponse(viewingCreated.id, viewingCreated.userId, viewingCreated.videoId, viewingCreated.date);
        return new ResponseEntity<>(viewingResponse, HttpStatus.OK);
    }

    @GetMapping("/number_of_views/{video_id}")
    @ResponseBody
    public ResponseEntity<NumberViewsOfVideo> getNumberOfViewFromVideo(@PathVariable("video_id") long video_id) {
        Long numberOfViews = viewingService.countByVideoId(video_id);
        NumberViewsOfVideo numberViewsOfVideo = new NumberViewsOfVideo(video_id, numberOfViews);

        return new ResponseEntity<>(numberViewsOfVideo, HttpStatus.OK);
    }
    //Va ajouter un visionnage à la video et retourner la video
    @PostMapping("/watch_video")
    @ResponseBody
    public ResponseEntity<WatchingResponse> watchVideo(@RequestBody ViewingRequest viewingRequest) {
        ViewingToCreate viewingToCreate = new ViewingToCreate(viewingRequest.userId, viewingRequest.videoId, new Date());
        Viewing viewingCreated = viewingService.create(viewingToCreate);
        Video videoFound = videoService.getById(viewingCreated.videoId);

        WatchingResponse watchingResponse = new WatchingResponse(viewingCreated.id, viewingCreated.userId, viewingCreated.videoId, viewingCreated.date, videoFound.title, videoFound.link, videoFound.category_id);
        return new ResponseEntity<>(watchingResponse, HttpStatus.OK);
    }
}

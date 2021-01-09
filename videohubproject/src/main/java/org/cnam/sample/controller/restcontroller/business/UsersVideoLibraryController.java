package org.cnam.sample.controller.restcontroller.business;

import org.cnam.sample.controller.dto.BrowsingResponse;
import org.cnam.sample.domain.entity.Video;
import org.cnam.sample.domain.service.businessservice.UsersVideoLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class UsersVideoLibraryController {
    @Autowired
    UsersVideoLibraryService usersVideoLibraryService;

    @GetMapping("/users_videos/{user_id}")
    @ResponseBody
    public ResponseEntity<BrowsingResponse> browseVideosByCategoryId(@PathVariable("user_id") long userId) {
        List<Video> videosFound = usersVideoLibraryService.findAllVideosOwnedByUser(userId);
        BrowsingResponse browsingResponse = new BrowsingResponse(videosFound) ;
        return new ResponseEntity<>(browsingResponse, HttpStatus.OK);
    }

}

package org.cnam.sample.controller.restcontroller;


import org.cnam.sample.controller.dto.BrowsingResponse;
import org.cnam.sample.controller.dto.CategoryResponse;
import org.cnam.sample.domain.entity.Category;
import org.cnam.sample.domain.entity.Video;
import org.cnam.sample.domain.service.BrowsingService;
import org.cnam.sample.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/browse")
public class BrowsingController {

    @Autowired
    BrowsingService browsingService;

    @GetMapping("/by_category/{category_id}")
    @ResponseBody
    public ResponseEntity<BrowsingResponse> browseVideosByCategoryId(@PathVariable("category_id") long id) {
        List<Video> categoryFound = browsingService.findAllVideosByCategoryId(id);
        BrowsingResponse browsingResponse = new BrowsingResponse(categoryFound) ;
        return new ResponseEntity<>(browsingResponse, HttpStatus.OK);
    }
}

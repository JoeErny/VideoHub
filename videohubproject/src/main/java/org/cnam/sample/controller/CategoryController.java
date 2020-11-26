package org.cnam.sample.controller;

import org.cnam.sample.controller.dto.CategoryRequest;
import org.cnam.sample.controller.dto.CategoryResponse;
import org.cnam.sample.controller.dto.VideoRequest;
import org.cnam.sample.controller.dto.VideoResponse;
import org.cnam.sample.domain.SERV_Category;
import org.cnam.sample.domain.SERV_Video;
import org.cnam.sample.domain.entity.Category;
import org.cnam.sample.domain.entity.CategoryToCreate;
import org.cnam.sample.domain.entity.Video;
import org.cnam.sample.domain.entity.VideoToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    SERV_Category categoryService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable("id") long id) {
        Category categoryFound = categoryService.getById(id);

        CategoryResponse categoryResponse = new CategoryResponse(categoryFound.id,categoryFound.label);

        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryToRequest) {
        CategoryToCreate categoryToCreate = new CategoryToCreate(categoryToRequest.label);
        Category categoryCreated = categoryService.create(categoryToCreate);
        CategoryResponse categoryResponse = new CategoryResponse(categoryCreated.id, categoryCreated.label);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }
}

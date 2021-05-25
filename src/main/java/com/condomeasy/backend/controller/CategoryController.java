package com.condomeasy.backend.controller;


import com.condomeasy.backend.controller.base.BaseController;
import com.condomeasy.backend.dto.CategoryDTO;
import com.condomeasy.backend.response.Response;
import com.condomeasy.backend.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

import static com.condomeasy.backend.constants.MessageBundle.TRANSACTION_SUCCESFUL;
import static com.condomeasy.backend.util.HttpResponseUtil.getUri;

@RestController
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {


    @Autowired
    private ICategoryService service;

    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody CategoryDTO dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return invalidModelState(bindingResult);

        var responseData = service.save(dto);

        var response = Response.builder()
                .status(201)
                .dateTime(LocalDateTime.now())
                .data(responseData)
                .build();

        var location = getUri(responseData.getId());

        return ResponseEntity.created(location).body(response);

    }

    @GetMapping
    public ResponseEntity<Response> findAll() {
        var responseData = service.findAll();

        var response = Response.builder()
                .status(200)
                .dateTime(LocalDateTime.now())
                .data(responseData)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> findById(@PathVariable("id") Integer id) {
        var responseData = service.findById(id);

        var response = Response.builder()
                .status(200)
                .dateTime(LocalDateTime.now())
                .data(responseData)
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(
            @PathVariable("id") Integer id, @Valid @RequestBody CategoryDTO dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return invalidModelState(bindingResult);

        var responseData = service.update(dto, id);

        var response = Response.builder()
                .status(200)
                .dateTime(LocalDateTime.now())
                .data(responseData)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id) {
        service.delete(id);

        var response = Response.builder()
                .status(200)
                .dateTime(LocalDateTime.now())
                .message(TRANSACTION_SUCCESFUL)
                .build();

        return ResponseEntity.ok(response);
    }
}

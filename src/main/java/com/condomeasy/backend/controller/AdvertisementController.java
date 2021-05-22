package com.condomeasy.backend.controller;

import com.condomeasy.backend.model.Advertisement;
import com.condomeasy.backend.service.impl.AdvertisementService;
import com.condomeasy.backend.util.HttpResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/advertisement")
public class AdvertisementController {

    @Autowired
    private AdvertisementService service;
    private HttpResponseUtil util;


    @GetMapping
    public ResponseEntity<Iterable<Advertisement>> getAll() throws Exception {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getById(@PathVariable("id") Integer id) throws Exception {

        var response = service.findById(id);

        if (response != null){
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Advertisement> updateCondominium(@PathVariable("id") Integer id, @Valid @RequestBody Advertisement a) throws Exception{

        var response = service.update(a, id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCondominium(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.ok(null);
    }

}

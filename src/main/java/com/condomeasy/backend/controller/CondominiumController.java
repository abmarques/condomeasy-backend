package com.condomeasy.backend.controller;

import com.condomeasy.backend.controller.base.BaseController;
import com.condomeasy.backend.dto.CondominiumDTO;
import com.condomeasy.backend.response.Response;
import com.condomeasy.backend.service.ICondominiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;

import static com.condomeasy.backend.util.HttpResponseUtil.getUri;

@RestController
@RequestMapping(value = "/condominium")
public class CondominiumController extends BaseController {

    @Autowired
    private ICondominiumService service;

    @GetMapping
    public ResponseEntity<Response> getAll() {
        var responseData = service.getAll();

        var response = Response.builder()
                .status(200)
                .dateTime(LocalDateTime.now())
                .data(responseData)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody CondominiumDTO dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return invalidModelState(bindingResult);

        var responseData = service.save(dto);

        var response = Response.builder()
                .status(200)
                .dateTime(LocalDateTime.now())
                .data(responseData)
                .build();

        URI location = getUri(responseData.getId());

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") Integer id) {
        var responseData = service.findById(id);

        var response = Response.builder()
                .status(200)
                .dateTime(LocalDateTime.now())
                .data(responseData)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Response> getByName(@PathVariable("name") String name) {
        var responseData = service.findByName(name);

        var response = Response.builder()
                .status(200)
                .dateTime(LocalDateTime.now())
                .data(responseData)
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateCondominium(
            @PathVariable("id") Integer id, @Valid @RequestBody CondominiumDTO dto, BindingResult bindingResult) {

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
    public ResponseEntity<Response> deleteCondominium(@PathVariable Integer id) {
        service.delete(id);

        var response = Response.builder()
                .status(200)
                .dateTime(LocalDateTime.now())
                .message("Transação bem sucedida.")
                .build();

        return ResponseEntity.ok(response);
    }
}

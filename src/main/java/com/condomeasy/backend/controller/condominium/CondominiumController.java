package com.condomeasy.backend.controller.condominium;

import com.condomeasy.backend.dto.condominium.CondominiumDTO;
import com.condomeasy.backend.model.Condominium;
import com.condomeasy.backend.service.condominium.ICondominiumService;
import com.condomeasy.backend.util.HttpResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/condominium")
public class CondominiumController {

    @Autowired
    private ICondominiumService service;

    private HttpResponseUtil util;

    @GetMapping
    public ResponseEntity<Iterable<CondominiumDTO>> getAll() throws Exception {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<CondominiumDTO> saveCondominium(@RequestBody CondominiumDTO c) throws Exception {

        var response = service.save(c);
        URI location = util.getUri(response.getId());

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondominiumDTO> getById(@PathVariable("id") Integer id) throws Exception {
        var response = service.findById(id);
        if (response != null){
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("name/{name}")
    public ResponseEntity<CondominiumDTO> getByName(@PathVariable("name") String name) throws Exception {
        var response = service.findByName(name);
        if (response != null){
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondominiumDTO> updateCondominium(@PathVariable("id") Integer id, @RequestBody CondominiumDTO dto) throws Exception{
        var response = service.update(dto, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCondominium(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.ok(null);
    }
}

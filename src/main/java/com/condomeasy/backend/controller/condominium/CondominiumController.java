package com.condomeasy.backend.controller.condominium;

import com.condomeasy.backend.model.Condominium;
import com.condomeasy.backend.service.condominium.CondominiumService;
import com.condomeasy.backend.service.condominium.ICondominiumService;
import com.condomeasy.backend.util.HttpResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/condominium")
public class CondominiumController {

    @Autowired
    private CondominiumService service;

    private HttpResponseUtil util;

    @GetMapping
    public ResponseEntity<Iterable<Condominium>> getAll() throws Exception {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Condominium> saveCondominium(@Valid @RequestBody Condominium c) throws Exception {

        var response = service.save(c);
        URI location = util.getUri(response.getId());

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Condominium> getById(@PathVariable("id") Integer id) throws Exception {

        var response = service.findById(id);

        if (response != null){
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Condominium> updateCondominium(@PathVariable("id") Integer id, @Valid @RequestBody Condominium c) throws Exception{

        var response = service.update(c, id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCondominium(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.ok(null);
    }

}

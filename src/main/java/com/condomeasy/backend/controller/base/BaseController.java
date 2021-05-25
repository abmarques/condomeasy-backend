package com.condomeasy.backend.controller.base;

import com.condomeasy.backend.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class BaseController {

    public ResponseEntity<Response> invalidModelState(BindingResult result){

        Response response = new Response();

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setDateTime(LocalDateTime.now());
        result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));

        return ResponseEntity.badRequest().body(response);
    }

}

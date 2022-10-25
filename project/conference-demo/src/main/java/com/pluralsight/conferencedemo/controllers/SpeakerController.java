package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.services.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers") //es como la base url para los endpoints de este controller
public class SpeakerController {

    @Autowired
    private SpeakerService service;

    @GetMapping("/all")
    public List<Speaker> findAll() {
        return service.getAllSessions();
    }

    @GetMapping("/{id}")
    public Speaker findSession(@PathVariable Long id) {
        return service.findSession(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody Speaker session) {
        return service.create(session);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/update/{id}")
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        return service.update(id, speaker);
    }
}

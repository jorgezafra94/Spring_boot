package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions") //es como la base url para los endpoints de este controller
public class SessionController {

    @Autowired
    private SessionService service;

    @GetMapping("/all")
    public List<Session> getAllSessions() {
        return service.getAllSessions();
    }

    @GetMapping("/{id}")
    public Session findSession(@PathVariable Long id) {
        return service.findSession(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody Session session) {
        return service.create(session);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PutMapping("/update/{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        return service.update(id, session);
    }
}

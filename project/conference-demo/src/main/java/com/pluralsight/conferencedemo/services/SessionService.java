package com.pluralsight.conferencedemo.services;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private final SessionRepository repository;

    @Autowired
    public SessionService(SessionRepository repository) {
        this.repository = repository;
    }

    public List<Session> getAllSessions() {
        return repository.findAll();
    }

    public Session findSession(Long id) {
        return repository.getReferenceById(id);
    }

    public Session create(Session session) {
        return repository.saveAndFlush(session);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Session update(Long id, Session session) {
        Session actual = repository.getReferenceById(id);
        swapInfo(actual, session);
        return repository.saveAndFlush(actual);
    }

    private void swapInfo(Session actual, Session future) {
        actual.setSession_description(future.getSession_description());
        actual.setSession_name(future.getSession_name());
        actual.setSession_length(future.getSession_length());
        actual.setSpeakers(future.getSpeakers());
    }
}

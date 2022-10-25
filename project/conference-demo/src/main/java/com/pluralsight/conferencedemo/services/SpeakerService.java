package com.pluralsight.conferencedemo.services;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerService {
    private final SpeakerRepository repository;

    @Autowired
    public SpeakerService(SpeakerRepository repository) {
        this.repository = repository;
    }

    public List<Speaker> getAllSessions() {
        return repository.findAll();
    }

    public Speaker findSession(Long id) {
        return repository.getReferenceById(id);
    }

    public Speaker create(Speaker session) {
        return repository.saveAndFlush(session);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Speaker update(Long id, Speaker session) {
        Speaker actual = repository.getReferenceById(id);
        swapInfo(actual, session);
        return repository.saveAndFlush(actual);
    }

    private void swapInfo(Speaker actual, Speaker future) {
        actual.setFirst_name(future.getFirst_name());
        actual.setLast_name(future.getLast_name());
        actual.setTitle(future.getTitle());
        actual.setCompany(future.getCompany());
        actual.setSpeaker_bio(future.getSpeaker_bio());
        actual.setSessions(future.getSessions());
    }
}

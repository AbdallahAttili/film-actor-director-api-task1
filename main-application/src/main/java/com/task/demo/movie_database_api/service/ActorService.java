package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.entity.Actor;
import com.task.demo.movie_database_api.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Page<Actor> getAllActors(Pageable pageable) {
        return actorRepository.findAll(pageable);
    }

    public Optional<Actor> getActorById(String actorId) {
        return actorRepository.findById(actorId);
    }

    public void updateActor(String actorId, Actor newActor) {
        if (actorRepository.existsById(actorId)) {
            actorRepository.deleteById(actorId);
            actorRepository.save(newActor);
        } else {
            throw new IllegalArgumentException("Actor with id " + actorId + " not found!");
        }
    }

    public void deleteActorById(String actorId) {
        actorRepository.deleteById(actorId);
    }

}

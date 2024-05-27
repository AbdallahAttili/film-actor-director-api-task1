package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.entity.Actor;
import com.task.demo.movie_database_api.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Page<Actor> getAllActors(Pageable pageable) {
        return actorRepository.findAll(pageable);
    }

    @Override
    public Optional<Actor> getActorById(String actorId) {
        return actorRepository.findById(actorId);
    }

    @Override
    public void updateActor(String actorId, Actor newActor) {
        if (actorRepository.existsById(actorId)) {
            actorRepository.deleteById(actorId);
            actorRepository.save(newActor);
        } else {
            throw new IllegalArgumentException("Actor with id " + actorId + " not found!");
        }
    }

    @Override
    public void deleteActorById(String actorId) {
        actorRepository.deleteById(actorId);
    }

}

package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.dao.ActorRepositoryImpl;
import com.task.demo.movie_database_api.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepositoryImpl actorRepositoryImpl;

    @Autowired
    public ActorServiceImpl(ActorRepositoryImpl actorRepositoryImpl) {
        this.actorRepositoryImpl = actorRepositoryImpl;
    }

    @Override
    public Actor createActor(Actor actor) {
        return actorRepositoryImpl.save(actor);
    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepositoryImpl.findAll();
    }

    @Override
    public Actor getActorById(String actorId) {
        return actorRepositoryImpl.findById(actorId);
    }

    @Override
    public void updateActor(Actor newActor) {
        actorRepositoryImpl.existsById(newActor);
    }

    @Override
    public void deleteActorById(String actorId) {
        actorRepositoryImpl.deleteById(actorId);
    }

}

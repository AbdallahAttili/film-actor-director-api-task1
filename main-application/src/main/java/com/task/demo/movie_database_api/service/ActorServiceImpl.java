package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.dao.ActorRepositoryImpl;
import com.task.demo.movie_database_api.model.Actor;
import org.bson.types.ObjectId;
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
    public Actor getActorByName(String actorName) {
        return actorRepositoryImpl.findByName(actorName);
    }

    @Override
    public void updateActor(String actorId, Actor newActor) {
        actorRepositoryImpl.existsById(actorId, newActor);
    }

    @Override
    public void deleteActorById(ObjectId actorId) {
        actorRepositoryImpl.deleteById(actorId);
    }

}

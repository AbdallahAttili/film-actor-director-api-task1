package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.model.Actor;

import java.util.List;

public interface ActorService {

    Actor createActor(Actor actor);

    List<Actor> getAllActors();

    Actor getActorById(String actorId);

    void updateActor(Actor newActor);

    void deleteActorById(String actorId);
}

package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.model.Actor;
import org.bson.types.ObjectId;

import java.util.List;

public interface ActorService {

    Actor createActor(Actor actor);

    List<Actor> getAllActors();

    Actor getActorByName(String actorName);

    void updateActor(String actorId, Actor newActor);

    void deleteActorById(ObjectId actorId);
}

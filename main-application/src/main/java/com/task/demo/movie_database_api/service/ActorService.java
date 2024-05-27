package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ActorService {

    Actor createActor(Actor actor);

    Page<Actor> getAllActors(Pageable pageable);

    Optional<Actor> getActorById(String actorId);

    void updateActor(String actorId, Actor newActor);

    void deleteActorById(String actorId);
}

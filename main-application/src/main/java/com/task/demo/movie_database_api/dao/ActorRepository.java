package com.task.demo.movie_database_api.dao;

import com.task.demo.movie_database_api.model.Actor;

import java.util.List;


public interface ActorRepository {

    Actor save(Actor actor);

    List<Actor> findAll();

    Actor findById(String actorId);

    void existsById(Actor actor);

    void deleteById(String actorId);
}

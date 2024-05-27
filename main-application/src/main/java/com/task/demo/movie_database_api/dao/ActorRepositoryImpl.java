package com.task.demo.movie_database_api.dao;

import com.task.demo.movie_database_api.model.Actor;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActorRepositoryImpl implements ActorRepository {

    private final Datastore datastore;

    @Autowired
    public ActorRepositoryImpl(Datastore datastore) {
        this.datastore = datastore;
    }

    @Override
    public Actor save(Actor actor) {
        datastore.save(actor);
        return actor;
    }

    @Override
    public List<Actor> findAll() {
        return datastore.find(Actor.class).asList();
    }

    @Override
    public Actor findById(String actorId) {
        return datastore.find(Actor.class)
                .field("_id")
                .equal(actorId)
                .first();
    }

    @Override
    public void existsById(Actor actor) {
        datastore.save(actor);
    }

    @Override
    public void deleteById(String actorId) {
        Query<Actor> query = datastore.createQuery(Actor.class)
                .field("_id")
                .equal(actorId);
        datastore.delete(query);
    }
}


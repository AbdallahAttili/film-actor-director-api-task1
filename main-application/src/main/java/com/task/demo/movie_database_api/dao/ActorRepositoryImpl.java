package com.task.demo.movie_database_api.dao;

import com.task.demo.movie_database_api.model.Actor;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import org.bson.types.ObjectId;
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
    public Actor findByName(String actorName) {
        Query<Actor> findByNameQuery = datastore.createQuery(Actor.class)
                .field("name")
                .equal(actorName);

        if (findByNameQuery == null) throw new IllegalArgumentException("Actor name " + actorName + " can't be found!");

        return findByNameQuery.first();
    }

    @Override
    public void existsById(String actorId, Actor newActor) {
        Query<Actor> query = datastore.createQuery(Actor.class)
                .field("_id")
                .equal(actorId);

        if (query == null) throw new IllegalArgumentException("Actor id " + actorId + " can't be found!");

        datastore.delete(query);
        datastore.save(newActor);
    }

    @Override
    public void deleteById(ObjectId actorId) {
        Query<Actor> query = datastore.createQuery(Actor.class)
                .field("_id")
                .equal(actorId);

        if (query == null) throw new IllegalArgumentException("Actor id " + actorId + " can't be found!");

        datastore.delete(query);
    }
}


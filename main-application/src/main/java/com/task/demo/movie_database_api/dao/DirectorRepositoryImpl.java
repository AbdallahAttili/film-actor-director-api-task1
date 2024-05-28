package com.task.demo.movie_database_api.dao;

import com.task.demo.movie_database_api.model.Director;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DirectorRepositoryImpl implements DirectorRepository {

    private final Datastore datastore;

    @Autowired
    public DirectorRepositoryImpl(Datastore datastore) {
        this.datastore = datastore;
    }


    @Override
    public Director save(Director director) {
        datastore.save(director);

        return director;
    }

    @Override
    public List<Director> findAll() {
        return datastore.find(Director.class).asList();
    }

    @Override
    public Director findByName(String directorName) {
        return datastore.find(Director.class)
                .field("_id")
                .equal(directorName)
                .first();
    }

    @Override
    public void existsById(String directorId, Director newDirector) {
        Query<Director> findByIdQuery = datastore.createQuery(Director.class)
                .field("_id")
                .equal(directorId);

        if (findByIdQuery == null) throw new IllegalArgumentException("Director id " + directorId + " can't be found!");

        datastore.delete(findByIdQuery);
        datastore.save(newDirector);
    }

    @Override
    public void deleteById(ObjectId directorId) {
        Query<Director> query = datastore.createQuery(Director.class)
                .field("_id")
                .equal(directorId);
        datastore.delete(query);
    }
}

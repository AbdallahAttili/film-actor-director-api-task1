package com.task.demo.movie_database_api.dao;

import com.task.demo.movie_database_api.model.Director;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
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
    public Director findById(String directorId) {
        return datastore.find(Director.class)
                .field("_id")
                .equal(directorId)
                .first();
    }

    @Override
    public void existsById(Director director) {
        datastore.save(director);
    }

    @Override
    public void deleteById(String directorId) {
        Query<Director> query = datastore.createQuery(Director.class)
                .field("_id")
                .equal(directorId);
        datastore.delete(query);
    }
}

package com.task.demo.movie_database_api.dao;

import com.task.demo.movie_database_api.model.Film;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmRepositoryImpl implements FilmRepository {

    private final Datastore datastore;

    @Autowired
    public FilmRepositoryImpl(Datastore datastore) {
        this.datastore = datastore;
    }

    @Override
    public Film save(Film film) {
        datastore.save(film);
        return film;
    }

    @Override
    public List<Film> findAll() {
        return datastore.find(Film.class).asList();
    }

    @Override
    public Film findByName(String filmName) {
        return datastore.find(Film.class)
                .field("name")
                .equal(filmName)
                .first();
    }

    @Override
    public void existsById(String filmId, Film newFilm) {
        Query<Film> findByIdQuery = datastore.createQuery(Film.class)
                .field("_id")
                .equal(filmId);

        if (findByIdQuery == null) throw new IllegalArgumentException("Film id " + filmId + " can't be found!");

        datastore.delete(findByIdQuery);
        datastore.save(newFilm);
    }

    @Override
    public void deleteById(ObjectId filmId) {
        Query<Film> query = datastore.createQuery(Film.class)
                .field("_id")
                .equal(filmId);

        if (query == null) throw new IllegalArgumentException("Film id " + filmId + " can't be found!");

        datastore.delete(query);
    }
}

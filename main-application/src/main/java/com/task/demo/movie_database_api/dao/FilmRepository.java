package com.task.demo.movie_database_api.dao;

import com.task.demo.movie_database_api.model.Film;
import org.bson.types.ObjectId;

import java.util.List;

public interface FilmRepository {

    Film save(Film film);

    List<Film> findAll();

    Film findById(ObjectId filmId);

    void existsById(String filmId, Film newFilm);

    void deleteById(ObjectId filmId);
}

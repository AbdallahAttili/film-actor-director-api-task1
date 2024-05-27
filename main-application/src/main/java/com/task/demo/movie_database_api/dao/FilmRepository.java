package com.task.demo.movie_database_api.dao;

import com.task.demo.movie_database_api.model.Film;

import java.util.List;

public interface FilmRepository {

    Film save(Film film);

    List<Film> findAll();

    Film findById(String filmId);

    void existsById(Film newFilm);

    void deleteById(String filmId);
}

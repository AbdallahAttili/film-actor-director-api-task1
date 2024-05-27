package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.model.Film;

import java.util.List;

public interface FilmService {

    Film createFilm(Film film);

    List<Film> getAllFilms();

    Film getFilmById(String filmId);

    void updateFilm(Film newFilm);

    void deleteFilmById(String filmId);
}

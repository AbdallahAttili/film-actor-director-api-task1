package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.model.Film;
import org.bson.types.ObjectId;

import java.util.List;

public interface FilmService {

    Film createFilm(Film film);

    List<Film> getAllFilms();

    Film getFilmByName(String filmName);

    void updateFilm(String filmId, Film newFilm);

    void deleteFilmById(ObjectId filmId);
}

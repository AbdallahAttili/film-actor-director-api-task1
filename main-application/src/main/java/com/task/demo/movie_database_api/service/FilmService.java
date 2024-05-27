package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FilmService {

    Film createFilm(Film film);

    Page<Film> getAllFilms(Pageable pageable);

    Optional<Film> getFilmById(String filmId);

    void updateFilm(String filmId, Film newFilm);

    void deleteFilmById(String filmId);


}

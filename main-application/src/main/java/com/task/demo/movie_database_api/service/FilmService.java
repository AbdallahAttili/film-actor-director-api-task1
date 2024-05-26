package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.entity.Film;
import com.task.demo.movie_database_api.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    public Page<Film> getAllFilms(Pageable pageable) {
        return filmRepository.findAll(pageable);
    }

    public Optional<Film> getFilmById(String filmId) {
        return filmRepository.findById(filmId);
    }


    public void updateFilm(String filmId, Film newFilm) {
        if (filmRepository.existsById(filmId)) {
            filmRepository.deleteById(filmId);
            filmRepository.save(newFilm);
        } else {
            throw new IllegalArgumentException("This id " + filmId + " can't be found!");
        }
    }

    public void deleteFilmById(String filmId) {
        filmRepository.deleteById(filmId);
    }
}

package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.model.Film;
import com.task.demo.movie_database_api.dao.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Page<Film> getAllFilms(Pageable pageable) {
        return filmRepository.findAll(pageable);
    }

    @Override
    public Optional<Film> getFilmById(String filmId) {
        return filmRepository.findById(filmId);
    }

    @Override
    public void updateFilm(String filmId, Film newFilm) {
        if (filmRepository.existsById(filmId)) {
            filmRepository.deleteById(filmId);
            filmRepository.save(newFilm);
        } else {
            throw new IllegalArgumentException("This id " + filmId + " can't be found!");
        }
    }

    @Override
    public void deleteFilmById(String filmId) {
        filmRepository.deleteById(filmId);
    }
}

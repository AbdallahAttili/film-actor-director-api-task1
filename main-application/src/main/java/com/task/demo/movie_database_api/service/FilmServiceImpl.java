package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.dao.FilmRepositoryImpl;
import com.task.demo.movie_database_api.model.Film;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepositoryImpl filmRepositoryImpl;

    @Autowired
    public FilmServiceImpl(FilmRepositoryImpl filmRepositoryImpl) {
        this.filmRepositoryImpl = filmRepositoryImpl;
    }

    @Override
    public Film createFilm(Film film) {
        return filmRepositoryImpl.save(film);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepositoryImpl.findAll();
    }

    @Override
    public Film getFilmById(ObjectId filmId) {
        return filmRepositoryImpl.findById(filmId);
    }

    @Override
    public void updateFilm(Film newFilm) {
        filmRepositoryImpl.existsById(newFilm);
    }

    @Override
    public void deleteFilmById(ObjectId filmId) {
        filmRepositoryImpl.deleteById(filmId);
    }
}

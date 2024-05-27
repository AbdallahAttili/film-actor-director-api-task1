package com.task.demo.movie_database_api.controller;

import com.task.demo.movie_database_api.model.Film;
import com.task.demo.movie_database_api.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    private FilmServiceImpl filmServiceImpl;

    @Autowired
    public FilmController(FilmServiceImpl filmServiceImpl) {
        this.filmServiceImpl = filmServiceImpl;
    }

    @GetMapping
    public List<Film> getAllFilms() {
        return filmServiceImpl.getAllFilms();
    }

    @GetMapping("/{filmId}")
    public Film getFilmById(@PathVariable String filmId) {
        return filmServiceImpl.getFilmById(filmId);
    }

    @PostMapping
    public Film createFilm(@RequestBody Film film) {
        return filmServiceImpl.createFilm(film);
    }

    @PutMapping("/{filmId}")
    public void updateFilm(@RequestBody Film newFilm) {
        filmServiceImpl.updateFilm(newFilm);
    }

    @DeleteMapping("/{filmId}")
    public void deleteFilmById(@PathVariable String filmId) {
        filmServiceImpl.deleteFilmById(filmId);
    }
}

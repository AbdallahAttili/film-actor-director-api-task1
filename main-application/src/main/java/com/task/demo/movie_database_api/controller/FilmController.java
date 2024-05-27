package com.task.demo.movie_database_api.controller;

import com.task.demo.movie_database_api.model.Film;
import com.task.demo.movie_database_api.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    private FilmServiceImpl filmServiceImpl;

    @Autowired
    public FilmController(FilmServiceImpl filmServiceImpl) {
        this.filmServiceImpl = filmServiceImpl;
    }

    @GetMapping
    public Page<Film> getAllFilms(Pageable pageable) {
        return filmServiceImpl.getAllFilms(pageable);
    }

    @GetMapping("/{filmId}")
    public Optional<Film> getFilmById(@PathVariable String filmId) {
        return filmServiceImpl.getFilmById(filmId);
    }

    @PostMapping
    public Film createFilm(@RequestBody Film film) {
        return filmServiceImpl.createFilm(film);
    }

    @PutMapping("/{filmId}")
    public void updateFilm(@PathVariable String filmId, @RequestBody Film newFilm) {
        filmServiceImpl.updateFilm(filmId, newFilm);
    }

    @DeleteMapping("/{filmId}")
    public void deleteFilmById(@PathVariable String filmId) {
        filmServiceImpl.deleteFilmById(filmId);
    }
}

package com.task.demo.movie_database_api.controller;

import com.task.demo.movie_database_api.model.Film;
import com.task.demo.movie_database_api.service.FilmServiceImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    private final FilmServiceImpl filmServiceImpl;


    @Autowired
    public FilmController(FilmServiceImpl filmServiceImpl) {
        this.filmServiceImpl = filmServiceImpl;
    }

    /**
     * creates a film of type Film object
     *
     * @param film of type Film
     * @return Film object
     */
    @PostMapping
    public Film createFilm(@RequestBody Film film) {
        return filmServiceImpl.createFilm(film);
    }

    /**
     * retrieves a film by its name
     *
     * @param name of type String
     * @return Film object
     */
    @GetMapping("/search")
    public Film getFilmById(@RequestParam("name") String name) {
        return filmServiceImpl.getFilmByName(name);
    }


    /**
     * retrieves all films
     *
     * @return List<Film>
     */
    @GetMapping
    public List<Film> getAllFilms() {
        return filmServiceImpl.getAllFilms();
    }


    /**
     * updates film by its id
     *
     * @param filmId  of type String
     * @param newFilm of type Film object
     */
    @PutMapping("/{filmId}")
    public void updateFilm(@PathVariable String filmId, @RequestBody Film newFilm) {
        filmServiceImpl.updateFilm(filmId, newFilm);
    }

    /**
     * deletes a film using its id
     *
     * @param filmId of type ObjectId
     */
    @DeleteMapping("/{filmId}")
    public void deleteFilmById(@PathVariable ObjectId filmId) {
        filmServiceImpl.deleteFilmById(filmId);
    }
}

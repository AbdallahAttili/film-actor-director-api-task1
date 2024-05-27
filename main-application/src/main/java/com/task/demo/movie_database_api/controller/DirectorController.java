package com.task.demo.movie_database_api.controller;

import com.task.demo.movie_database_api.model.Director;
import com.task.demo.movie_database_api.service.DirectorServiceImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/director")
public class DirectorController {

    private final DirectorServiceImpl directorServiceImpl;

    @Autowired
    public DirectorController(DirectorServiceImpl directorServiceImpl) {
        this.directorServiceImpl = directorServiceImpl;
    }

    @GetMapping
    public List<Director> getAllDirectors() {
        return directorServiceImpl.getAllDirectors(); // Returns a list of all directors
    }

    @GetMapping("/{directorId}")
    public Director getDirectorById(@PathVariable ObjectId directorId) {
        return directorServiceImpl.getDirectorById(directorId); // Returns a director by their ID
    }

    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorServiceImpl.createDirector(director);
    }

    @PutMapping()
    public void updateDirector(@RequestBody Director newDirector) {
        directorServiceImpl.updateDirector(newDirector);
    }

    @DeleteMapping("/{directorId}")
    public void deleteDirectorById(@PathVariable ObjectId directorId) {
        directorServiceImpl.deleteDirectorById(directorId);
    }
}

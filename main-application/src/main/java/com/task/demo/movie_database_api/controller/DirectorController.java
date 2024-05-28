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
        return directorServiceImpl.getAllDirectors();
    }

    @GetMapping("/search")
    public Director getDirectorByName(@RequestParam("directorName") String directorName) {
        return directorServiceImpl.getDirectorByName(directorName);
    }

    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorServiceImpl.createDirector(director);
    }

    @PutMapping("/{directorId}")
    public void updateDirector(@PathVariable String directorId, @RequestBody Director newDirector) {
        directorServiceImpl.updateDirector(directorId, newDirector);
    }

    @DeleteMapping("/{directorId}")
    public void deleteDirectorById(@PathVariable ObjectId directorId) {
        directorServiceImpl.deleteDirectorById(directorId);
    }
}

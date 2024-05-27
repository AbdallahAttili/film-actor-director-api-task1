package com.task.demo.movie_database_api.controller;

import com.task.demo.movie_database_api.entity.Director;
import com.task.demo.movie_database_api.service.DirectorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/director")
public class DirectorController {

    private DirectorServiceImpl directorServiceImpl;

    @Autowired
    public DirectorController(DirectorServiceImpl directorServiceImpl) {
        this.directorServiceImpl = directorServiceImpl;
    }

    @GetMapping
    public Page<Director> getAllDirectors(Pageable pageable) {
        return directorServiceImpl.getAllDirectors(pageable); // Returns a list of all directors
    }

    @GetMapping("/{directorId}")
    public Optional<Director> getDirectorById(@PathVariable String directorId) {
        return directorServiceImpl.getDirectorById(directorId); // Returns a director by their ID
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
    public void deleteDirectorById(@PathVariable String directorId) {
        directorServiceImpl.deleteDirectorById(directorId);
    }
}

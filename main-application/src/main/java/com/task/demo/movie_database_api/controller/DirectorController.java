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

    /**
     * creates a new director
     *
     * @param director of type Director object
     * @return Director object
     */
    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorServiceImpl.createDirector(director);
    }

    /**
     * retrieves the director by its name
     *
     * @param name of type string
     * @return Director Object
     */
    @GetMapping("/search")
    public Director getDirectorByName(@RequestParam("name") String name) {
        return directorServiceImpl.getDirectorByName(name);
    }

    /**
     * retrieves all directors
     *
     * @return List<Director>
     */
    @GetMapping
    public List<Director> getAllDirectors() {
        return directorServiceImpl.getAllDirectors();
    }


    /**
     * updates director using its id
     *
     * @param directorId  of type String
     * @param newDirector of type Director object
     */
    @PutMapping("/{directorId}")
    public void updateDirector(@PathVariable String directorId, @RequestBody Director newDirector) {
        directorServiceImpl.updateDirector(directorId, newDirector);
    }

    /**
     * deletes a director
     *
     * @param directorId of type ObjectId
     */
    @DeleteMapping("/{directorId}")
    public void deleteDirectorById(@PathVariable ObjectId directorId) {
        directorServiceImpl.deleteDirectorById(directorId);
    }
}

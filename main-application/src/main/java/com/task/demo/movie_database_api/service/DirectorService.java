package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.model.Director;
import org.bson.types.ObjectId;

import java.util.List;

public interface DirectorService {

    Director createDirector(Director director);

    Director getDirectorById(ObjectId directorId);

    List<Director> getAllDirectors();

    void updateDirector(String directorId, Director newDirector);

    void deleteDirectorById(ObjectId directorId);
}

package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.model.Director;

import java.util.List;

public interface DirectorService {

    Director createDirector(Director director);

    Director getDirectorById(String directorId);

    List<Director> getAllDirectors();

    void updateDirector(Director newDirector);

    void deleteDirectorById(String directorId);
}

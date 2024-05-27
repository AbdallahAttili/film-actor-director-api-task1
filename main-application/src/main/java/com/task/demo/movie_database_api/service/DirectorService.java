package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.model.Director;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface DirectorService {

    Director createDirector(Director director);

    Optional<Director> getDirectorById(String directorId);

    Page<Director> getAllDirectors(Pageable pageable);

    void updateDirector(String directorId, Director newDirector);

    void deleteDirectorById(String directorId);
}

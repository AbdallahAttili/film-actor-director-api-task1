package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.entity.Director;
import com.task.demo.movie_database_api.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;


    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }


    public Page<Director> getAllDirectors(Pageable pageable) {
        return directorRepository.findAll(pageable);
    }


    public Optional<Director> getDirectorById(String directorId) {
        return directorRepository.findById(directorId);
    }


    public void updateDirector(String directorId, Director newDirector) {
        if (directorRepository.existsById(directorId)) {
            directorRepository.deleteById(directorId);
            directorRepository.save(newDirector);
        } else {
            throw new IllegalArgumentException("This director id " + directorId + " Can't be found!");
        }
    }


    public void deleteDirectorById(String directorId) {
        directorRepository.deleteById(directorId);
    }
}

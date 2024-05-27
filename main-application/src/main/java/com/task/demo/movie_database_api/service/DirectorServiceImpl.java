package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.model.Director;
import com.task.demo.movie_database_api.dao.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {

    private DirectorRepository directorRepository;

    @Autowired
    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Page<Director> getAllDirectors(Pageable pageable) {
        return directorRepository.findAll(pageable);
    }

    @Override
    public Optional<Director> getDirectorById(String directorId) {
        return directorRepository.findById(directorId);
    }


    @Override
    public void updateDirector(String directorId, Director newDirector) {
        if (directorRepository.existsById(directorId)) {
            directorRepository.deleteById(directorId);
            directorRepository.save(newDirector);
        } else {
            throw new IllegalArgumentException("This director id " + directorId + " Can't be found!");
        }
    }

    @Override
    public void deleteDirectorById(String directorId) {
        directorRepository.deleteById(directorId);
    }
}

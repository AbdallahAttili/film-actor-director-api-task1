package com.task.demo.movie_database_api.service;

import com.task.demo.movie_database_api.dao.DirectorRepositoryImpl;
import com.task.demo.movie_database_api.model.Director;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepositoryImpl directorRepositoryImpl;

    @Autowired
    public DirectorServiceImpl(DirectorRepositoryImpl directorRepositoryImpl) {
        this.directorRepositoryImpl = directorRepositoryImpl;
    }

    @Override
    public Director createDirector(Director director) {
        return directorRepositoryImpl.save(director);
    }

    @Override
    public List<Director> getAllDirectors() {
        return directorRepositoryImpl.findAll();
    }

    @Override
    public Director getDirectorById(ObjectId directorId) {
        return directorRepositoryImpl.findById(directorId);
    }


    @Override
    public void updateDirector(Director newDirector) {
        directorRepositoryImpl.existsById(newDirector);
    }

    @Override
    public void deleteDirectorById(ObjectId directorId) {
        directorRepositoryImpl.deleteById(directorId);
    }
}

package com.task.demo.movie_database_api.dao;

import com.task.demo.movie_database_api.model.Director;
import org.bson.types.ObjectId;

import java.util.List;

public interface DirectorRepository {

    Director save(Director director);

    List<Director> findAll();

    Director findById(ObjectId directorId);

    void existsById(String directorId, Director director);

    void deleteById(ObjectId DirectorId);
}

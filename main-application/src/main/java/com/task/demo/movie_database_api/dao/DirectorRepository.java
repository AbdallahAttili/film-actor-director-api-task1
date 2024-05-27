package com.task.demo.movie_database_api.dao;

import com.task.demo.movie_database_api.model.Director;

import java.util.List;

public interface DirectorRepository {

    Director save(Director director);

    List<Director> findAll();

    Director findById(String directorId);

    void existsById(Director director);

    void deleteById(String DirectorId);
}

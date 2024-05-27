package com.task.demo.movie_database_api.dao;

import com.task.demo.movie_database_api.model.Director;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends MongoRepository<Director, String> {

}

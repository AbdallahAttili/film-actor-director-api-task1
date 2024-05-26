package com.task.demo.movie_database_api.repository;

import com.task.demo.movie_database_api.entity.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {

}

package com.task.demo.movie_database_api.repository;

import com.forbes.task.the.first.task.entity.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Indicates that this interface is a repository component in Spring
public interface FilmRepository extends MongoRepository<Film, String> {
    // This interface provides CRUD operations for the Film entity
}

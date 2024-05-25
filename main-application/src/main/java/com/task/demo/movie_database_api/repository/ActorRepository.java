package com.task.demo.movie_database_api.repository;

import com.task.demo.movie_database_api.entity.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Indicates that this interface is a repository component in Spring Boot
public interface ActorRepository extends MongoRepository<Actor, String> {
    // This interface provides CRUD operations for the Actor entity
}

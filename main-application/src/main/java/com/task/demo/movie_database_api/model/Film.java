package com.task.demo.movie_database_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "films")
public class Film {

    @Id
    private ObjectId id;
    private String name;
    private String description;
    private String size;
    private LocalDateTime uploadDate;
    private LocalDateTime lastModifiedDate;
    @DBRef
    Set<Actor> actors;
    @DBRef
    Set<Director> directors;
}

package com.task.demo.movie_database_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String filmId;
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

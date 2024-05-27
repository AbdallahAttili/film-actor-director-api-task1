package com.task.demo.movie_database_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "actors")
public class Actor {

    @Id
    private String actorId;
    private String name;
    private int age;
    private String nickName;
    private String nationality;
    private LocalDateTime birthDate;
    private String photoUrl;
}

package com.task.demo.movie_database_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "directors")
public class Director {

    @Id
    private ObjectId id;
    private String name;
    private int age;
    private String nickName;
    private LocalDateTime birthDate;
    private String nationality;
    private String photoUrl;
}

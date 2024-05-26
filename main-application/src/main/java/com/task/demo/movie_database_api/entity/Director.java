package com.task.demo.movie_database_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "directors")
public class Director {

    @Id
    private String directorId;
    private String name;
    private int age;
    private String nickName;
    private LocalDateTime birthDate;
    private String nationality;
    private String photoUrl;

}

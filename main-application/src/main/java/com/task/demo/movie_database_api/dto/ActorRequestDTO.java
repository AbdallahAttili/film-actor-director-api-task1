package com.task.demo.movie_database_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorRequestDTO {

    private String actorId;
    private String name;
    private int age;
    private String nickName;
    private LocalDateTime birthDate;
    private String photoUrl;
}

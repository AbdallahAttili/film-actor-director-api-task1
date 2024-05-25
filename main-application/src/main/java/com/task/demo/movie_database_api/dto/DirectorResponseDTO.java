package com.task.demo.movie_database_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorResponseDTO {

    private String id;
    private String name;
    private LocalDateTime birthDate;
    private String nationality;
    private String photoUrl;
}

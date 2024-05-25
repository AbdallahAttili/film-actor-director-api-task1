package com.task.demo.movie_database_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmRequestDTO {

    private String id;
    private String name;
    private String description;
    private long size;
    private LocalDateTime uploadDate;
    private LocalDateTime lastModifiedDate;
    private String owner;
}

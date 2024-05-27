package com.task.demo.movie_database_api.configuration;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MorphiaConfig {
    @Bean
    public Datastore datastore() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("com/task/demo/movie_database_api/model");
        return morphia.createDatastore(new MongoClient("localhost", 27017), "first-adventure-db");
    }
}

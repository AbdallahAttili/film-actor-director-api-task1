package com.task.demo.movie_database_api.controller;

import com.task.demo.movie_database_api.model.Actor;
import com.task.demo.movie_database_api.service.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/actor")
public class ActorController {

    private final ActorServiceImpl actorServiceImpl;

    @Autowired
    public ActorController(ActorServiceImpl actorServiceImpl) {
        this.actorServiceImpl = actorServiceImpl;
    }

    @PostMapping
    public Actor createActor(@RequestBody Actor actor) {
        return actorServiceImpl.createActor(actor); // Creates a new actor
    }

    @GetMapping
    public List<Actor> getAllActors() {
        return actorServiceImpl.getAllActors();
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable String id) {
        return actorServiceImpl.getActorById(id);
    }

    @PutMapping()
    public void updateActor(@RequestBody Actor actor) {
        actorServiceImpl.updateActor(actor); // Updates an existing actor
    }

    @DeleteMapping("/{actorId}")
    public void deleteActorById(@PathVariable String actorId) {
        actorServiceImpl.deleteActorById(actorId);
    }
}

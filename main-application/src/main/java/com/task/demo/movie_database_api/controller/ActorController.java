package com.task.demo.movie_database_api.controller;

import com.task.demo.movie_database_api.model.Actor;
import com.task.demo.movie_database_api.service.ActorServiceImpl;
import org.bson.types.ObjectId;
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
    public Actor getActorById(@PathVariable ObjectId id) {
        return actorServiceImpl.getActorById(id);
    }

    @PutMapping("/{actorId}")
    public void updateActor(@PathVariable String actorId, @RequestBody Actor newActor) {
        actorServiceImpl.updateActor(actorId, newActor); // Updates an existing actor
    }

    @DeleteMapping("/{actorId}")
    public void deleteActorById(@PathVariable ObjectId actorId) {
        actorServiceImpl.deleteActorById(actorId);
    }
}

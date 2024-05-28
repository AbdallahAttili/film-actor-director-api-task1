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
        return actorServiceImpl.createActor(actor);
    }

    @GetMapping
    public List<Actor> getAllActors() {
        return actorServiceImpl.getAllActors();
    }

    @GetMapping("/search")
    public Actor getActorByName(@RequestParam("name") String actorName) {
        return actorServiceImpl.getActorByName(actorName);
    }

    @PutMapping("/{actorId}")
    public void updateActor(@PathVariable String actorId, @RequestBody Actor newActor) {
        actorServiceImpl.updateActor(actorId, newActor);
    }

    @DeleteMapping("/{actorId}")
    public void deleteActorById(@PathVariable ObjectId actorId) {
        actorServiceImpl.deleteActorById(actorId);
    }
}

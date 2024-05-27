package com.task.demo.movie_database_api.controller;

import com.task.demo.movie_database_api.entity.Actor;
import com.task.demo.movie_database_api.service.ActorService;
import com.task.demo.movie_database_api.service.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/actor")
public class ActorController {

    private ActorServiceImpl actorServiceImpl;

    @Autowired
    public ActorController(ActorServiceImpl actorServiceImpl) {
        this.actorServiceImpl = actorServiceImpl;
    }

    @PostMapping
    public Actor createActor(@RequestBody Actor actor) {
        return actorServiceImpl.createActor(actor); // Creates a new actor
    }

    @GetMapping
    public Page<Actor> getAllActors(Pageable pageable) {
        return actorServiceImpl.getAllActors(pageable);
    }

    @GetMapping("/{id}")
    public Optional<Actor> getActorById(@PathVariable String id) {
        return actorServiceImpl.getActorById(id);
    }

    @PutMapping("/{actorId}") // Maps HTTP PUT requests with an actorId path variable to this method
    public void updateActor(@PathVariable String actorId, @RequestBody Actor actor) {
        actorServiceImpl.updateActor(actorId, actor); // Updates an existing actor
    }

    @DeleteMapping("/{actorId}") // Maps HTTP DELETE requests with an actorId path variable to this method
    public void deleteActorById(@PathVariable String actorId) {
        actorServiceImpl.deleteActorById(actorId); // Deletes an actor by their ID
    }
}

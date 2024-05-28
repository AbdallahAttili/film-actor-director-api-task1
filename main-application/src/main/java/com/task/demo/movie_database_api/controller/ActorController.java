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

    /**
     * creates an actor
     *
     * @param actor of type Actor
     * @return Actor
     */
    @PostMapping
    public Actor createActor(@RequestBody Actor actor) {
        return actorServiceImpl.createActor(actor);
    }


    /**
     * retrieves the actor object by its name
     *
     * @param name of type string
     * @return Actor
     */
    @GetMapping("/search")
    public Actor getActorByName(@RequestParam("name") String name) {
        return actorServiceImpl.getActorByName(name);
    }


    /**
     * retrieves all actors
     *
     * @return List<Actor>
     */
    @GetMapping
    public List<Actor> getAllActors() {
        return actorServiceImpl.getAllActors();
    }


    /**
     * updates the actor using its id
     *
     * @param actorId  of type String
     * @param newActor of type Actor
     */
    @PutMapping("/{actorId}")
    public void updateActor(@PathVariable String actorId, @RequestBody Actor newActor) {
        actorServiceImpl.updateActor(actorId, newActor);
    }


    /**
     * deletes an actor using its id
     *
     * @param actorId of type ObjectId
     */
    @DeleteMapping("/{actorId}")
    public void deleteActorById(@PathVariable ObjectId actorId) {
        actorServiceImpl.deleteActorById(actorId);
    }
}

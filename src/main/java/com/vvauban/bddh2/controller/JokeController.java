package com.vvauban.bddh2.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.vvauban.bddh2.model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vvauban.bddh2.repository.JokeRepository;

@RestController
@RequestMapping( "/api/jokes" )
public class JokeController {

    @Autowired
    private JokeRepository jokeRepository;


    @GetMapping
    public List<Joke> getAllJokes() {
        return jokeRepository.findAll();
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Joke> getJokeById( @PathVariable( value = "id" ) Long jokeId ) {

        Joke joke = jokeRepository.findById( jokeId )
                                  .orElseThrow( () -> new NoSuchElementException( "Joke not availbele for Id :" + jokeId ) );

        return ResponseEntity.ok()
                             .body( joke );
    }

    @PostMapping
    public Joke createJoke( @Valid @RequestBody Joke joke ) {

        System.out.println( joke ); // Just to inspect values for demo
        return jokeRepository.save( joke );
    }

}

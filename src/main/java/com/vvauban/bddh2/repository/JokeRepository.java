package com.vvauban.bddh2.repository;

import com.vvauban.bddh2.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends JpaRepository<Joke, Long>{

}

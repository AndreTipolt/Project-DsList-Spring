package com.andretipolt.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andretipolt.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}

package com.andretipolt.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andretipolt.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
    
}

package com.andretipolt.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andretipolt.dslist.dto.GameListDTO;
import com.andretipolt.dslist.entities.GameList;
import com.andretipolt.dslist.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> listGameList = gameListRepository.findAll();
        return listGameList.stream().map(game -> new GameListDTO(game)).toList();
    }
}

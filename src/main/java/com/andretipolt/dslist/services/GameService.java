package com.andretipolt.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andretipolt.dslist.dto.GameDTO;
import com.andretipolt.dslist.dto.GameMinDTO;
import com.andretipolt.dslist.entities.Game;
import com.andretipolt.dslist.projections.GameMinProjection;
import com.andretipolt.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {

        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true) // Blocks database writting
    public GameDTO findById(Long gameId){
        Game game = gameRepository.findById(gameId).get(); // The ".get" is necessary because it's returns a Optional<Game>
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    } 
}

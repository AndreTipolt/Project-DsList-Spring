package com.andretipolt.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andretipolt.dslist.dto.GameDTO;
import com.andretipolt.dslist.dto.GameMinDTO;
import com.andretipolt.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;
    
    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> listGameDTO = gameService.findAll();
        return listGameDTO;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO gameDTO = gameService.findById(id);
        return gameDTO;
    }
}

package com.xt.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dslist.dto.GameMinDTO;
import com.xt.dslist.entities.Game;
import com.xt.dslist.repositories.GameRepository;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(GameMinDTO::new).toList();
	}
}

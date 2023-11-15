package com.xt.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.dslist.dto.GameListDTO;
import com.xt.dslist.entities.GameList;
import com.xt.dslist.repositories.GameListRepository;

@Service
public class GameListService {
    @Autowired
    private GameListRepository listRepository;

	public List<GameListDTO> findAll() {
		List<GameList> result = listRepository.findAll();
		return result.stream().map(GameListDTO::new).toList();
	}

	@Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		GameList result = listRepository.findById(id).get();
		return new GameListDTO(result);
	}
}

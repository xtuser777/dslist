package com.xt.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.dslist.dto.GameListDTO;
import com.xt.dslist.entities.GameList;
import com.xt.dslist.projections.GameMinProjection;
import com.xt.dslist.repositories.GameListRepository;
import com.xt.dslist.repositories.GameRepository;

@Service
public class GameListService {
    @Autowired
    private GameListRepository listRepository;

	@Autowired
	private GameRepository gameRepository;

	public List<GameListDTO> findAll() {
		List<GameList> result = listRepository.findAll();
		return result.stream().map(GameListDTO::new).toList();
	}

	@Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		GameList result = listRepository.findById(id).get();
		return new GameListDTO(result);
	}

	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = this.gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			this.listRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}

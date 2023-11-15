package com.xt.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xt.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}

package com.xt.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xt.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}

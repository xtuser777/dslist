package com.xt.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xt.dslist.dto.GameListDTO;
import com.xt.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService listService;

    @GetMapping()
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = listService.findAll();
		return result;
	}
}

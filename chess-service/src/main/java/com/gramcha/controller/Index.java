/**
 * @author gramcha
 * 15-Jan-2018 1:11:31 PM
 * 
 */
package com.gramcha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gramcha.entities.BoardState;
import com.gramcha.service.ModelService;

@RestController
public class Index {
	
	@Autowired
	ModelService model;
	
	@RequestMapping(value="/")
	public ResponseEntity<String> ping() throws Exception{
		return ResponseEntity.ok("pong - "+model.evaluate());
	}
	@RequestMapping(value="/moves")
	public ResponseEntity<List<BoardState>> findMoves(@RequestBody List<BoardState> states) throws Exception{
		return ResponseEntity.ok(states);
	}
}

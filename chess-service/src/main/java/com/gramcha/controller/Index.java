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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gramcha.entities.BoardState;
import com.gramcha.service.ModelService;

@RestController
public class Index {
	
	@Autowired
	ModelService model;
	
//	@RequestMapping("/")
//	public String index() {
//	    return "index";
//	}
	
	@RequestMapping(value="/ping")
	public ResponseEntity<String> ping() throws Exception{
		return ResponseEntity.ok("pong - "+model.evaluate());
	}
	@RequestMapping(value="/moves",method = RequestMethod.POST)
	public ResponseEntity<List<BoardState>> findMoves(@RequestBody List<BoardState> states) throws Exception{
		System.out.println(states);
		return ResponseEntity.ok(model.evaluate(states));
	}
}

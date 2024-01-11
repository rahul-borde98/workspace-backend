package com.spr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.entity.Travel;
import com.spr.service.TravelService;

@RestController
@RequestMapping("/travel")
@CrossOrigin("*")
public class TravelController {
	@Autowired
	private TravelService travelService;

	@PostMapping("/add")
	public Travel addTravel(@RequestBody Travel travel) {
		System.out.println("Hello Im Adding place");
		return travelService.postTravel(travel);
	}

	@GetMapping("/all")
	public List<Travel> getAllTravel() {
		return travelService.readTravel();
	}

	@DeleteMapping("/del/{id}")
	public void deleteTravel(@PathVariable int id) {
		travelService.deleteTravel(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Travel> getTravelById(@PathVariable int id) {
		Travel trip = travelService.getTravelById(id);
		if (trip == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(trip);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Travel> updateCustomer(@PathVariable int id, @RequestBody Travel travel) {
		Travel updateTravel = travelService.updateTravel(id, travel);
		if (updateTravel == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(updateTravel);
		}
	}

}

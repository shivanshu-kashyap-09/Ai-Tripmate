package com.example.Travel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Travel.entity.HotelEntity;
import com.example.Travel.service.HotelService;


@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "http://localhost:5173")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	List<String> list = new ArrayList<>();
	
	@PostMapping("/name")
	public ResponseEntity<?> getName(@RequestBody HotelEntity hotelEntity) {
		try {
			ResponseEntity<?> hotelName = hotelService.getHotelsName(hotelEntity);
			return new ResponseEntity<>(hotelName , HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error occured in hotel names "+e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/price/{hotelName}")
	public ResponseEntity<?> getPrices(@PathVariable String hotelName){
		try {
			ResponseEntity<?> hotelPrice = hotelService.getHotelsPrice(hotelName);
			return new ResponseEntity<>(hotelPrice , HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error occured in hotelprice "+ e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/description/{hotelName}")
	public ResponseEntity<?> getDesc(@PathVariable String hotelName){
		try {
			ResponseEntity<?> hotelDesc = hotelService.getHotelsDesc(hotelName);
			return new ResponseEntity<>(hotelDesc , HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error occured in hotel descrition " + e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/rating/{hotelName}")
	public ResponseEntity<?> getRating(@PathVariable String hotelName){
		try {
			ResponseEntity<?> hotelRating = hotelService.getHotelsRating(hotelName);
			return new ResponseEntity<>(hotelRating , HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error occured in hotel rating "+e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

package com.ratemovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratemovie.entity.CustomerMovieRating;
import com.ratemovie.entity.Movie;
import com.ratemovie.service.MovieRateService;
import com.ratemovie.utility.CustomerRating;

@RestController
public class MovieRatingController {
	@Autowired
	private MovieRateService movieRateService;
	
	@PostMapping("/api/addNewRating/{customerId}/rate/{movieId}/giveRating/{rating}")
	public List<CustomerMovieRating> addNewMovieRating(@PathVariable Integer customerId,
			@PathVariable Integer movieId,@PathVariable Double rating){
		return movieRateService.addNewMovieRating(customerId, movieId, rating);
	}
	
	@GetMapping("/api/getMovieWithHighestRating")
	public Movie movieWithHighestAverageRating() {
		return movieRateService.movieWithHighestAverageRating();
	}
	@GetMapping("/api/getCustomerWithHighestRating")
	public CustomerRating getHighestRateCustomer() {
		return movieRateService.getHighestRateCustomer();
	}
}

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


/*This class contains all the REST endpoints */
@RestController
public class MovieRatingController {
	@Autowired
	private MovieRateService movieRateService; //Autowired object of the MovieRateService
	
	/*This is a POST request endpoint that adds rating for a movie given by a customer*/
	@PostMapping("/api/addNewRating/{customerId}/rate/{movieId}/giveRating/{rating}")
	public List<CustomerMovieRating> addNewMovieRating(@PathVariable Integer customerId,
			@PathVariable Integer movieId,@PathVariable Double rating){
		return movieRateService.addNewMovieRating(customerId, movieId, rating);
	}
	/*This is GET request endpoint that fetches the Movie with the highest average rating overall from the service layer.*/
	@GetMapping("/api/getMovieWithHighestRating")
	public Movie movieWithHighestAverageRating() {
		return movieRateService.movieWithHighestAverageRating();
	}
	
	/*This is a GET endpoint that fetches the Customer who gave the highest average rating and overall average rating
	 * from the service layer.*/
	@GetMapping("/api/getCustomerWithHighestRating")
	public CustomerRating getHighestRateCustomer() {
		return movieRateService.getHighestRateCustomer();
	}
}

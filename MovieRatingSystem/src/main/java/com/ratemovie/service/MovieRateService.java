package com.ratemovie.service;

import java.util.List;

import com.ratemovie.entity.Customer;
import com.ratemovie.entity.CustomerMovieRating;
import com.ratemovie.entity.Movie;
import com.ratemovie.utility.CustomerRating;
/*Service interface for buisiness layer class*/
public interface MovieRateService {
	public List<Customer> getAllCustomers();
	public List<CustomerMovieRating> addNewMovieRating(Integer customerId,Integer movieId,Double rating);
	public Movie movieWithHighestAverageRating();
	public CustomerRating getHighestRateCustomer();
}

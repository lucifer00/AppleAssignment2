package com.ratemovie.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratemovie.entity.Customer;
import com.ratemovie.entity.CustomerMovieRating;
import com.ratemovie.entity.Movie;
import com.ratemovie.repository.CustomerMovieRatingRepository;
import com.ratemovie.repository.CustomerRepository;
import com.ratemovie.repository.MovieRepository;
import com.ratemovie.utility.CustomerRating;
import com.ratemovie.utility.CustomerRatingUtility;
import com.ratemovie.utility.MovieRating;
/*Service class for Business logic.
 * Contains implementations of the required business functionalities.*/
@Service
public class MovieRateServiceImpl implements MovieRateService{
	
	@Autowired
	private CustomerRepository customerRepository; 
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private CustomerMovieRatingRepository movieRatingRepository;
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	/*Adds rating for a movie and persists in the DB relationship table.*/
	@Override
	public List<CustomerMovieRating> addNewMovieRating(Integer customerId, Integer movieId, Double rating) {
		Customer customer=customerRepository.getOne(customerId);
		Movie movie=movieRepository.getOne(movieId);
		CustomerMovieRating customerMovieRating=new CustomerMovieRating(customer, movie);
		customerMovieRating.setRating(rating);
		movieRatingRepository.saveAndFlush(customerMovieRating);
		return movieRatingRepository.findAll();
	}
	/*Fetches and returns the Movie with the highest average rating.*/
	@Override
	public Movie movieWithHighestAverageRating() {
		List<CustomerMovieRating> customerMovieRatings=new ArrayList<>();
		customerMovieRatings=movieRatingRepository.findAll();
		List<Movie> movies=movieRepository.findAll();
		List<MovieRating> movieAndRatings=new ArrayList<>();
		customerMovieRatings.forEach(ratingObject->{
			MovieRating movieRating=new MovieRating();
			movieRating.setMovieId(ratingObject.getCustomerMovieId().getMovieId());
			movieRating.setRating(ratingObject.getRating());
			movieAndRatings.add(movieRating);
		});
		Map<Integer,List<MovieRating>> ratingsPerMovie=movieAndRatings.stream().collect(Collectors.groupingBy(t->t.getMovieId(),Collectors.toList()));
		List<MovieRating> movieAndRatingsAverage=new ArrayList<>();
		ratingsPerMovie.forEach((k,v)->{
			MovieRating movieRating=new MovieRating();
			movieRating.setMovieId(k);
			movieRating.setRating(v.stream().mapToDouble(t->t.getRating()).average().getAsDouble());
			movieAndRatingsAverage.add(movieRating);
		}); //Average per movie with movie id is stored in the list movieAndRatingsAverage
		Collections.sort(movieAndRatingsAverage, (o1,o2)->{
			if(o1.getRating()>o2.getRating()) return -1;
			else return 1;
		}); //Sorts the movieAndRatingsAverage list
		return movieRepository.getOne(movieAndRatingsAverage.get(0).getMovieId()); // returns the movie with highest average rating.
	}
	/*Fetches and returns the Customer who gave the highest average rating.*/
	@Override
	public CustomerRating getHighestRateCustomer() {
		List<CustomerMovieRating> customerMovieRatings=new ArrayList<>();
		customerMovieRatings=movieRatingRepository.findAll();
		List<Customer> customer=customerRepository.findAll();
		List<CustomerRatingUtility> customerRatings=new ArrayList<>();
		customerMovieRatings.forEach(ratingObject->{
			CustomerRatingUtility customerRating=new CustomerRatingUtility();
			customerRating.setCustomerId(ratingObject.getCustomerMovieId().getMovieId());
			customerRating.setRating(ratingObject.getRating());
			customerRatings.add(customerRating);
		});
		Map<Integer,List<CustomerRatingUtility>> ratingsPerCustomer=customerRatings.stream().collect(Collectors.groupingBy(t->t.getCustomerId(),Collectors.toList()));
		List<CustomerRatingUtility> customerAndRatingsAverage=new ArrayList<>();
		ratingsPerCustomer.forEach((k,v)->{
			CustomerRatingUtility customerRating=new CustomerRatingUtility();
			customerRating.setCustomerId(k);
			customerRating.setRating(v.stream().mapToDouble(t->t.getRating()).average().getAsDouble());
			customerAndRatingsAverage.add(customerRating);
		});  //Average rating per customer is stored in customerAndRatingsAverage
		Collections.sort(customerAndRatingsAverage, (o1,o2)->{
			if(o1.getRating()>o2.getRating()) return -1;
			else return 1;
		}); //Sorting customerAndRatingsAverage .
		Double averageOverallRating=customerMovieRatings.stream().mapToDouble(t->t.getRating()).average().getAsDouble();
		CustomerRating customerRating=new CustomerRating(); // Creating a new CustomerRating to return to Frontend.
		Customer topRateCustomer=customerRepository.getOne(customerAndRatingsAverage.get(0).getCustomerId());
		customerRating.setAverageRating(averageOverallRating);
		customerRating.setCustomerAverageRating(customerAndRatingsAverage.get(0).getRating());
		customerRating.setCustomerId(topRateCustomer.getCustomerId());
		customerRating.setFirstName(topRateCustomer.getFirstName());
		customerRating.setLastName(topRateCustomer.getLastName());
		return customerRating; //CustomerRating object returned having the requisite information.
	}
	
}

package com.ratemovie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*The Movie entity object.*/
@Entity
@Table(name = "movie")
public class Movie {
	@Id
	private Integer movieId;
	private String movieName;
	
	@OneToMany(mappedBy = "movie",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CustomerMovieRating> customerMovieRatings=new ArrayList<>();
	public List<CustomerMovieRating> getCustomerMovieRatings() {
		return customerMovieRatings;
	}
	public void setCustomerMovieRatings(List<CustomerMovieRating> customerMovieRatings) {
		this.customerMovieRatings = customerMovieRatings;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + "]";
	}
	
}

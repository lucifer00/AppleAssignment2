package com.ratemovie.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*Entity object for the relationship table CustomerMovie*/
@Entity(name = "CustomerMovie")
@Table(name="CustomerMovie")
public class CustomerMovieRating {
	@EmbeddedId
	private CustomerMovieId customerMovieId;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("customer_id")
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("movie_id")
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	@Column(name = "rating")
	private Double rating;
	
	private CustomerMovieRating() {}
	
	public CustomerMovieRating(Customer customer,Movie movie) {
		this.customer=customer;
		this.movie=movie;
		this.customerMovieId=new CustomerMovieId(customer.getCustomerId(),movie.getMovieId());
	}

	public CustomerMovieId getCustomerMovieId() {
		return customerMovieId;
	}

	public void setCustomerMovieId(CustomerMovieId customerMovieId) {
		this.customerMovieId = customerMovieId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
}

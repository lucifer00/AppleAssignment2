package com.ratemovie.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/*Embedded id object for the many-many relationship table which has composite primary key.*/
@Embeddable
public class CustomerMovieId implements Serializable {
	@Column(name="customer_id")
	private Integer customerId;
	@Column(name="movie_id")
	private Integer movieId;
	private CustomerMovieId() {}
	public CustomerMovieId(Integer customerId,Integer movieId) {
		this.customerId=customerId;
		this.movieId=movieId;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        CustomerMovieId that = (CustomerMovieId) o;
        return Objects.equals(customerId, that.customerId) &&
               Objects.equals(movieId, that.movieId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(customerId, movieId);
    }
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
}

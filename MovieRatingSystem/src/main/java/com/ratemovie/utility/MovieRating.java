package com.ratemovie.utility;

public class MovieRating {
	private Integer movieId;
	private Double rating;
	@Override
	public String toString() {
		return "MovieRating [movieId=" + movieId + ", rating=" + rating + "]";
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
}

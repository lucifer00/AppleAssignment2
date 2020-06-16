package com.ratemovie.utility;

public class CustomerRatingUtility {
	private Integer customerId;
	private Double rating;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "CustomerRatingUtility [customerId=" + customerId + ", rating=" + rating + "]";
	}
}

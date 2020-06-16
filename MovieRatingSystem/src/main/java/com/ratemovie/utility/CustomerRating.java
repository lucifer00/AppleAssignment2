package com.ratemovie.utility;

public class CustomerRating {
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Double customerAverageRating;
	private Double averageRating;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getCustomerAverageRating() {
		return customerAverageRating;
	}
	public void setCustomerAverageRating(Double customerAverageRating) {
		this.customerAverageRating = customerAverageRating;
	}
	public Double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	@Override
	public String toString() {
		return "CustomerRating [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", customerAverageRating=" + customerAverageRating + ", averageRating=" + averageRating + "]";
	}
}

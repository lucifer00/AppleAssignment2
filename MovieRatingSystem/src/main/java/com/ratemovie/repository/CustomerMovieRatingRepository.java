package com.ratemovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratemovie.entity.CustomerMovieId;
import com.ratemovie.entity.CustomerMovieRating;
/*Jpa repository for Relationship Entity*/
public interface CustomerMovieRatingRepository extends JpaRepository<CustomerMovieRating, CustomerMovieId> {

}

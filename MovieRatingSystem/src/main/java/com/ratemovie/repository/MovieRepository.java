package com.ratemovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratemovie.entity.Movie;
/*Jpa repository for Movie entity.*/
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}

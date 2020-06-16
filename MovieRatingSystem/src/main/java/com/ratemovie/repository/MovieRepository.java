package com.ratemovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratemovie.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}

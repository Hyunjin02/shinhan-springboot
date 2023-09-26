package com.example.repository;

import com.example.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long>{
    Optional<Object> findById(long movieId);
}

package com.example.repository;

import com.example.domain.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LogRepository extends JpaRepository<Log, Long> {
}
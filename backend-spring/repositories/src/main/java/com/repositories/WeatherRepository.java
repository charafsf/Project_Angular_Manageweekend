package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>{
	public Optional<Weather> findById(Long id);

}

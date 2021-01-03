package com.db.msapi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.db.msapi.Model.Movie;
import com.db.msapi.Model.MovieDetails;
import com.db.msapi.Model.ShowDetails;
import com.db.msapi.Service.MovieService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@ApiOperation("Get all movies")
	@GetMapping("/movies/")
	public List<Movie> getAll() {
		return movieService.getAllMovies();
	}
	
	@ApiOperation("Get movies by TITLE")
	@GetMapping("/movies/{str}")
	public List<Movie> getMoviesByName(@ApiParam(
			value = "Title of movie",
	        required = true, 
	        defaultValue = "The Truman Show")@PathVariable String str) {
		return  movieService.getMoviesByName(str);
	}
		
	@ApiOperation("Get movie by ID")
	@GetMapping("/movie/{id}")
	public Optional<Movie> getMovie(@ApiParam(
			value = "movie id",
	        required = true)@PathVariable Long id) {
		return movieService.getMovie(id);
	}
	@ApiOperation("Get movie details by MOVIE ID")
	@GetMapping("/movie/details/{id}")
	public MovieDetails getMovieDetails(@ApiParam(
			value = "movie id",
	        required = true)@PathVariable Long id) {
		return movieService.getMovieDetails(id);
	}
}

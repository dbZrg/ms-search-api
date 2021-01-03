package com.db.msapi.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.db.msapi.Mappers.OutputMapper;
import com.db.msapi.Model.Movie;
import com.db.msapi.Model.MovieDetails;
import com.db.msapi.Service.MovieService;
import com.db.msapi.response.output.MediaOut;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class MovieController {
	@Autowired
	private OutputMapper outMapper;
	@Autowired
	private MovieService movieService;
	
	@ApiOperation("Get all movies")
	@GetMapping("/movies/")
	public List<MediaOut> getAll() {
		
		List<MediaOut> output = outMapper.toMediaOutListM(movieService.getAllMovies());
		for (MediaOut media : output) {
			 media.add(linkTo(MovieController.class).slash("/movie").slash(media.getId()).withSelfRel());
			 media.add(linkTo(methodOn(MovieController.class).getMovieDetails(media.getId())).withRel("movie details"));				
		}
		return output;
	}
	
	@ApiOperation("Get movies by TITLE")
	@GetMapping("/movies/{str}")
	public List<MediaOut> getMoviesByName(@ApiParam(
			value = "Title of movie",
	        required = true, 
	        defaultValue = "The Truman Show")@PathVariable String str) {
		
		List<MediaOut> output = outMapper.toMediaOutListM(movieService.getMoviesByName(str));
		for (MediaOut media : output) {
			 media.add(linkTo(MovieController.class).slash("/movie").slash(media.getId()).withSelfRel());
			 media.add(linkTo(methodOn(MovieController.class).getMovieDetails(media.getId())).withRel("movie details"));				
		}
		return output;
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

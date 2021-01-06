package com.db.msapi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.db.msapi.Model.Movie;
import com.db.msapi.Model.MovieDetails;
import com.db.msapi.Repository.MovieDetailsRep;
import com.db.msapi.Repository.MovieRep;
import com.db.msapi.externalApi.ExternalApi;
import com.db.msapi.util.LuceneSearch;

@Service
public class MovieService {

	@Autowired
	private MovieRep movieRep;
	@Autowired
	MovieDetailsRep movieDetailsRep;
	@Autowired
	ExternalApi externalApi;
	@Autowired
	private LuceneSearch luceneSearch;
	
	/**
	 * <p>Get all movies from database</p>
	 * @return list of Movie objects 
	 */
	public List<Movie> getAllMovies(){
		List<Movie> list = new ArrayList<Movie>();
		movieRep.findAll().forEach(list::add);
		return list;
	}
	
	/**
	 * <p>Search for movie, if there is no exact match in database,
	 * fetch movies using external API-s and save to database</p>
	 * @param str search term
	 * @return list of Movie objects sorted by relevance to search term
	 */
	public List<Movie> getMoviesByName(String str){
		if(!movieRep.existsByName(str)) {
			for(Movie movie : externalApi.getMoviesList(str) ) {
				if(!movieRep.existsByMdbId(movie.getMdbId())) {
				MovieDetails movDet = externalApi.getMovieDetails(movie.getMdbId());		
				movie.setMovieDetails(movDet);
				movieRep.save(movie);
				}
			}
		}
		return luceneSearch.getByName(str, 5000, Movie.class);	
	}

	/**
	 * <p>Get Movie by id</p>
	 * @param id movie id
	 * @return Movie object 
	 */
	public Optional<Movie> getMovie(Long id){
		Optional<Movie> movie = movieRep.findById(id);
		if(movie.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Movie found");
		return movie;
	}
	
	/**
	 * <p>Get Movie details by id</p>
	 * @param id movie id
	 * @return MovieDetails object 
	 */
	public MovieDetails getMovieDetails(Long id) {
		MovieDetails movDet = movieDetailsRep.findByMovie_id(id);
		if(movDet == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Movie details found");
		return movDet;
	}
	
}

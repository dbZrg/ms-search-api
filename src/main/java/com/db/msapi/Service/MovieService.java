package com.db.msapi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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
	
	public List<Movie> getAllMovies(){
		List<Movie> list = new ArrayList<Movie>();
		movieRep.findAll().forEach(list::add);
		return list;
	}
	
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

	public Optional<Movie> getMovie(Long id){
		return movieRep.findById(id);
	}
	
	public MovieDetails getMovieDetails(Long id) {
		return movieDetailsRep.findByMovie_id(id);
	}
	
}

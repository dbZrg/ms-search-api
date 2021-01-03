package com.db.msapi.externalApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.db.msapi.Mappers.DataMapper;
import com.db.msapi.Model.Movie;
import com.db.msapi.Model.MovieDetails;
import com.db.msapi.Model.Show;
import com.db.msapi.Model.ShowDetails;
import com.db.msapi.response.themoviedb.*;
import com.db.msapi.response.openmoviedb.*;

@Component
public class ExternalApi {
	
	@Autowired
	OpenMoviedbApi openMoviedbApi;
	@Autowired
	TheMoviedbApi theMoviedbApi;
	@Autowired
	DataMapper movieDbMapper;
	
	public List<Movie> getMoviesList(String str){
		List<Movie> movies = new ArrayList<>();
		MovieListResponse response = theMoviedbApi.getMoviesListResponse(str);
		if(response != null) {
			for(MovieResponse movieResponse : response.results ) {
				Movie movie = movieDbMapper.toMovie(movieResponse);
				movies.add(movie);
			}
		}
		return movies;
	}
	
	public MovieDetails getMovieDetails(Long id) {
		MovieResponseOmdb responseOpenMovieDatabase = new MovieResponseOmdb();
		
		MovieDetailsResponse responseTheMovieDatabase = theMoviedbApi.getMovieDetailsResponse(id);
		if(responseTheMovieDatabase != null) {
			responseOpenMovieDatabase = openMoviedbApi.getMovieResponse(responseTheMovieDatabase.imdbId);
		}
		return movieDbMapper.toMovieDetails(responseTheMovieDatabase , responseOpenMovieDatabase);
	}
	
	public List<Show> getShowList(String str){
		List<Show> shows = new ArrayList<>();
		ShowListResponse response =  theMoviedbApi.getShowsListResponse(str);
		if(response != null) {
			for(ShowResponse showResponse : response.results ) {
				Show show = movieDbMapper.toShow(showResponse);
				shows.add(show);
			}
		}
		return shows;
	}
	public ShowDetails getShowDetails(Long id) {
		ShowDetailsResponse responseTheMoviedb = theMoviedbApi.getShowDetailsResponse(id);
		return movieDbMapper.toShowDetails(responseTheMoviedb);
	}
}

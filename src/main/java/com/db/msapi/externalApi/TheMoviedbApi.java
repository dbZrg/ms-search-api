package com.db.msapi.externalApi;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.db.msapi.response.themoviedb.*;

@Component
public class TheMoviedbApi {
	RestTemplate rest = new RestTemplate();
	
	private String apiKey = "09e92da70dfe36cdf0fb3d6db5f60fdd";
	
	public MovieListResponse getMoviesListResponse(String str) {
		return rest.getForObject("https://api.themoviedb.org/3/search/movie?query=" + str  + "&api_key="+apiKey+"&language=en-US",MovieListResponse.class);
	}
	
	public MovieDetailsResponse getMovieDetailsResponse(Long id) {
		return rest.getForObject("https://api.themoviedb.org/3/movie/"+ id +"?api_key="+ apiKey +"&language=en-US",MovieDetailsResponse.class);
	}
	
	public ShowListResponse getShowsListResponse(String str) {
		return rest.getForObject("https://api.themoviedb.org/3/search/tv?query=" + str  + "&api_key="+ apiKey +"&language=en-US",ShowListResponse.class);
	}
	
	public ShowDetailsResponse getShowDetailsResponse(Long id) {
		return rest.getForObject("https://api.themoviedb.org/3/tv/"+ id +"?api_key="+ apiKey +"&append_to_response=external_ids&language=en-US",ShowDetailsResponse.class);
	}
	
}

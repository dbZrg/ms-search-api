package com.db.msapi.externalApi;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.db.msapi.response.openmoviedb.*;

@Component
public class OpenMoviedbApi {
	RestTemplate rest = new RestTemplate();
	
	private String apiKey = "b041134";
	
	public MovieResponseOmdb getMovieResponse(String imdbId) {
		return rest.getForObject("http://www.omdbapi.com/?i="+imdbId+"&apikey="+apiKey,MovieResponseOmdb.class);
	}
	
}

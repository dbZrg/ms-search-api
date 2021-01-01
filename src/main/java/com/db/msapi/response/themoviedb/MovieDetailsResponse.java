package com.db.msapi.response.themoviedb;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"adult",
"backdrop_path",
"belongs_to_collection",
"budget",
"genres",
"homepage",
"id",
"imdb_id",
"original_language",
"original_title",
"overview",
"popularity",
"poster_path",
"production_companies",
"production_countries",
"release_date",
"revenue",
"runtime",
"spoken_languages",
"status",
"tagline",
"title",
"video",
"vote_average",
"vote_count"
})
public class MovieDetailsResponse {

	@JsonProperty("adult")
	public Boolean adult;
	@JsonProperty("backdrop_path")
	public String backdropPath;
	@JsonProperty("belongs_to_collection")
	public Object belongsToCollection;
	@JsonProperty("budget")
	public Integer budget;
	@JsonProperty("homepage")
	public String homepage;
	@JsonProperty("id")
	public Integer id;
	@JsonProperty("imdb_id")
	public String imdbId;
	@JsonProperty("original_language")
	public String originalLanguage;
	@JsonProperty("original_title")
	public String originalTitle;
	@JsonProperty("overview")
	public String overview;
	@JsonProperty("popularity")
	public Double popularity;
	@JsonProperty("poster_path")
	public Object posterPath;
	@JsonProperty("release_date")
	public String releaseDate;
	@JsonProperty("revenue")
	public Long revenue;
	@JsonProperty("runtime")
	public Integer runtime;
	@JsonProperty("status")
	public String status;
	@JsonProperty("tagline")
	public String tagline;
	@JsonProperty("title")
	public String title;
	@JsonProperty("video")
	public Boolean video;
	@JsonProperty("vote_average")
	public Double voteAverage;
	@JsonProperty("vote_count")
	public Integer voteCount;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

}
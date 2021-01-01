package com.db.msapi.response.themoviedb;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"poster_path",
"adult",
"overview",
"release_date",
"genre_ids",
"id",
"original_title",
"original_language",
"title",
"backdrop_path",
"popularity",
"vote_count",
"video",
"vote_average"
})
public class MovieResponse {
	
	@JsonProperty("poster_path")
	public String posterPath;
	@JsonProperty("adult")
	public Boolean adult;
	@JsonProperty("overview")
	public String overview;
	@JsonProperty("release_date")
	public String releaseDate;
	@JsonProperty("genre_ids")
	public List<Integer> genreIds = null;
	@JsonProperty("id")
	public Integer id;
	@JsonProperty("original_title")
	public String originalTitle;
	@JsonProperty("original_language")
	public String originalLanguage;
	@JsonProperty("title")
	public String title;
	@JsonProperty("backdrop_path")
	public String backdropPath;
	@JsonProperty("popularity")
	public Double popularity;
	@JsonProperty("vote_count")
	public Integer voteCount;
	@JsonProperty("video")
	public Boolean video;
	@JsonProperty("vote_average")
	public Double voteAverage;
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

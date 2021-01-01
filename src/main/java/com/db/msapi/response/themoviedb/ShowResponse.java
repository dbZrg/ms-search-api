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
"popularity",
"id",
"backdrop_path",
"vote_average",
"overview",
"first_air_date",
"origin_country",
"genre_ids",
"original_language",
"vote_count",
"name",
"original_name"
})
public class ShowResponse {

@JsonProperty("poster_path")
public String posterPath;
@JsonProperty("popularity")
public Double popularity;
@JsonProperty("id")
public Integer id;
@JsonProperty("backdrop_path")
public String backdropPath;
@JsonProperty("vote_average")
public Double voteAverage;
@JsonProperty("overview")
public String overview;
@JsonProperty("first_air_date")
public String firstAirDate;
@JsonProperty("origin_country")
public List<String> originCountry = null;
@JsonProperty("genre_ids")
public List<Integer> genreIds = null;
@JsonProperty("original_language")
public String originalLanguage;
@JsonProperty("vote_count")
public Integer voteCount;
@JsonProperty("name")
public String name;
@JsonProperty("original_name")
public String originalName;
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

package com.db.msapi.response.openmoviedb;

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
"Title",
"Year",
"Rated",
"Released",
"Runtime",
"Genre",
"Director",
"Writer",
"Actors",
"Plot",
"Language",
"Country",
"Awards",
"Poster",
"Ratings",
"Metascore",
"imdbRating",
"imdbVotes",
"imdbID",
"Type",
"DVD",
"BoxOffice",
"Production",
"Website",
"Response"
})
public class MovieResponseOmdb {

@JsonProperty("Title")
public String title;
@JsonProperty("Year")
public String year;
@JsonProperty("Rated")
public String rated;
@JsonProperty("Released")
public String released;
@JsonProperty("Runtime")
public String runtime;
@JsonProperty("Genre")
public String genre;
@JsonProperty("Director")
public String director;
@JsonProperty("Writer")
public String writer;
@JsonProperty("Actors")
public String actors;
@JsonProperty("Plot")
public String plot;
@JsonProperty("Language")
public String language;
@JsonProperty("Country")
public String country;
@JsonProperty("Awards")
public String awards;
@JsonProperty("Poster")
public String poster;
@JsonProperty("Ratings")
public List<Object> ratings = null;
@JsonProperty("Metascore")
public String metascore;
@JsonProperty("imdbRating")
public String imdbRating;
@JsonProperty("imdbVotes")
public String imdbVotes;
@JsonProperty("imdbID")
public String imdbID;
@JsonProperty("Type")
public String type;
@JsonProperty("DVD")
public String dVD;
@JsonProperty("BoxOffice")
public String boxOffice;
@JsonProperty("Production")
public String production;
@JsonProperty("Website")
public String website;
@JsonProperty("Response")
public String response;
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
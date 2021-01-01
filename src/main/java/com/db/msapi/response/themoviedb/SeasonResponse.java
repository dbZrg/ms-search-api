package com.db.msapi.response.themoviedb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"air_date",
"episode_count",
"id",
"name",
"overview",
"poster_path",
"season_number"
})
public class SeasonResponse {

@JsonProperty("air_date")
public String airDate;
@JsonProperty("episode_count")
public Integer episodeCount;
@JsonProperty("id")
public Integer id;
@JsonProperty("name")
public String name;
@JsonProperty("overview")
public String overview;
@JsonProperty("poster_path")
public String posterPath;
@JsonProperty("season_number")
public Integer seasonNumber;



}
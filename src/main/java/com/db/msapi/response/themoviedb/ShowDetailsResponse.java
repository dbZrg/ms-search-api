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
"backdrop_path",
"created_by",
"episode_run_time",
"first_air_date",
"genres",
"homepage",
"id",
"in_production",
"languages",
"last_air_date",
"last_episode_to_air",
"name",
"next_episode_to_air",
"networks",
"number_of_episodes",
"number_of_seasons",
"origin_country",
"original_language",
"original_name",
"overview",
"popularity",
"poster_path",
"production_companies",
"production_countries",
"seasons",
"spoken_languages",
"status",
"tagline",
"type",
"vote_average",
"vote_count",
"external_ids"
})
public class ShowDetailsResponse {

@JsonProperty("backdrop_path")
public String backdropPath;
@JsonProperty("episode_run_time")
public List<Integer> episodeRunTime = null;
@JsonProperty("first_air_date")
public String firstAirDate;
@JsonProperty("homepage")
public String homepage;
@JsonProperty("id")
public Integer id;
@JsonProperty("in_production")
public Boolean inProduction;
@JsonProperty("languages")
public List<String> languages = null;
@JsonProperty("last_air_date")
public String lastAirDate;
@JsonProperty("name")
public String name;
@JsonProperty("next_episode_to_air")
public Object nextEpisodeToAir;
@JsonProperty("number_of_episodes")
public Integer numberOfEpisodes;
@JsonProperty("number_of_seasons")
public Integer numberOfSeasons;
@JsonProperty("origin_country")
public List<String> originCountry = null;
@JsonProperty("original_language")
public String originalLanguage;
@JsonProperty("original_name")
public String originalName;
@JsonProperty("overview")
public String overview;
@JsonProperty("popularity")
public Double popularity;
@JsonProperty("poster_path")
public String posterPath;
@JsonProperty("seasons")
public List<SeasonResponse> seasons = null;
@JsonProperty("status")
public String status;
@JsonProperty("tagline")
public String tagline;
@JsonProperty("type")
public String type;
@JsonProperty("vote_average")
public Double voteAverage;
@JsonProperty("vote_count")
public Integer voteCount;
@JsonProperty("external_ids")
public ExtIdsResponse externalIds;


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

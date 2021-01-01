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
"imdb_id",
"freebase_mid",
"freebase_id",
"tvdb_id",
"tvrage_id",
"facebook_id",
"instagram_id",
"twitter_id",
"id"
})
public class ExtIdsResponse {

@JsonProperty("imdb_id")
public String imdbId;
@JsonProperty("freebase_mid")
public String freebaseMid;
@JsonProperty("freebase_id")
public String freebaseId;
@JsonProperty("tvdb_id")
public Integer tvdbId;
@JsonProperty("tvrage_id")
public Integer tvrageId;
@JsonProperty("facebook_id")
public String facebookId;
@JsonProperty("instagram_id")
public String instagramId;
@JsonProperty("twitter_id")
public String twitterId;
@JsonProperty("id")
public Integer id;
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

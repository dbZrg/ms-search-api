package com.db.msapi.response.output;


public class MediaOut {

	private long id;
	
	private long mdbId;
	
	private String media_type;

	private String name;
	
	private String description;
	
	private String image_path;

	private String language;
	
	private Integer rating;
	
	public MediaOut(long id, long mdbId, String media_type, String name, String description, String image_path,
			String language, Integer rating) {
		super();
		this.id = id;
		this.mdbId = mdbId;
		this.media_type = media_type;
		this.name = name;
		this.description = description;
		this.image_path = image_path;
		this.language = language;
		this.rating = rating;
	}

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getMdbId() {
		return mdbId;
	}

	public void setMdbId(long mdbId) {
		this.mdbId = mdbId;
	}


	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
}

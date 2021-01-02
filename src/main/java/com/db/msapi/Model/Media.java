package com.db.msapi.Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Indexed
@Entity(name="media_e")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="media_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Media {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@GenericField
	private long mdbId;
	@FullTextField
	private String name;
	@Column(length=2048)
	private String description;
	@GenericField
	private String image_path;
	@GenericField
	private String language;
	@GenericField
	private Integer rating;
	@Column(insertable=false, updatable=false)
	private String media_type;
	
	protected Media() {
	}
	
	protected Media(Long mdbId, String name, String description, String image_path, String language, Integer rating) {
		this.mdbId = mdbId;
		this.name = name;
		this.description = description;
		this.image_path = image_path;
		this.language = language;
		this.rating = rating;
	}
	
	
	public long getMdbId() {
		return mdbId;
	}
	public void setMdbId(long mdbId) {
		this.mdbId = mdbId;
	}
	public long getId() {
		return id;
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

	public String getMedia_type() {
		return media_type;
	}


	
}

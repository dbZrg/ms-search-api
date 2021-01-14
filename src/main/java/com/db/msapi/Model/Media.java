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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
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

	
	protected Media(Long mdbId, String name, String description, String image_path, String language, Integer rating) {
		this.mdbId = mdbId;
		this.name = name;
		this.description = description;
		this.image_path = image_path;
		this.language = language;
		this.rating = rating;
	}
	
	
	
}

package com.db.msapi.Model;

import javax.persistence.CascadeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Indexed
@Entity
@DiscriminatorValue("movie")
public class Movie extends Media{
	
	@IndexedEmbedded
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="mdetails_id" , referencedColumnName = "idMDetails")
	private MovieDetails movieDetails;
	
	public Movie(long mdbId,String name, String description, String image_path, String language, Integer rating) {
		super(mdbId, name, description, image_path, language, rating);
	}

	
}

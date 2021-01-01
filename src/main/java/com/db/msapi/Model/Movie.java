package com.db.msapi.Model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

@Indexed
@Entity
@DiscriminatorValue("movie")
public class Movie extends Media{
	
	@IndexedEmbedded
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="mdetails_id" , referencedColumnName = "idMDetails")
	private MovieDetails movieDetails;
	
	public Movie() {
	}

	public Movie(long mdbId,String name, String description, String image_path, String language, Integer rating) {
		super(mdbId, name, description, image_path, language, rating);
	}

	public MovieDetails getMovieDetails() {
		return movieDetails;
	}

	public void setMovieDetails(MovieDetails movieDetails) {
		this.movieDetails = movieDetails;
	}


	
	
}

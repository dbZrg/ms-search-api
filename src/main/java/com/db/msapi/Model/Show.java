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
@DiscriminatorValue("show")
public class Show extends Media {
	
	@IndexedEmbedded
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="sdetails_id" , referencedColumnName = "idSDetails")
	private ShowDetails showDetails;
	
	public Show() {
	}
	
	public Show(long mdbId, String name, String description, String image_path, String language, Integer rating) {
		super(mdbId, name, description, image_path, language, rating);
	}

	public ShowDetails getShowDetails() {
		return showDetails;
	}

	public void setShowDetails(ShowDetails showDetails) {
		this.showDetails = showDetails;
	}
	
	
	
	
	
	
	
	
}

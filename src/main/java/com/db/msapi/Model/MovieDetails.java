

package com.db.msapi.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movie_details")
public class MovieDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMDetails;
	private String imdbId;
    private Long revenue;
    private String releaseDate;
	@Column(length=2048)
    private String writer;
	@Column(length=2048)
    private String director;
    private String genres;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "movieDetails")
    private Movie movie;

    public MovieDetails() {	
    }
	
	public MovieDetails(String imdbId, Long revenue, String releaseDate, String writer, String director, String genres) {
		super();
		this.imdbId = imdbId;
		this.revenue = revenue;
		this.releaseDate = releaseDate;	
		this.writer = writer;
		this.director = director;
		this.genres = genres;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public Long getIdMDetails() {
		return idMDetails;
	}

	public Long getRevenue() {
		return revenue;
	}
	
	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}
    
	
    
}

package com.db.msapi.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "show_details")
public class ShowDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSDetails")
    private Long idSDetails;
	private String imdbId;
	private String firstAirDate;
	private String lastAirDate;
	private int numOfSeasons;
	
	
	@OneToMany(mappedBy = "showDetailsSes", fetch = FetchType.LAZY)
	private List<ShowSeason> seasons = new ArrayList<>();
	
	public ShowDetails() {
	}
	
	
	

	public ShowDetails(String imdbId, String firstAirDate, String lastAirDate, int numOfSeasons,
			List<ShowSeason> seasons) {
		super();
		this.imdbId = imdbId;
		this.firstAirDate = firstAirDate;
		this.lastAirDate = lastAirDate;
		this.numOfSeasons = numOfSeasons;
		this.seasons = seasons;
	}




	public Long getIdSDetails() {
		return idSDetails;
	}

	public List<ShowSeason> getSeasons() {
		return seasons;
	}
	
	

	public String getImdbId() {
		return imdbId;
	}




	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}




	public void setSeasons(List<ShowSeason> seasons) {
		this.seasons = seasons;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public void setFirstAirDate(String firstAirDate) {
		this.firstAirDate = firstAirDate;
	}

	public String getLastAirDate() {
		return lastAirDate;
	}

	public void setLastAirDate(String lastAirDate) {
		this.lastAirDate = lastAirDate;
	}

	public int getNumOfSeasons() {
		return numOfSeasons;
	}

	public void setNumOfSeasons(int numOfSeasons) {
		this.numOfSeasons = numOfSeasons;
	}
	
	
	
}

package com.db.msapi.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tv_seasons")
public class ShowSeason {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seasonId;
	private String name;
	private String airDate;
	private Integer episodeCount;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showdetails_id",referencedColumnName = "idSDetails")
	private ShowDetails showDetailsSes;
	
	public ShowSeason() {
	}

	public ShowSeason(String name, String airDate, Integer episodeCount) {
		super();
		this.name = name;
		this.airDate = airDate;
		this.episodeCount = episodeCount;
	}
	
	public long getSeasonId() {
		return seasonId;
	}

	public void setShowDetails(ShowDetails showDetails) {
		this.showDetailsSes = showDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAirDate() {
		return airDate;
	}

	public void setAirDate(String airDate) {
		this.airDate = airDate;
	}

	public Integer getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(Integer episodeCount) {
		this.episodeCount = episodeCount;
	}

	
	
	
	
}

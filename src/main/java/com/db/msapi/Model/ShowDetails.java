package com.db.msapi.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
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
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "showDetails")
    private Show show;
	
	@OneToMany(mappedBy = "showDetailsSes", fetch = FetchType.LAZY)
	private List<ShowSeason> seasons = new ArrayList<>();
	
	
	public ShowDetails(String imdbId, String firstAirDate, String lastAirDate, int numOfSeasons,
			List<ShowSeason> seasons) {
		super();
		this.imdbId = imdbId;
		this.firstAirDate = firstAirDate;
		this.lastAirDate = lastAirDate;
		this.numOfSeasons = numOfSeasons;
		this.seasons = seasons;
	}

	
	
}

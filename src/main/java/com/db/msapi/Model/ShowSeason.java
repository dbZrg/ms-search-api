package com.db.msapi.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
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


	public ShowSeason(String name, String airDate, Integer episodeCount) {
		super();
		this.name = name;
		this.airDate = airDate;
		this.episodeCount = episodeCount;
	}
	

	
	
}

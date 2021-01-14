package com.db.msapi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.db.msapi.Model.Show;
import com.db.msapi.Model.ShowDetails;
import com.db.msapi.Model.ShowSeason;
import com.db.msapi.Repository.SeasonsRep;
import com.db.msapi.Repository.ShowDetailsRep;
import com.db.msapi.Repository.ShowRep;
import com.db.msapi.externalApi.ExternalApi;
import com.db.msapi.util.LuceneSearch;

@Service
public class ShowService {

	@Autowired
	private ShowRep showRep;
	@Autowired
	private ShowDetailsRep showDetailsRep;
	@Autowired
	private SeasonsRep seasonRep;
	@Autowired
	ExternalApi externalApi;
	@Autowired
	private LuceneSearch luceneSearch;
	
	/**
	 * <p>Get all TV shows from database</p>
	 * @return list of Show objects 
	 */
	public List<Show> getAllShows(){
		List<Show> list = new ArrayList<Show>();
		showRep.findAll().forEach(list::add);
		return list;
	}
	
	/**
	 * <p>Search for TV show, if there is no exact match in database,
	 * fetch TV shows using external API-s and save to database</p>
	 * @param str search term
	 * @return list of Show objects sorted by relevance to search term
	 */
	public List<Show> getShowsByName(String str){
		
		if(!showRep.existsByName(str)) {
			for(Show show : externalApi.getShowList(str) ) {
				if(!showRep.existsByMdbId(show.getMdbId())) {
				ShowDetails showDet = externalApi.getShowDetails(show.getMdbId());		
				showDetailsRep.save(showDet);
				for(ShowSeason season: showDet.getSeasons()) {
					season.setShowDetailsSes(showDet);
					seasonRep.save(season);
				}
				show.setShowDetails(showDet);
				showRep.save(show);
				}
			}
		}	
		return luceneSearch.getByName(str, 5000, Show.class);
	}
	
	/**
	 * <p>Get Show by id</p>
	 * @param id TV show id
	 * @return Show object 
	 */
	public Optional<Show> getShow(Long id){
		Optional<Show> show = showRep.findById(id);
		if(show.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No TV Show found");
		return show; 
	}
	
	/**
	 * <p>Get ShowDetails by id</p>
	 * @param id TV show id
	 * @return ShowDetails object 
	 */
	public ShowDetails getShowDetails(Long id) {
		ShowDetails showDet = showDetailsRep.findByShow_id(id);
		if(showDet == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No TV Show details found");
		return showDet;
	}
	
	/**
	 * <p>Get Seasons by ShowDetails id</p>
	 * @param id ShowDetails id
	 * @return List of ShowSeason objects 
	 */
	public List<ShowSeason> getShowSeasons(Long id){
		List<ShowSeason> seasons = seasonRep.findByShowDetailsSesIdSDetails(id);
		if(seasons.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No TV Show seasons found");
		return seasons;
	}
}

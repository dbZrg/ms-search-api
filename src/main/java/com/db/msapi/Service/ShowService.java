package com.db.msapi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<Show> getAllShows(){
		List<Show> list = new ArrayList<Show>();
		showRep.findAll().forEach(list::add);
		return list;
	}
	
	public List<Show> getShowsByName(String str){
		
		if(!showRep.existsByName(str)) {
			for(Show show : externalApi.getShowList(str) ) {
				if(!showRep.existsByMdbId(show.getMdbId())) {
				ShowDetails showDet = externalApi.getShowDetails(show.getMdbId());		
				showDetailsRep.save(showDet);
				for(ShowSeason season: showDet.getSeasons()) {
					season.setShowDetails(showDet);
					seasonRep.save(season);
				}
				show.setShowDetails(showDet);
				showRep.save(show);
				}
			}
		}	
		return luceneSearch.getByName(str, 5000, Show.class);
		}
	
	public Optional<Show> getShow(Long id){
		return showRep.findById(id);
	}
	
	public ShowDetails getShowDetails(Long id) {
		return showDetailsRep.findByShow_id(id);
	}
	
	public List<ShowSeason> getShowSeasons(Long id){
		return seasonRep.findByShowDetailsSesIdSDetails(id);
	}
}

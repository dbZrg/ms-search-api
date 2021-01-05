package com.db.msapi.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.db.msapi.Model.Media;
import com.db.msapi.Model.Movie;
import com.db.msapi.Model.MovieDetails;
import com.db.msapi.Model.Show;
import com.db.msapi.Model.ShowDetails;
import com.db.msapi.Model.ShowSeason;
import com.db.msapi.Repository.MediaRep;
import com.db.msapi.Repository.MovieRep;
import com.db.msapi.Repository.SeasonsRep;
import com.db.msapi.Repository.ShowDetailsRep;
import com.db.msapi.Repository.ShowRep;
import com.db.msapi.externalApi.ExternalApi;
import com.db.msapi.util.LuceneSearch;

@Service
public class MediaService {

	@Autowired
	private MediaRep mediaRep;
	@Autowired
	private MovieRep movieRep;
	@Autowired
	private ShowRep showRep;
	@Autowired
	private ShowDetailsRep showDetailsRep;
	@Autowired
	private SeasonsRep seasonRep;
	@Autowired
	private ExternalApi externalApi;
	@Autowired
	private LuceneSearch luceneSearch;
	
	

	public List<Media> getAllMedia(){
		List<Media> list = new ArrayList<Media>();
		mediaRep.findAll().forEach(list::add);
		return list;
	}
	
	public List<Media> searchAllMedia(String str){
		
		if(!movieRep.existsByName(str)) {
			for(Movie movie : externalApi.getMoviesList(str) ) {
				if(!movieRep.existsByMdbId(movie.getMdbId())) {
				MovieDetails movDet = externalApi.getMovieDetails(movie.getMdbId());		
				movie.setMovieDetails(movDet);
				movieRep.save(movie);
				}
			}
		}
		
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

		return luceneSearch.getByName(str,5000, Media.class);
	}
	
	
	
}

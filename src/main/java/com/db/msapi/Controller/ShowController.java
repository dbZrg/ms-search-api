package com.db.msapi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.db.msapi.Model.Show;
import com.db.msapi.Model.ShowDetails;
import com.db.msapi.Model.ShowSeason;
import com.db.msapi.Service.ShowService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class ShowController {
	
	@Autowired
	private ShowService showService;
	
	@ApiOperation("Get all tv shows")
	@GetMapping("/shows/")
	public List<Show> getAllShows() {
		return showService.getAllShows();
	}
	
	@ApiOperation("Get tv shows by TITLE")
	@GetMapping("/shows/{str}")
	public List<Show> getShowsByName(@ApiParam(
			value = "Title of tv show",
	        required = true, 
	        defaultValue = "The Office")@PathVariable String str){
		return showService.getShowsByName(str);
	}
	
	@ApiOperation("Get tv show by ID")
	@GetMapping("/show/{id}")
	public Optional<Show> getShow(@ApiParam(
			value = "tv show id",
	        required = true)@PathVariable Long id) {
		return showService.getShow(id);
	}
	
	@ApiOperation("Get tv show details by TV SHOW ID")
	@GetMapping("/show/details/{id}")
	public ShowDetails getShowDetails(@ApiParam(
			value = "tv show id",
	        required = true)@PathVariable Long id) {
		return showService.getShowDetails(id);
	}
	@ApiOperation("Get all seasons by TV SHOW DETAILS ID")
	@GetMapping("/show/seasons/{id}")
	public List<ShowSeason> getShowSeason(@ApiParam(
			value = "tv show details id",
	        required = true)@PathVariable Long id) {
		return showService.getShowSeasons(id);
	}
}

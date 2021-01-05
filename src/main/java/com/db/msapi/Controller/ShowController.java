package com.db.msapi.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.db.msapi.Mappers.OutputMapper;
import com.db.msapi.Model.Show;
import com.db.msapi.Model.ShowDetails;
import com.db.msapi.Model.ShowSeason;
import com.db.msapi.Service.ShowService;
import com.db.msapi.response.output.MediaOut;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Validated
@RestController
public class ShowController {
	@Autowired
	private OutputMapper outMapper;
	@Autowired
	private ShowService showService;
	
	@ApiOperation("Get all tv shows")
	@GetMapping("/shows/")
	public List<MediaOut> getAllShows() {
		
		List<MediaOut> output = outMapper.toMediaOutListS(showService.getAllShows());
		
		for (MediaOut media : output) {
			 media.add(linkTo(ShowController.class).slash("/show").slash(media.getId()).withSelfRel());
			 media.add(linkTo(methodOn(ShowController.class).getShowDetails(media.getId())).withRel("show details"));				
		}
		return output;
	}
	
	@ApiOperation("Get tv shows by TITLE")
	@GetMapping("/shows/{str}")
	public List<MediaOut> getShowsByName(@ApiParam(
			value = "Title of tv show",
	        required = true, 
	        defaultValue = "Curb Your Enthusiasm")@PathVariable @Size(min=3,max=35) String str){
		
		List<MediaOut> output = outMapper.toMediaOutListS(showService.getShowsByName(str));
		
		for (MediaOut media : output) {
			 media.add(linkTo(ShowController.class).slash("/show").slash(media.getId()).withSelfRel());
			 media.add(linkTo(methodOn(ShowController.class).getShowDetails(media.getId())).withRel("show details"));				
		}
		return output;
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

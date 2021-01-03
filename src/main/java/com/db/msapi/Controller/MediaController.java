package com.db.msapi.Controller;


import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.db.msapi.Mappers.OutputMapper;
import com.db.msapi.Service.MediaService;
import com.db.msapi.response.output.MediaOut;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class MediaController {
	
	@Autowired
	private OutputMapper outMapper;
	@Autowired
	private MediaService mediaService;
	
	@ApiOperation("Get all movies and tv shows")
	@GetMapping("/all/")
	public List<MediaOut> getAllMoviesAndShows() {
		List<MediaOut> output = outMapper.toMediaOutList(mediaService.getAllMedia());
		for (MediaOut media : output) {
			if(media.getMedia_type().equals("movie")) {
				 media.add(linkTo(MovieController.class).slash("/movie").slash(media.getId()).withSelfRel());
				 media.add(linkTo(methodOn(MovieController.class).getMovieDetails(media.getId())).withRel("movie details"));				
				}
			else if(media.getMedia_type().equals("show")) {
				media.add(linkTo(ShowController.class).slash("/show").slash(media.getId()).withSelfRel());
				media.add(linkTo(methodOn(ShowController.class).getShowDetails(media.getId())).withRel("show details"));
			}
		}
		return output;
	}
	@ApiOperation("Get movies and tv shows by TITLE")
	@GetMapping("/all/{str}")
	public List<MediaOut> searchAllMoviesAndShows(@ApiParam(
			value = "Title of move or TV show",
	        required = true, 
	        defaultValue = "Rick and Morty")@PathVariable @Min(3) @Max(20) String str) {
		
		List<MediaOut> output = outMapper.toMediaOutList(mediaService.searchAllMedia(str));
		for (MediaOut media : output) {
			if(media.getMedia_type().equals("movie")) {
				 media.add(linkTo(MovieController.class).slash("/movie").slash(media.getId()).withSelfRel());
				 media.add(linkTo(methodOn(MovieController.class).getMovieDetails(media.getId())).withRel("movie details"));				
				}
			else if(media.getMedia_type().equals("show")) {
				media.add(linkTo(ShowController.class).slash("/show").slash(media.getId()).withSelfRel());
				media.add(linkTo(methodOn(ShowController.class).getShowDetails(media.getId())).withRel("show details"));
			}
		}
		
		return output;
	}
	
}

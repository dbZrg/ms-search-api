package com.db.msapi.Controller;


import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.db.msapi.Mappers.OutputMapper;
import com.db.msapi.Service.MediaService;
import com.db.msapi.response.output.MediaOut;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Validated
@RestController
public class MediaController {
	
	@Autowired
	private OutputMapper outMapper;
	@Autowired
	private MediaService mediaService;
	
	@ApiIgnore
	@GetMapping("/")
	public String message() {
		return "Api documentation -->  http://localhost:8080/swagger-ui/ ";
	}
	
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
	        defaultValue = "Rick and Morty")@PathVariable("str") @Size(min=3,max=35) String str) {
		
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

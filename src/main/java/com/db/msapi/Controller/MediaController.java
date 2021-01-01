package com.db.msapi.Controller;


import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.db.msapi.Model.Media;
import com.db.msapi.Service.MediaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
public class MediaController {

	@Autowired
	private MediaService mediaService;
	
	@ApiOperation("Get all movies and tv shows")
	@GetMapping("/all/")
	public List<Media> getAllMoviesAndShows() {
		return mediaService.getAllMedia();
	}
	@ApiOperation("Get movies and tv shows by title")
	@GetMapping("/all/{searchTerm}")
	public List<Media> searchAllMoviesAndShows(@PathVariable @Min(3) @Max(20) String searchTerm) {
		return mediaService.searchAllMedia(searchTerm);
	}
	
	@ApiOperation("Get movies and tv shows by title or description")
	@GetMapping("/all/td/{searchTerm}")
	public List<Media> searchAllMoviesAndShowsByTileAndDesc(@ApiParam(
			value = "Title of movie or tv show",
	        required = true, 
	        defaultValue = "Rick and Morty")@PathVariable @Min(3) @Max(20) String searchTerm) {
		return mediaService.searchAllMediaTitleAndDesc(searchTerm);
	}
	
	

}

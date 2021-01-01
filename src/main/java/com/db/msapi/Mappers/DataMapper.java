package com.db.msapi.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.db.msapi.Model.Movie;
import com.db.msapi.Model.MovieDetails;
import com.db.msapi.Model.Show;
import com.db.msapi.Model.ShowDetails;
import com.db.msapi.response.openmoviedb.*;
import com.db.msapi.response.themoviedb.*;

@Mapper(componentModel ="spring")
public interface DataMapper {
	@Mapping(source="id",target ="mdbId")
	@Mapping(source="title",target ="name")
	@Mapping(source="overview",target ="description")
	@Mapping(source="posterPath",target ="image_path")
	@Mapping(source="originalLanguage",target ="language")
	@Mapping(source="voteAverage",target ="rating")
	Movie toMovie(MovieResponse entity);
	
	@Mapping(source="entity.imdbId",target ="imdbId")
	@Mapping(source="entity.revenue",target ="revenue")
	@Mapping(source="entity.releaseDate",target ="releaseDate")
	@Mapping(source="entity2.writer",target ="writer")
	@Mapping(source="entity2.director",target ="director")
	@Mapping(source="entity2.genre",target ="genres")
	MovieDetails toMovieDetails(MovieDetailsResponse entity,MovieResponseOmdb entity2);
	
	@Mapping(source="id",target ="mdbId")
	@Mapping(source="name",target ="name")
	@Mapping(source="overview",target ="description")
	@Mapping(source="posterPath",target ="image_path")
	@Mapping(source="originalLanguage",target ="language")
	@Mapping(source="voteAverage",target ="rating")
	Show toShow(ShowResponse entity);
	
	@Mapping(source="firstAirDate",target ="firstAirDate")
	@Mapping(source="lastAirDate",target ="lastAirDate")
	@Mapping(source="numberOfSeasons",target ="numOfSeasons")
	@Mapping(source="seasons",target ="seasons")
	@Mapping(source="externalIds.imdbId",target ="imdbId")
	ShowDetails toShowDetails(ShowDetailsResponse entity);
	
}

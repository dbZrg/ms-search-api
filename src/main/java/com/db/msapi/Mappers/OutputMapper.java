package com.db.msapi.Mappers;
import java.util.List;

import org.mapstruct.Mapper;
import com.db.msapi.Model.Media;
import com.db.msapi.Model.Movie;
import com.db.msapi.Model.Show;
import com.db.msapi.response.output.MediaOut;

@Mapper(componentModel ="spring")
public interface OutputMapper {
	MediaOut toMediaOut(Media entity);
	MediaOut toMediaOutM(Movie entity);
	MediaOut toMediaOutS(Show entity);
	List<MediaOut> toMediaOutList(List<Media> list);
	List<MediaOut> toMediaOutListM(List<Movie> list);
	List<MediaOut> toMediaOutListS(List<Show> list);
}

package com.db.msapi.Mappers;
import java.util.List;

import org.mapstruct.Mapper;
import com.db.msapi.Model.Media;
import com.db.msapi.response.output.MediaOut;

@Mapper(componentModel ="spring")
public interface OutputMapper {
	MediaOut toMediaOut(Media entity);
	List<MediaOut> toMediaOutList(List<Media> list);
}

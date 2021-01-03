package com.db.msapi.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.msapi.Model.MovieDetails;

@Repository
public interface MovieDetailsRep extends CrudRepository<MovieDetails,Long> {
	MovieDetails findByMovie_id(@Param("id")Long id);
}

package com.db.msapi.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.db.msapi.Model.MovieDetails;

@Repository
public interface MovieDetailsRep extends CrudRepository<MovieDetails,Long> {

}

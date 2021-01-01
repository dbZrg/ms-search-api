package com.db.msapi.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.msapi.Model.Movie;

@Repository
public interface MovieRep extends CrudRepository<Movie,Long> {
	
	List<Movie> findByNameLike(@Param("name") String name);
	List<Movie> findByNameContainingIgnoreCase(@Param("name")String name);
	boolean existsByName(@Param("name")String name);
	boolean existsByMdbId(@Param("mdbId")Long mdbId);
}

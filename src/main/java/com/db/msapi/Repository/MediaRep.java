package com.db.msapi.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.msapi.Model.Media;

@Repository
public interface MediaRep extends CrudRepository<Media, Long> {
	
	List<Media> findByName(@Param("name") String name);
	List<Media> findByNameContainingIgnoreCase(@Param("name")String name);
	boolean existsByName(@Param("name")String name);
	
}
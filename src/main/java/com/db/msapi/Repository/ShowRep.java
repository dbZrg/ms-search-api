package com.db.msapi.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.db.msapi.Model.Show;

@Repository
public interface ShowRep extends CrudRepository<Show,Long> {
	List<Show> findByName(@Param("name") String name);
	List<Show> findByNameContainingIgnoreCase(String name);
	boolean existsByName(@Param("name")String name);
	boolean existsByMdbId(@Param("mdbId")Long mdbId);
}

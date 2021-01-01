package com.db.msapi.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.msapi.Model.ShowSeason;

@Repository
public interface SeasonsRep extends CrudRepository<ShowSeason,Long> {
	List<ShowSeason> findByShowDetailsSesIdSDetails(@Param("idSDetails")Long id);
}

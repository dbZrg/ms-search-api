package com.db.msapi.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.db.msapi.Model.ShowDetails;

@Repository
public interface ShowDetailsRep extends CrudRepository<ShowDetails,Long> {

}

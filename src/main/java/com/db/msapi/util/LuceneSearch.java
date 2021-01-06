package com.db.msapi.util;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class LuceneSearch {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * <p>Get all T objects from database</p>
	 * @param fetchNum number of hits allowed
	 * @param clazz query class
	 * @return list of all T objects in database 
	 */
	public <T> List<T> getAll(int fetchNum, Class<T> clazz){
	
		entityManager.clear();
		SearchSession searchSession = Search.session( entityManager ); 
		
		SearchResult<T> result = searchSession.search(clazz) 
		        .where( f -> f.matchAll())
		        .fetch(fetchNum); 

		List<T> hits = result.hits();
		return hits.stream().distinct().collect(Collectors.toList());
	}
	
	/**
	 * <p>Find all T objects in database where name is closely matching search term</p>
	 * @param str search term
	 * @param fetchNum number of hits allowed
	 * @param clazz query class
	 * @return list of all T objects in database sorted by relevance to search term
	 */
	public <T> List<T> getByName(String str, int fetchNum, Class<T> clazz){
		
		entityManager.clear();
		SearchSession searchSession = Search.session( entityManager ); 

		SearchResult<T> result = searchSession.search(clazz) 
		        .where( f -> f.match() 
		        		.field("name")
		        		.matching(str))
		        .fetch(fetchNum); 

		List<T> hits = result.hits();
		return hits.stream().distinct().collect(Collectors.toList());
	}
	

	
	
}

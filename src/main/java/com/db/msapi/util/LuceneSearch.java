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
	
	public <T> List<T> getAll(int fetchNum, Class<T> clazz){
		entityManager.flush();
		SearchSession searchSession = Search.session( entityManager ); 

		SearchResult<T> result = searchSession.search(clazz) 
		        .where( f -> f.matchAll())
		        .fetch(fetchNum); 

		List<T> hits = result.hits();

		
		return hits.stream().distinct().collect(Collectors.toList());
	}
	
	public <T> List<T> getByName(String str, int fetchNum, Class<T> clazz){
		entityManager.flush();
		SearchSession searchSession = Search.session( entityManager ); 

		SearchResult<T> result = searchSession.search(clazz) 
		        .where( f -> f.match() 
		        		.field("name")
		        		.matching(str))
		        .fetch(fetchNum); 

		List<T> hits = result.hits();

	
		return hits.stream().distinct().collect(Collectors.toList());
	}
	
	public <T> List<T> getByNameOrDesc(String str, int fetchNum, Class<T> clazz){
		SearchSession searchSession = Search.session( entityManager ); 
		
		List<T> hits = searchSession.search(clazz )
		        .where( f -> f.bool()
		                .should( f.match().field( "name" )
		                        .matching( str ) ) 
		                .should( f.match().field( "description" )
		                        .matching( str) ) 
		        )
		        .fetchHits( fetchNum );
	
		entityManager.flush();

		return hits.stream().distinct().collect(Collectors.toList());
	}

	
	
}

package com.web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.web.model.Pro;

public interface ProRepo extends CrudRepository<Pro, Long> {
	@Query("SELECT p FROM Pro p WHERE " + "p.email LIKE CONCAT('%', :query, '%') "
			+ "OR p.expctc LIKE CONCAT('%', :query, '%')" + "OR p.notice LIKE CONCAT('%', :query, '%')"
			+ "OR p.immi LIKE CONCAT('%', :query, '%')" + "OR p.id LIKE CONCAT('%', :query, '%')"
			+ "OR p.domain LIKE CONCAT('%', :query, '%')" + "OR p.expertise LIKE CONCAT('%', :query, '%')"
			+ "OR p.expy LIKE CONCAT('%', :query, '%')")
	List<Pro> searchPro(@Param("query") String query);

	Pro findByEmail(String email);

	List<Pro> findAll();

	Pro deleteByEmail(String email);

}

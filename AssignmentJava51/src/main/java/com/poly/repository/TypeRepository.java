package com.poly.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.entity.Type_Video;
@Repository
public interface TypeRepository extends JpaRepository<Type_Video, Integer>{
	List<Type_Video> findByActive(boolean active);
	Page<Type_Video> findAllByActive(boolean active, Pageable pageable);
	
	    @Query("UPDATE Type_Video tv SET tv.active = :active WHERE tv.id = :id")
	    void updateStatus(@Param("id") int id, @Param("active") boolean active);
}

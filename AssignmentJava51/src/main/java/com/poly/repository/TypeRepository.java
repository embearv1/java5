package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.entity.Type_Video;
@Repository
public interface TypeRepository extends JpaRepository<Type_Video, Integer>{
	List<Type_Video> findByActive(boolean active);
}

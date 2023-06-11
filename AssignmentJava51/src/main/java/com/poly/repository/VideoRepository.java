package com.poly.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.entity.Type_Video;
import com.poly.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
	List<Video> findTop6ByActiveOrderByViewsDesc(boolean active);

	List<Video> findTop4ByActiveOrderByIdDesc(boolean active);

	Page<Video> findAllByActive(boolean active, Pageable pageable);
	
	Page<Video> findAllByTypeAndActive(Type_Video type,boolean active,Pageable pageable);
}

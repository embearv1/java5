package com.poly.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.entity.Account;
import com.poly.entity.History;
import com.poly.entity.Video;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {
	@Query("Select h From History h where h.video.id=:aid and h.user.id=:bid")
	History findByIdVideoandIdUser(@Param("aid") int id_video, @Param("bid") int id_user);

	@Query("SELECT DISTINCT history.video FROM History history "
			+ "WHERE history.user.id = :userId AND history.is_liked = true AND history.video.active = true "
			+ "ORDER BY history.video.title DESC")
	List<Video> getVideoByHis(@Param("userId") int id_user);

	List<History> findByUser(Account user);

}

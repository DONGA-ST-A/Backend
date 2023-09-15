package com.teamA.hicardi.domain.notice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.teamA.hicardi.domain.notice.entity.Notice;
import com.teamA.hicardi.domain.notice.entity.NoticeCategory;
import io.lettuce.core.dynamic.annotation.Param;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

	@Query("SELECT n FROM Notice n " +
		"WHERE (n.isTop = true OR n.category = :category) " +
		"ORDER BY n.isTop DESC, n.createdDate DESC")
	Page<Notice> findAllOrderedByIsTopAndCategory(@Param("category") NoticeCategory category, Pageable pageable);

	@Query("SELECT n FROM Notice n ORDER BY n.isTop DESC, n.createdDate DESC")
	Page<Notice> findAllOrderedByIsTopAndCreateDate(Pageable pageable);
}

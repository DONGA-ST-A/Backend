package com.teamA.hicardi.domain.notice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.teamA.hicardi.domain.notice.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
	@Query("SELECT n FROM Notice n ORDER BY n.isTop DESC, n.createdDate DESC")
	Page<Notice> findAllOrderedByIsTopAndCreateDate(Pageable pageable);
}

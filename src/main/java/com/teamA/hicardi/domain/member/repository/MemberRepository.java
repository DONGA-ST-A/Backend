package com.teamA.hicardi.domain.member.repository;

import com.teamA.hicardi.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Boolean existsByEmail(String email);
    Boolean existsByUserId(String userId);
    Optional<Member> findByUserId(String userId);

}
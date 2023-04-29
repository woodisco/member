package com.example.member.repository;

import com.example.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 등록
    Member save(Member member);

    // 조회 (id) : Null일 경우를 위해 Optional
    Optional<Member> findById(Integer id);

    // 조회 (이름) : Null일 경우를 위해 Optional
    Optional<Member> findByName(String name);

    // 리스트
    List<Member> findAll();
}

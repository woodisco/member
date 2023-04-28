package com.example.member.service;

import com.example.member.domain.Member;
import com.example.member.repository.MemberRepository;
import com.example.member.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 등록
    public Long create(Member member) {
        // 중복검사
        memberRepository.findByName(member.getName())
                .ifPresent(member1 -> {throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        memberRepository.save(member);
        return member.getId();
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 조회 (id)
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

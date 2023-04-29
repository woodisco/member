package com.example.member.service;

import com.example.member.domain.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    // 등록
    public Integer create(Member member) {
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
    public Optional<Member> findOne(Integer memberId) {

        return memberRepository.findById(memberId);
    }
}

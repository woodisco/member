package com.example.member.service;

import com.example.member.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService = new MemberService();

    @Test
    void create() {
        // given
        Member member = new Member();
        member.setName("test");

        // when
        Long saveMember = memberService.create(member);

        // then
        Member findMember = memberService.findOne(saveMember).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
}
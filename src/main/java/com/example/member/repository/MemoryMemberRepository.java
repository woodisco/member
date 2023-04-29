package com.example.member.repository;

import com.example.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Integer, Member> store = new HashMap<>();
    private static Integer seq = 0;

    @Override
    public Member save(Member member) {
        member.setId(++seq);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Integer id) {

        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {

        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList<>(store.values());
    }
}

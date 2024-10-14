package com.fuxuras.memorycards.services;

import com.fuxuras.memorycards.models.Member;
import com.fuxuras.memorycards.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getMemberByUsername(String name) {
        return memberRepository.getMemberByUsername(name);
    }

    public boolean createMember(String username, String password) {
        if (memberRepository.existsByUsername(username)) {
            return false;
        }
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        memberRepository.save(member);
        return true;
    }
}

package com.fuxuras.memorycards.services;

import com.fuxuras.memorycards.models.Member;
import com.fuxuras.memorycards.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member getMemberByUsername(String name) {
        return memberRepository.getMemberByUsername(name);
    }

    public boolean createMember(String username, String password) {
        if (memberRepository.existsByUsername(username)) {
            return false;
        }
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));
        memberRepository.save(member);
        return true;
    }

    public void updateMember(Member member) {
        memberRepository.save(member);
    }
}

package com.fuxuras.memorycards.services;

import com.fuxuras.memorycards.models.Member;
import com.fuxuras.memorycards.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getMemberByUsername(String name) {
        return memberRepository.getMemberByUsername(name);
    }
}

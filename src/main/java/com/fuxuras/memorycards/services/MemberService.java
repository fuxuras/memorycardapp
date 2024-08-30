package com.fuxuras.memorycards.services;

import com.fuxuras.memorycards.models.Member;
import com.fuxuras.memorycards.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

}

package com.fuxuras.memorycards.repositories;

import com.fuxuras.memorycards.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member getMemberByUsername(String username);
    boolean existsByUsername(String username);
}

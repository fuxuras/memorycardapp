package com.fuxuras.memorycards.repositories;

import com.fuxuras.memorycards.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}

package com.fuxuras.memorycards.repositories;

import com.fuxuras.memorycards.models.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Long> {
}

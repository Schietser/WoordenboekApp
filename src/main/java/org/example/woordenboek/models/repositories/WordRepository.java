package org.example.woordenboek.models.repositories;

import org.example.woordenboek.models.entities.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<WordEntity, Long> {
}

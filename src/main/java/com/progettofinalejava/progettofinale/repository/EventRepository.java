package com.progettofinalejava.progettofinale.repository;

import com.progettofinalejava.progettofinale.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

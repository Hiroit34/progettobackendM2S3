package com.progettofinalejava.progettofinale.repository;

import com.progettofinalejava.progettofinale.entity.Booking;
import com.progettofinalejava.progettofinale.entity.Event;
import com.progettofinalejava.progettofinale.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
    List<Booking> findByEvent(Event event);
}

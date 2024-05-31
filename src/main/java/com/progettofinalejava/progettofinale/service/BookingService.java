package com.progettofinalejava.progettofinale.service;

import com.progettofinalejava.progettofinale.dto.BookingDTO;
import com.progettofinalejava.progettofinale.entity.Booking;
import com.progettofinalejava.progettofinale.entity.Event;
import com.progettofinalejava.progettofinale.entity.User;
import com.progettofinalejava.progettofinale.mapper.BookingMapper;
import com.progettofinalejava.progettofinale.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;

    public BookingDTO bookEvent(User user, Event event) {
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setEvent(event);
        return bookingMapper.toDTO(bookingRepository.save(booking));
    }

    public List<BookingDTO> getBookingsByUser(User user) {
        return bookingRepository.findByUser(user).stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<BookingDTO> getBookingsByEvent(Event event) {
        return bookingRepository.findByEvent(event).stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}

package edu.unimagdalena.pw.myapi.services;

import edu.unimagdalena.pw.myapi.api.dto.Booking;
import edu.unimagdalena.pw.myapi.entidades.BookingStatus;

import java.util.List;

public interface BookingService {
    Booking createBooking(Integer idFlight, Integer idUser, Booking booking);

    Booking getBooking(Integer id);

    Booking update(Integer id, Booking booking);

    Booking delete(Integer id);

    List<Booking> findAllByParams(BookingStatus status, String customerName);

    List<Booking> findAllByFlight(Integer idFlight);
}

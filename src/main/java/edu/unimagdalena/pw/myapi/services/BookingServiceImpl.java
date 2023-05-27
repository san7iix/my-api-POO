package edu.unimagdalena.pw.myapi.services;

import edu.unimagdalena.pw.myapi.api.dto.Booking;
import edu.unimagdalena.pw.myapi.entidades.BookingStatus;

import java.util.List;

public class BookingServiceImpl implements BookingService{
    @Override
    public Booking createBooking(Integer idFlight, Integer idUser, Booking booking) {
        return null;
    }

    @Override
    public Booking getBooking(Integer id) {
        return null;
    }

    @Override
    public Booking update(Integer id, Booking booking) {
        return null;
    }

    @Override
    public Booking delete(Integer id) {
        return null;
    }

    @Override
    public List<Booking> findAllByParams(BookingStatus status, String customerName) {
        return null;
    }

    @Override
    public List<Booking> findAllByFlight(Integer idFlight) {
        return null;
    }


}

package edu.unimagdalena.pw.myapi.services;

import edu.unimagdalena.pw.myapi.api.dto.Booking;
import edu.unimagdalena.pw.myapi.api.dto.mappers.BookingMapper;
import edu.unimagdalena.pw.myapi.entidades.BookingEntity;
import edu.unimagdalena.pw.myapi.entidades.BookingStatus;
import edu.unimagdalena.pw.myapi.repositories.JpaBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    @Autowired
    JpaBookingRepository bookingRepository;

    @Override
    public Booking createBooking(Integer idFlight, Integer idUser, Booking booking) {
        Optional<BookingEntity> bookingEntity = bookingRepository.findById(idFlight);

        if (bookingEntity.isEmpty()) {
            throw new RuntimeException("No se encontro el vuelo");
        }

        return BookingMapper.toDTO(bookingRepository.save(BookingMapper.toEntity(booking)));

    }

    @Override
    public Booking getBooking(Integer id) {
        Optional<BookingEntity> bookingEntity = bookingRepository.findById(id);

        if (bookingEntity.isEmpty()) {
            throw new RuntimeException("No se encontro el vuelo");
        }

        return BookingMapper.toDTO(bookingEntity.get());
    }

    @Override
    public Booking update(Integer id, Booking booking) {
        Optional<BookingEntity> bookingEntity = bookingRepository.findById(id);

        if (bookingEntity.isEmpty()) {
            throw new RuntimeException("No se encontro el vuelo");
        }

        return BookingMapper.toDTO(bookingRepository.save(BookingMapper.toEntity(booking)));
    }

    @Override
    public Booking delete(Integer id) {
        Optional<BookingEntity> bookingEntity = bookingRepository.findById(id);

        if (bookingEntity.isEmpty()) {
            throw new RuntimeException("No se encontro el vuelo");
        }

        bookingRepository.deleteById(id);
        return BookingMapper.toDTO(bookingEntity.get());
    }

    @Override
    public List<Booking> findAllByParams(BookingStatus status, String customerName) {
        if (status != null && customerName != null) {
            return bookingRepository.findByUserNameAndStatus(customerName, status).stream().map(BookingMapper::toDTO).collect(Collectors.toList());
        } else if (status != null) {
            return bookingRepository.findByStatus(status).stream().map(BookingMapper::toDTO).collect(Collectors.toList());
        } else if (customerName != null) {
            return bookingRepository.findByUser(customerName).stream().map(BookingMapper::toDTO).collect(Collectors.toList());
        } else {
            return bookingRepository.findAll().stream().map(BookingMapper::toDTO).collect(Collectors.toList());
        }
    }

    @Override
    public List<Booking> findAllByFlight(Integer idFlight) {
        return bookingRepository.findByFlight(idFlight).stream().map(BookingMapper::toDTO).collect(Collectors.toList());
    }


}

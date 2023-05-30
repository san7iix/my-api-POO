package edu.unimagdalena.pw.myapi.api.dto.mappers;

import edu.unimagdalena.pw.myapi.api.dto.Booking;
import edu.unimagdalena.pw.myapi.entidades.BookingEntity;

public class BookingMapper {


    public static Booking toDTO(BookingEntity booking) {

        Booking bookingDTO = new Booking();

        bookingDTO.setId(booking.getId());
        bookingDTO.setBookingReference(booking.getBookingReference());
        bookingDTO.setUser(new UserMapper().toDto(booking.getUser()));
        bookingDTO.setCheckedIn(booking.getCheckedIn());
        bookingDTO.setStatus(booking.getStatus());
        bookingDTO.setPaymentToken(booking.getPaymentToken());
        bookingDTO.setCreatedAt(booking.getCreatedAt());

        return bookingDTO;

    }

    public static BookingEntity toEntity(Booking booking) {

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setId(booking.getId());
        bookingEntity.setBookingReference(booking.getBookingReference());
        bookingEntity.setUser(new UserMapper().toEntity(booking.getUser()));
        bookingEntity.setCheckedIn(booking.getCheckedIn());
        bookingEntity.setStatus(booking.getStatus());
        bookingEntity.setPaymentToken(booking.getPaymentToken());
        bookingEntity.setCreatedAt(booking.getCreatedAt());

        return bookingEntity;

    }

}

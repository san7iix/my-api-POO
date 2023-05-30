package edu.unimagdalena.pw.myapi.repositories;

import edu.unimagdalena.pw.myapi.entidades.BookingEntity;
import edu.unimagdalena.pw.myapi.entidades.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaBookingRepository extends JpaRepository<BookingEntity, Integer> {


    @Query("SELECT b FROM BookingEntity b WHERE b.status = ?1")
    List<BookingEntity> findByStatus(BookingStatus status);

    @Query("SELECT b FROM BookingEntity b WHERE b.user.fullName = ?1")
    List<BookingEntity> findByUser(String user);

    @Query("SELECT b FROM BookingEntity b WHERE b.user.fullName = ?1 AND b.status = ?2")
    List<BookingEntity> findByUserNameAndStatus(String user, BookingStatus status);

    @Query("SELECT b FROM BookingEntity b WHERE b.flight.id = ?1")
    List<BookingEntity> findByFlight(Integer idFlight);

}

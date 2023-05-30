package edu.unimagdalena.pw.myapi.repositories;

import edu.unimagdalena.pw.myapi.api.dto.Fligth;
import edu.unimagdalena.pw.myapi.entidades.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaFlightRepository extends JpaRepository<FlightEntity, Integer> {


    @Query("SELECT f FROM Fligth f WHERE f.departureAirportCode = ?1 AND f.arrivalAirportCode = ?2 AND f.departureDate = ?3")
    List<FlightEntity> findByParameters(String departureAirportCode, String arrivalAirportCode, String departureDate);

    @Query("SELECT f FROM Fligth f WHERE f.departureAirportCode = ?1 AND f.departureDate = ?2")
    List<FlightEntity> findByAirportCodeAndDepartureDate(String departureAirportCode, String departureDate);

}

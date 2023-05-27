package edu.unimagdalena.pw.myapi.repositories;

import edu.unimagdalena.pw.myapi.api.dto.Fligth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaFlightRepository extends JpaRepository<Fligth, Integer> {


    @Query("SELECT f FROM Fligth f WHERE f.departureAirportCode = ?1 AND f.arrivalAirportCode = ?2 AND f.departureDate = ?3")
    Fligth findByParameters(String departureAirportCode, String arrivalAirportCode, String departureDate);

    @Query("SELECT f FROM Fligth f WHERE f.departureAirportCode = ?1 AND f.departureDate = ?2")
    Fligth findByAirportCodeAndDepartureDate(String departureAirportCode, String departureDate);

}

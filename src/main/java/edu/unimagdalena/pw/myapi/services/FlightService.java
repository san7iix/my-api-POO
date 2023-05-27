package edu.unimagdalena.pw.myapi.services;

import edu.unimagdalena.pw.myapi.api.dto.Fligth;

import java.util.List;

public interface FlightService {
    List<Fligth> findByParameters(String departureAirportCode, String arrivalAirportCode, String departureDate);

    Fligth create(Fligth fligth);

    Fligth update(Fligth fligth);

    void delete(Integer id);

    List<Fligth> findByAirportCodeAndDepartureDate(String departureAirportCode, String departureDate);
}

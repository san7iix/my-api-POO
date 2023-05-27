package edu.unimagdalena.pw.myapi.services;

import edu.unimagdalena.pw.myapi.api.dto.Fligth;
import edu.unimagdalena.pw.myapi.repositories.JpaFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FlightServiceImpl implements FlightService{

    @Autowired
    JpaFlightRepository jpaFlightRepository;

    @Override
    public List<Fligth> findByParameters(String departureAirportCode, String arrivalAirportCode, String departureDate) {
        return null;
    }

    @Override
    public Fligth create(Fligth fligth) {
        return null;
    }

    @Override
    public Fligth update(Fligth fligth) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Fligth> findByAirportCodeAndDepartureDate(String departureAirportCode, String departureDate) {
        return null;
    }
}

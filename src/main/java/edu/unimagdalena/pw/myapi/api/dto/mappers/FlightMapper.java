package edu.unimagdalena.pw.myapi.api.dto.mappers;

import edu.unimagdalena.pw.myapi.api.dto.Fligth;
import edu.unimagdalena.pw.myapi.entidades.FlightEntity;

public class FlightMapper {


    public static Fligth toDTO(FlightEntity flightEntity) {
        Fligth fligth = new Fligth();
        fligth.setDepartureAirportCode(flightEntity.getDepartureAirportCode());
        fligth.setArrivalAirportCode(flightEntity.getArrivalAirportCode());
        fligth.setDepartureDate(flightEntity.getDepartureDate());
        fligth.setArrivalDate(flightEntity.getArrivalDate());
        fligth.setTicketPrice(flightEntity.getTicketPrice());
        return fligth;
    }

    public static FlightEntity toEntity(Fligth fligth) {
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setDepartureAirportCode(fligth.getDepartureAirportCode());
        flightEntity.setArrivalAirportCode(fligth.getArrivalAirportCode());
        flightEntity.setDepartureDate(fligth.getDepartureDate());
        flightEntity.setArrivalDate(fligth.getArrivalDate());
        flightEntity.setTicketPrice(fligth.getTicketPrice());
        return flightEntity;
    }

}

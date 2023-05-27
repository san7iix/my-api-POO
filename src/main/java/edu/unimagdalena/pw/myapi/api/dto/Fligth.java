package edu.unimagdalena.pw.myapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Fligth {
    Integer id;
    String departureDate;
    String departureAirportCode;
    String departureAirportName;
    String departureCity;
    String departureLocale;
    String arrivalDate;
    String arrivalAirportCode;
    String arrivalAirportName;
    String arrivalCity;
    String arrivalLocale;
    Integer ticketPrice;
    Integer ticketCurrency;
    Integer flightNumber;
    Integer seatCapacity;


}

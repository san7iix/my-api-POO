package edu.unimagdalena.pw.myapi.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "flights")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(nullable = false)
    String departureDate;
    @Column(nullable = false)
    String departureAirportCode;
    @Column(nullable = false)
    String departureAirportName;
    @Column(nullable = false)
    String departureCity;
    @Column(nullable = false)
    String departureLocale;
    @Column(nullable = false)
    String arrivalDate;
    @Column(nullable = false)
    String arrivalAirportCode;
    @Column(nullable = false)
    String arrivalAirportName;
    @Column(nullable = false)
    String arrivalCity;
    @Column(nullable = false)
    String arrivalLocale;
    @Column(nullable = false)
    Integer ticketPrice;
    @Column(nullable = false)
    Integer ticketCurrency;
    @Column(nullable = false)
    Integer flightNumber;
    @Column(nullable = false)
    Integer seatCapacity;
}

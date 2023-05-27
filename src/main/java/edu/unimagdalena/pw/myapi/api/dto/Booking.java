package edu.unimagdalena.pw.myapi.api.dto;

import edu.unimagdalena.pw.myapi.entidades.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    Integer id;
    BookingStatus status;
    Fligth outboundFlight;
    String paymentToken;
    Boolean checkedIn;
    UserDTO user;
    String createdAt;
    String bookingReference;

}

package edu.unimagdalena.pw.myapi.entidades;

import edu.unimagdalena.pw.myapi.api.dto.Fligth;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    BookingStatus status;

    @ManyToOne
    @JoinColumn(name = "outbound_flight_id", nullable = false, referencedColumnName = "id")
    Fligth outboundFlight;
    @Column(nullable = false)
    String paymentToken;
    @Column(columnDefinition = "boolean default false")
    Boolean checkedIn;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    String createdAt;
    String bookingReference;

}

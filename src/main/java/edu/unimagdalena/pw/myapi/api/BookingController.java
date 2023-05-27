package edu.unimagdalena.pw.myapi.api;

import edu.unimagdalena.pw.myapi.api.dto.Booking;
import edu.unimagdalena.pw.myapi.entidades.BookingStatus;
import edu.unimagdalena.pw.myapi.services.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingServiceImpl bookingService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getBooking(@PathVariable Integer id) {
        return ResponseEntity.ok(bookingService.getBooking(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> findByParams(@RequestParam(required = false) String customerName, @RequestParam(required = false) BookingStatus status) {
        return ResponseEntity.ok(bookingService.findAllByParams(status, customerName));
    }

    @PostMapping("flight/{idFlight}/user/{idUser}")
    public ResponseEntity<?> createBooking(@PathVariable Integer idFlight, @PathVariable Integer idUser, @RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBooking(idFlight, idUser, booking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Integer id) {
        return ResponseEntity.ok(bookingService.delete(id));
    }

    @GetMapping("/flight/{idFlight}")
    public ResponseEntity<?> getBookingByFlight(@PathVariable Integer idFlight) {
        return ResponseEntity.ok(bookingService.findAllByFlight(idFlight));
    }

}

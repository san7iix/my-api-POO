package edu.unimagdalena.pw.myapi.api;

import edu.unimagdalena.pw.myapi.api.dto.Fligth;
import edu.unimagdalena.pw.myapi.services.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/catalog")
public class FlightController {

    @Autowired
    FlightServiceImpl flightService;


    @GetMapping
    public ResponseEntity<?> getFlights(@RequestParam String departureAirportCode, @RequestParam String arrivalAirportCode, @RequestParam String departureDate) {
        return ResponseEntity.ok(flightService.findByParameters(departureAirportCode, arrivalAirportCode, departureDate));
    }

    @PostMapping
    public ResponseEntity<?> createFlight(@RequestBody Fligth flight) {
        return ResponseEntity.ok(flightService.create(flight));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFlight(@PathVariable Integer id, @RequestBody Fligth flight) {
        return ResponseEntity.ok(flightService.update(flight));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable Integer id) {
        flightService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{airportCode}")
    public ResponseEntity<?> getFlightsByAirportCode(@PathVariable String airportCode, @RequestParam String departureDate) {
        return ResponseEntity.ok(flightService.findByAirportCodeAndDepartureDate(airportCode, departureDate));
    }

}

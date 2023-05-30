package edu.unimagdalena.pw.myapi.services;

import edu.unimagdalena.pw.myapi.api.dto.Fligth;
import edu.unimagdalena.pw.myapi.api.dto.mappers.FlightMapper;
import edu.unimagdalena.pw.myapi.entidades.FlightEntity;
import edu.unimagdalena.pw.myapi.repositories.JpaFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FlightServiceImpl implements FlightService {

    @Autowired
    JpaFlightRepository jpaFlightRepository;

    @Override
    public List<Fligth> findByParameters(String departureAirportCode, String arrivalAirportCode, String departureDate) {
        return jpaFlightRepository.findByParameters(departureAirportCode, arrivalAirportCode, departureDate)
                .stream()
                .map(FlightMapper::toDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Fligth create(Fligth fligth) {
        Optional<FlightEntity> flightEntity = jpaFlightRepository.findById(fligth.getId());

        if (flightEntity.isPresent()) {
            throw new RuntimeException("Flight already exists");
        }

        return FlightMapper.toDTO(jpaFlightRepository.save(FlightMapper.toEntity(fligth)));
    }

    @Override
    public Fligth update(Fligth fligth) {
        Optional<FlightEntity> flightEntity = jpaFlightRepository.findById(fligth.getId());

        if (flightEntity.isEmpty()) {
            throw new RuntimeException("Flight does not exist");
        }

        return FlightMapper.toDTO(jpaFlightRepository.save(FlightMapper.toEntity(fligth)));

    }

    @Override
    public void delete(Integer id) {
        Optional<FlightEntity> flightEntity = jpaFlightRepository.findById(id);

        if (flightEntity.isEmpty()) {
            throw new RuntimeException("Flight does not exist");
        }

        jpaFlightRepository.deleteById(id);

    }

    @Override
    public List<Fligth> findByAirportCodeAndDepartureDate(String departureAirportCode, String departureDate) {
        return jpaFlightRepository.findByAirportCodeAndDepartureDate(departureAirportCode, departureDate)
                .stream()
                .map(FlightMapper::toDTO)
                .collect(java.util.stream.Collectors.toList());
    }
}

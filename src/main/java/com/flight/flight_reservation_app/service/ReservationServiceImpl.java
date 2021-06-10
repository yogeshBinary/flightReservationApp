package com.flight.flight_reservation_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.flight_reservation_app.dto.ReservationObject;
import com.flight.flight_reservation_app.entity.Flight;
import com.flight.flight_reservation_app.entity.Passenger;
import com.flight.flight_reservation_app.entity.Reservation;
import com.flight.flight_reservation_app.repository.FlightRepository;
import com.flight.flight_reservation_app.repository.PassengerRepository;
import com.flight.flight_reservation_app.repository.ReservationRepository;
import com.flight.flight_reservation_app.utilities.EmailUtil;
import com.flight.flight_reservation_app.utilities.PDFgenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Override
	public Reservation bookFlight(ReservationObject reserve) {
		Passenger passenger = new Passenger();
		passenger.setFirstName(reserve.getFirstName());
		passenger.setLastName(reserve.getLastName());
		passenger.setMiddleName(reserve.getMiddleName());
		passenger.setEmail(reserve.getEmail());
		passenger.setPhone(reserve.getPhone());
		passengerRepo.save(passenger);
		
		long id = reserve.getId();
		Optional<Flight> findById = flightRepo.findById(id);
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassengerId(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		reservationRepo.save(reservation);
		
		String filePath="C:\\Users\\ELCOT-Lenovo\\Documents\\workspace-spring-tool-suite-4-4.8.0.RELEASE\\flight_reservation_app\\tickets\\reservation";
		
		PDFgenerator pdf = new PDFgenerator();
		pdf.generatePDF(filePath+reservation.getId()+".pdf", reserve.getFirstName(), reserve.getEmail(), reserve.getPhone(), flight.getOperatingAirlines(), flight.getDateOfDeparture(), flight.getDepartureCity(), flight.getArrivalCity(),passenger.getFirstName());
		
		emailUtil.sendItinerary(passenger.getEmail(), filePath+reservation.getId()+".pdf",flight.getDepartureCity(),flight.getArrivalCity(),passenger.getFirstName());
		return reservation;
	}
}
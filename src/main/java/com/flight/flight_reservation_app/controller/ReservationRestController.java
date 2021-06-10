package com.flight.flight_reservation_app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.flight_reservation_app.dto.UpdateReservation;
import com.flight.flight_reservation_app.entity.Reservation;
import com.flight.flight_reservation_app.repository.ReservationRepository;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@RequestMapping("/getReservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}
	
	@PostMapping		
	public void updateReservation(@RequestBody UpdateReservation update) {
		long id = update.getId();
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		reservation.setCheckedIn(update.isCheckedIn());
		reservation.setNumberOfBags(update.getNumberOfBags());
		reservationRepo.save(reservation);
	}
}

package com.flight.flight_reservation_app.service;

import org.springframework.stereotype.Service;

import com.flight.flight_reservation_app.dto.ReservationObject;
import com.flight.flight_reservation_app.entity.Reservation;

@Service
public interface ReservationService {
	public Reservation bookFlight(ReservationObject reserve);
}

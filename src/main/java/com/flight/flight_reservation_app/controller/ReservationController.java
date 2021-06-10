package com.flight.flight_reservation_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight.flight_reservation_app.dto.ReservationObject;
import com.flight.flight_reservation_app.entity.Reservation;
import com.flight.flight_reservation_app.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
		
	@RequestMapping("/completeReservation")
	public String completeReservation(ReservationObject reserve,ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(reserve);
		modelMap.addAttribute("reservationId", reservation.getId());
		return "confirmReservation";
	}
}

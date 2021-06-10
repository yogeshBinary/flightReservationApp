	package com.flight.flight_reservation_app.dto;

import com.flight.flight_reservation_app.entity.AbstractEntity;

public class UpdateReservation extends AbstractEntity{
	private boolean checkedIn;
	private int numberOfBags;
	public boolean isCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	
}

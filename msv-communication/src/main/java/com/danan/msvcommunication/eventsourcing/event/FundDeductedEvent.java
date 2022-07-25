package com.danan.msvcommunication.eventsourcing.event;

public class FundDeductedEvent extends BaseEvent<String> {

	private final double deductAmount;

	public FundDeductedEvent(String id, double deductAmount) {
		super(id);
		this.deductAmount = deductAmount;
	}

	public double getDeductAmount() {
		return deductAmount;
	}

}

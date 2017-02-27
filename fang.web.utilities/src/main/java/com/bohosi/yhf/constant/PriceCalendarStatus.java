package com.bohosi.yhf.constant;

public enum PriceCalendarStatus
{
	normal(0), needpaid(1), unavailable(2), paid(3);
	
	private final int value;
	
	PriceCalendarStatus (int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }	
}

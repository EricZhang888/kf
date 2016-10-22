package com.ddkfang.constant;

public enum OrderStatus
{
	needPay(1), paid(2), overTimeCancel(3), custCancel(4), checkedIn(5), finishedNormal(6), marked(7);;
	
	private final int value;
	
	OrderStatus (int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }	
}

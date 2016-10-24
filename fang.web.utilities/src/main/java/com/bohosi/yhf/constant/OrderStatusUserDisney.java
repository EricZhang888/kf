package com.bohosi.yhf.constant;

public enum OrderStatusUserDisney
{
	needPay(1), paid(3), overTime(3), adminCancel(4), needMark(5), finishedNormal(6);
	
	private final int value;
	
	OrderStatusUserDisney (int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }	
}

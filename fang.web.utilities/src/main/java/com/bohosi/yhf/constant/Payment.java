package com.bohosi.yhf.constant;

public enum Payment
{
	none(-1), weixin(0), zhifubao(1), unionOnLinePay(3), cash(2), unionCard(4);
	
	private final int value;
	
	Payment (int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}

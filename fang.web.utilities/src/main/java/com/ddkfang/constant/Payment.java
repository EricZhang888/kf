package com.ddkfang.constant;

public enum Payment
{
	weixin(0), zhifubao(1), unionpay(3);
	
	private final int value;
	
	Payment (int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}

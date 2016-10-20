package com.ddkfang.service.orderpay.wx;

public interface IWxPayService {
	
	public String genPayToken(String code) throws Exception;
	
	public String genPayData(String orderId, String openid, int price, String ip) throws Exception;
}

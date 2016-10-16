package com.ddkfang.service.orderpay.union;

public interface IUnionPayService {
	public String genPayData(String orderId, int price, String txnType);
}

package com.bohosi.yhf.service.orderpay.union;

import com.bohosi.yhf.dao.entity.order.UnionpayRes;

public interface IUnionPayService
{

	public String genPayData(String orderId, int price, String txnType);

	public void saveUnionpayRes(UnionpayRes res);

}

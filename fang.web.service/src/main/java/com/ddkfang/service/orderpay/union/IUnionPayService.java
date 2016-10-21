package com.ddkfang.service.orderpay.union;

import com.ddkfang.dao.entity.order.UnionpayRes;

public interface IUnionPayService
{

	public String genPayData(String orderId, int price, String txnType);

	public void saveUnionpayRes(UnionpayRes res);

}

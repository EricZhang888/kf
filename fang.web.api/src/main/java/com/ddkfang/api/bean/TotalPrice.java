package com.ddkfang.api.bean;

import java.io.Serializable;
import java.util.List;

public class TotalPrice implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3040669267249456409L;

	private int total_price;

	private int total_standard_price;

	private int total_basic_price;

	private List<DayPrice> day_price_list;

	public int getTotal_price()
	{
		return total_price;
	}

	public void setTotal_price(int total_price)
	{
		this.total_price = total_price;
	}

	public int getTotal_standard_price()
	{
		return total_standard_price;
	}

	public void setTotal_standard_price(int total_standard_price)
	{
		this.total_standard_price = total_standard_price;
	}

	public int getTotal_basic_price()
	{
		return total_basic_price;
	}

	public void setTotal_basic_price(int total_basic_price)
	{
		this.total_basic_price = total_basic_price;
	}

	public List<DayPrice> getDay_price_list()
	{
		return day_price_list;
	}

	public void setDay_price_list(List<DayPrice> day_price_list)
	{
		this.day_price_list = day_price_list;
	}

	public TotalPrice()
	{

	}
}

package com.ddkfang.api.bean;

import java.io.Serializable;

public class PriceCalendar implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6888936477591005071L;

	private String date;

	private int is_preferential_price;

	private int price;

	private int is_full_booked;

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public int getIs_preferential_price()
	{
		return is_preferential_price;
	}

	public void setIs_preferential_price(int is_preferential_price)
	{
		this.is_preferential_price = is_preferential_price;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public int getIs_full_booked()
	{
		return is_full_booked;
	}

	public void setIs_full_booked(int is_full_booked)
	{
		this.is_full_booked = is_full_booked;
	}

}

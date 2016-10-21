package com.ddkfang.api.bean;

import java.io.Serializable;

public class DayPrice implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6757686349703208831L;

	private String date;

	private int preferential_price;

	private int standard_price;

	private int basic_price;

	public DayPrice()
	{

	}

	public void setDate(String d)
	{
		this.date = d;
	}

	public String getDate()
	{
		return this.date;
	}

	public void setPreferential_price(int pp)
	{
		this.preferential_price = pp;
	}

	public int getPreferential_price()
	{
		return this.preferential_price;
	}

	public void setStandard_price(int sp)
	{
		this.standard_price = sp;
	}

	public int getStandard_price()
	{
		return this.standard_price;
	}

	public void setBasic_price(int bp)
	{
		this.basic_price = bp;
	}

	public int getBasic_price()
	{
		return this.basic_price;
	}

}
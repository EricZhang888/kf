package com.ddkfang.dao.entity.rooms;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_room_price_calendar database table.
 */
@Embeddable
public class RoomPriceCalendarPK implements Serializable
{
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name = "room_date")
	private java.util.Date roomDate;

	@Column(name = "room_id", insertable = false, updatable = false)
	private String roomId;

	public RoomPriceCalendarPK()
	{
	}

	public java.util.Date getRoomDate()
	{
		return this.roomDate;
	}

	public void setRoomDate(java.util.Date roomDate)
	{
		this.roomDate = roomDate;
	}

	public String getRoomId()
	{
		return this.roomId;
	}

	public void setRoomId(String roomId)
	{
		this.roomId = roomId;
	}

	public boolean equals(Object other)
	{
		if (this == other)
		{
			return true;
		}
		if (!(other instanceof RoomPriceCalendarPK))
		{
			return false;
		}
		RoomPriceCalendarPK castOther = (RoomPriceCalendarPK) other;
		return this.roomDate.equals(castOther.roomDate) && this.roomId.equals(castOther.roomId);
	}

	public int hashCode()
	{
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.roomDate.hashCode();
		hash = hash * prime + this.roomId.hashCode();

		return hash;
	}
}
package com.ddkfang.dao.entity.rooms;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the tb_room_price_calendar database table.
 * 
 */
@Entity
@Table(name="tb_room_price_calendar")
@NamedQuery(name="RoomPriceCalendar.findAll", query="SELECT r FROM RoomPriceCalendar r")
public class RoomPriceCalendar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RoomPriceCalendarPK id;

	@Column(name="create_by")
	private String createBy;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="room_date_price")
	private int roomDatePrice;

	private int status;

	@Column(name="update_by")
	private String updateBy;

	@Column(name="update_time")
	private Timestamp updateTime;

	public RoomPriceCalendar() {
	}

	public RoomPriceCalendarPK getId() {
		return this.id;
	}

	public void setId(RoomPriceCalendarPK id) {
		this.id = id;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getRoomDatePrice() {
		return this.roomDatePrice;
	}

	public void setRoomDatePrice(int roomDatePrice) {
		this.roomDatePrice = roomDatePrice;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}
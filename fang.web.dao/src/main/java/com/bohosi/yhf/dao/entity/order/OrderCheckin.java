package com.bohosi.yhf.dao.entity.order;

import java.io.Serializable;
import javax.persistence.*;

import com.bohosi.yhf.util.priceCalendar.PriceCalendarUtil;

import java.sql.Timestamp;


/**
 * The persistent class for the tb_orders_checkin database table.
 * 
 */
@Entity
@Table(name="tb_orders_checkin")
@NamedQuery(name="OrderCheckin.findAll", query="SELECT o FROM OrderCheckin o")
public class OrderCheckin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private String orderId;

	@Column(name="create_time")
	private Timestamp createTime;

	private String note;

	@Column(name="people_ids")
	private String peopleIds;

	@Column(name="people_number")
	private int peopleNumber;

	@Column(name="room_id")
	private String roomId;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="yajin_num")
	private int yajinNum;

	@Column(name="yajin_way")
	private int yajinWay;

	public OrderCheckin() {
	}
	
	public OrderCheckin(String orderRoomId, String orderId, int peopleNumber, String peopleIds, int yajinNum, int yajinWay, String note) {
		this.roomId = orderRoomId;
		this.orderId = orderId;
		this.peopleNumber = peopleNumber;
		this.peopleIds = peopleIds;
		this.yajinNum = yajinNum;
		this.yajinWay = yajinWay;
		this.createTime = PriceCalendarUtil.getCurrentTimestamp();
		this.updateTime = PriceCalendarUtil.getCurrentTimestamp();
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPeopleIds() {
		return this.peopleIds;
	}

	public void setPeopleIds(String peopleIds) {
		this.peopleIds = peopleIds;
	}

	public int getPeopleNumber() {
		return this.peopleNumber;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public int getYajinNum() {
		return this.yajinNum;
	}

	public void setYajinNum(int yajinNum) {
		this.yajinNum = yajinNum;
	}

	public int getYajinWay() {
		return this.yajinWay;
	}

	public void setYajinWay(int yajinWay) {
		this.yajinWay = yajinWay;
	}

}
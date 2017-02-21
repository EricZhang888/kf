package com.bohosi.yhf.dao.entity.order;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tb_order_checkout database table.
 * 
 */
@Entity
@Table(name="tb_order_checkout")
@NamedQuery(name="OrderCheckout.findAll", query="SELECT o FROM OrderCheckout o")
public class OrderCheckout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private String orderId;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="creater_email")
	private String createrEmail;

	@Column(name="creater_name")
	private String createrName;

	private String note;

	@Column(name="room_id")
	private String roomId;

	@Column(name="yajin_tui_num")
	private String yajinTuiNum;

	@Column(name="yajin_tui_way")
	private String yajinTuiWay;

	public OrderCheckout() {
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

	public String getCreaterEmail() {
		return this.createrEmail;
	}

	public void setCreaterEmail(String createrEmail) {
		this.createrEmail = createrEmail;
	}

	public String getCreaterName() {
		return this.createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getYajinTuiNum() {
		return this.yajinTuiNum;
	}

	public void setYajinTuiNum(String yajinTuiNum) {
		this.yajinTuiNum = yajinTuiNum;
	}

	public String getYajinTuiWay() {
		return this.yajinTuiWay;
	}

	public void setYajinTuiWay(String yajinTuiWay) {
		this.yajinTuiWay = yajinTuiWay;
	}

}
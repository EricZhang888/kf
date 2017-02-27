package com.bohosi.yhf.dao.entity.rooms;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tb_room_holder database table.
 * 
 */
@Entity
@Table(name="tb_room_holder")
@NamedQuery(name="RoomHolder.findAll", query="SELECT r FROM RoomHolder r")
public class RoomHolder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="bank_name")
	private String bankName;

	@Column(name="bank_num")
	private String bankNum;

	@Column(name="bank_site")
	private String bankSite;

	private String email;

	@Column(name="email_checked")
	private int emailChecked;

	@Column(name="id_num")
	private String idNum;

	private String mobile;

	@Column(name="mobile_checked")
	private int mobileChecked;

	private String name;
	
	@Column(name="start_time")
	private Timestamp startTime;
	
	@Column(name="end_time")
	private Timestamp endTime;
	
	private int status;

	public RoomHolder() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNum() {
		return this.bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public String getBankSite() {
		return this.bankSite;
	}

	public void setBankSite(String bankSite) {
		this.bankSite = bankSite;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmailChecked() {
		return this.emailChecked;
	}

	public void setEmailChecked(int emailChecked) {
		this.emailChecked = emailChecked;
	}

	public String getIdNum() {
		return this.idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getMobileChecked() {
		return this.mobileChecked;
	}

	public void setMobileChecked(int mobileChecked) {
		this.mobileChecked = mobileChecked;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
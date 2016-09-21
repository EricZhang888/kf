package com.ddkfang.dao.entity.rooms;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the tb_room database table.
 * 
 */
@Entity
@Table(name="tb_room")
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(name="room_accessory")
	private String roomAccessory;

	private String room_accessoryComment;

	@Column(name="room_address")
	private String roomAddress;

	@Column(name="room_city")
	private String roomCity;

	@Column(name="room_comments")
	private int roomComments;

	private String room_coverImg;

	@Column(name="room_create_time")
	private Timestamp roomCreateTime;

	@Column(name="room_imgs")
	private String roomImgs;

	@Column(name="room_likes")
	private int roomLikes;

	@Column(name="room_name")
	private String roomName;

	@Column(name="room_price")
	private int roomPrice;

	@Column(name="room_rate")
	private float roomRate;

	private String room_salePoint;

	@Column(name="room_site")
	private String roomSite;

	@Column(name="room_update_time")
	private Timestamp roomUpdateTime;

	@Column(name="room_video")
	private String roomVideo;

	public Room() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomAccessory() {
		return this.roomAccessory;
	}

	public void setRoomAccessory(String roomAccessory) {
		this.roomAccessory = roomAccessory;
	}

	public String getRoom_accessoryComment() {
		return this.room_accessoryComment;
	}

	public void setRoom_accessoryComment(String room_accessoryComment) {
		this.room_accessoryComment = room_accessoryComment;
	}

	public String getRoomAddress() {
		return this.roomAddress;
	}

	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}

	public String getRoomCity() {
		return this.roomCity;
	}

	public void setRoomCity(String roomCity) {
		this.roomCity = roomCity;
	}

	public int getRoomComments() {
		return this.roomComments;
	}

	public void setRoomComments(int roomComments) {
		this.roomComments = roomComments;
	}

	public String getRoom_coverImg() {
		return this.room_coverImg;
	}

	public void setRoom_coverImg(String room_coverImg) {
		this.room_coverImg = room_coverImg;
	}

	public Timestamp getRoomCreateTime() {
		return this.roomCreateTime;
	}

	public void setRoomCreateTime(Timestamp roomCreateTime) {
		this.roomCreateTime = roomCreateTime;
	}

	public String getRoomImgs() {
		return this.roomImgs;
	}

	public void setRoomImgs(String roomImgs) {
		this.roomImgs = roomImgs;
	}

	public int getRoomLikes() {
		return this.roomLikes;
	}

	public void setRoomLikes(int roomLikes) {
		this.roomLikes = roomLikes;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomPrice() {
		return this.roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public float getRoomRate() {
		return this.roomRate;
	}

	public void setRoomRate(float roomRate) {
		this.roomRate = roomRate;
	}

	public String getRoom_salePoint() {
		return this.room_salePoint;
	}

	public void setRoom_salePoint(String room_salePoint) {
		this.room_salePoint = room_salePoint;
	}

	public String getRoomSite() {
		return this.roomSite;
	}

	public void setRoomSite(String roomSite) {
		this.roomSite = roomSite;
	}

	public Timestamp getRoomUpdateTime() {
		return this.roomUpdateTime;
	}

	public void setRoomUpdateTime(Timestamp roomUpdateTime) {
		this.roomUpdateTime = roomUpdateTime;
	}

	public String getRoomVideo() {
		return this.roomVideo;
	}

	public void setRoomVideo(String roomVideo) {
		this.roomVideo = roomVideo;
	}

}
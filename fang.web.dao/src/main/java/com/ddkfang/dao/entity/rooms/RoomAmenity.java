package com.ddkfang.dao.entity.rooms;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_room_amenities database table.
 * 
 */
@Entity
@Table(name="tb_room_amenities")
@NamedQuery(name="RoomAmenity.findAll", query="SELECT r FROM RoomAmenity r")
public class RoomAmenity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="amenities_id")
	private int amenitiesId;

	@Column(name="amenity_name")
	private String amenityName;

	private String icon;

//	//bi-directional many-to-many association to Room
//	@ManyToMany(mappedBy="tbRoomAmenities")
//	private List<Room> tbRooms;

	public RoomAmenity() {
	}

	public int getAmenitiesId() {
		return this.amenitiesId;
	}

	public void setAmenitiesId(int amenitiesId) {
		this.amenitiesId = amenitiesId;
	}

	public String getAmenityName() {
		return this.amenityName;
	}

	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

//	public List<Room> getTbRooms() {
//		return this.tbRooms;
//	}
//
//	public void setTbRooms(List<Room> tbRooms) {
//		this.tbRooms = tbRooms;
//	}

}
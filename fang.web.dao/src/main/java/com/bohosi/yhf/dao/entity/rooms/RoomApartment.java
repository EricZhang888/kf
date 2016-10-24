package com.bohosi.yhf.dao.entity.rooms;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_room_apartment database table.
 */
@Entity
@Table(name = "tb_room_apartment")
@NamedQuery(name = "RoomApartment.findAll", query = "SELECT r FROM RoomApartment r")
public class RoomApartment implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "apartment_id")
	private int apartmentId;

	@Lob
	@Column(name = "apartment_desc")
	private String apartmentDesc;

	@Column(name = "apartment_name")
	private String apartmentName;

	@Lob
	@Column(name = "apartment_tips")
	private String apartmentTips;

	//	//bi-directional many-to-one association to Room
	//	@OneToMany(mappedBy="roomApartment")
	//	private List<Room> tbRooms;

	public RoomApartment()
	{
	}

	public int getApartmentId()
	{
		return this.apartmentId;
	}

	public void setApartmentId(int apartmentId)
	{
		this.apartmentId = apartmentId;
	}

	public String getApartmentDesc()
	{
		return this.apartmentDesc;
	}

	public void setApartmentDesc(String apartmentDesc)
	{
		this.apartmentDesc = apartmentDesc;
	}

	public String getApartmentName()
	{
		return this.apartmentName;
	}

	public void setApartmentName(String apartmentName)
	{
		this.apartmentName = apartmentName;
	}

	public String getApartmentTips()
	{
		return this.apartmentTips;
	}

	public void setApartmentTips(String apartmentTips)
	{
		this.apartmentTips = apartmentTips;
	}

	//	public List<Room> getTbRooms() {
	//		return this.tbRooms;
	//	}
	//
	//	public void setTbRooms(List<Room> tbRooms) {
	//		this.tbRooms = tbRooms;
	//	}

	//	public Room addTbRoom(Room tbRoom) {
	//		getTbRooms().add(tbRoom);
	//		tbRoom.setRoomApartment(this);
	//
	//		return tbRoom;
	//	}
	//
	//	public Room removeTbRoom(Room tbRoom) {
	//		getTbRooms().remove(tbRoom);
	//		tbRoom.setRoomApartment(null);
	//
	//		return tbRoom;
	//	}

}
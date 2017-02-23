package com.bohosi.yhf.dao.entity.rooms;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the tb_room database table.
 */
@Entity
@Table(name = "tb_room")
@NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
public class Room implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "room_id")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String roomId;

	@Column(name = "room_number")
	private String roomNumber;
	
	public String getRoomNumber()
	{
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}

	public String getRoomBuilding()
	{
		return roomBuilding;
	}

	public void setRoomBuilding(String roomBuilding)
	{
		this.roomBuilding = roomBuilding;
	}

	public String getRoomFloor()
	{
		return roomFloor;
	}

	public void setRoomFloor(String roomFloor)
	{
		this.roomFloor = roomFloor;
	}

	@Column(name = "room_building")
	private String roomBuilding;
	
	@Column(name = "room_floor")
	private String roomFloor;
	
	@Column(name = "room_address")
	private String roomAddress;

	@Column(name = "room_balcony_count")
	private int roomBalconyCount;

	@Column(name = "room_basic_price")
	private int roomBasicPrice;

	@Column(name = "room_bathroom_count")
	private int roomBathroomCount;

	@Column(name = "room_bed_count")
	private String roomBedCount;

	@Column(name = "room_bedroom_count")
	private int roomBedroomCount;

	@Column(name = "room_city_id")
	private String roomCityId;

	@Column(name = "room_city_name")
	private String roomCityName;

	@Column(name = "room_create_time")
	private Timestamp roomCreateTime;

	@Column(name = "room_enters_number")
	private int roomEntersNumber;

	@Lob
	@Column(name = "room_images")
	private String roomImages;

	@Column(name = "room_kitchen_count")
	private int roomKitchenCount;

	@Column(name = "room_latitude")
	private String roomLatitude;

	@Column(name = "room_likes")
	private int roomLikes;

	@Column(name = "room_longitude")
	private String roomLongitude;

	@Column(name = "room_map_type")
	private int roomMapType;

	@Column(name = "room_max_area")
	private int roomMaxArea;

	@Column(name = "room_min_area")
	private int roomMinArea;

	@Column(name = "room_name")
	private String roomName;

	@Column(name = "room_price")
	private int roomPrice;

	@Column(name = "room_score")
	private String roomScore;

	@Column(name = "room_sitting_count")
	private int roomSittingCount;

	@Column(name = "room_type_desc")
	private String roomTypeDesc;

	@Column(name = "room_type_id")
	private String roomTypeId;

	@Column(name = "room_type_mini_desc")
	private String roomTypeMiniDesc;

	@Column(name = "room_type_tags")
	private String roomTypeTags;

	@Column(name = "room_type_tips")
	private String roomTypeTips;

	@Column(name = "room_update_time")
	private Timestamp roomUpdateTime;

	//bi-directional many-to-one association to TbRoomApartment
	@ManyToOne
	@JoinColumn(name = "room_apartment_id")
	private RoomApartment roomApartment;
	
	//bi-directional many-to-many association to TbRoomAmenity
	@JoinTable(name = "tb_room_holder_mapping", joinColumns = {@JoinColumn(name = "room_id")}, inverseJoinColumns = {
	@JoinColumn(name = "id")})
	@ManyToOne
	private RoomHolder tbRoomHolder;

	//bi-directional many-to-many association to TbRoomAmenity
	@JoinTable(name = "tb_room_amenities_mapping", joinColumns = {@JoinColumn(name = "room_id")}, inverseJoinColumns = {
	@JoinColumn(name = "amenities_id")})
	@ManyToMany(fetch = FetchType.EAGER)
	private List<RoomAmenity> tbRoomAmenities;

	public Room()
	{
	}

	public String getRoomId()
	{
		return this.roomId;
	}

	public void setRoomId(String roomId)
	{
		this.roomId = roomId;
	}

	public String getRoomAddress()
	{
		return this.roomAddress;
	}

	public void setRoomAddress(String roomAddress)
	{
		this.roomAddress = roomAddress;
	}

	public int getRoomBalconyCount()
	{
		return this.roomBalconyCount;
	}

	public void setRoomBalconyCount(int roomBalconyCount)
	{
		this.roomBalconyCount = roomBalconyCount;
	}

	public int getRoomBasicPrice()
	{
		return this.roomBasicPrice;
	}

	public void setRoomBasicPrice(int roomBasicPrice)
	{
		this.roomBasicPrice = roomBasicPrice;
	}

	public int getRoomBathroomCount()
	{
		return this.roomBathroomCount;
	}

	public void setRoomBathroomCount(int roomBathroomCount)
	{
		this.roomBathroomCount = roomBathroomCount;
	}

	public String getRoomBedCount()
	{
		return this.roomBedCount;
	}

	public void setRoomBedCount(String roomBedCount)
	{
		this.roomBedCount = roomBedCount;
	}

	public int getRoomBedroomCount()
	{
		return this.roomBedroomCount;
	}

	public void setRoomBedroomCount(int roomBedroomCount)
	{
		this.roomBedroomCount = roomBedroomCount;
	}

	public String getRoomCityId()
	{
		return this.roomCityId;
	}

	public void setRoomCityId(String roomCityId)
	{
		this.roomCityId = roomCityId;
	}

	public String getRoomCityName()
	{
		return this.roomCityName;
	}

	public void setRoomCityName(String roomCityName)
	{
		this.roomCityName = roomCityName;
	}

	public Timestamp getRoomCreateTime()
	{
		return this.roomCreateTime;
	}

	public void setRoomCreateTime(Timestamp roomCreateTime)
	{
		this.roomCreateTime = roomCreateTime;
	}

	public int getRoomEntersNumber()
	{
		return this.roomEntersNumber;
	}

	public void setRoomEntersNumber(int roomEntersNumber)
	{
		this.roomEntersNumber = roomEntersNumber;
	}

	public String getRoomImages()
	{
		return this.roomImages;
	}

	public void setRoomImages(String roomImages)
	{
		this.roomImages = roomImages;
	}

	public int getRoomKitchenCount()
	{
		return this.roomKitchenCount;
	}

	public void setRoomKitchenCount(int roomKitchenCount)
	{
		this.roomKitchenCount = roomKitchenCount;
	}

	public String getRoomLatitude()
	{
		return this.roomLatitude;
	}

	public void setRoomLatitude(String roomLatitude)
	{
		this.roomLatitude = roomLatitude;
	}

	public int getRoomLikes()
	{
		return this.roomLikes;
	}

	public void setRoomLikes(int roomLikes)
	{
		this.roomLikes = roomLikes;
	}

	public String getRoomLongitude()
	{
		return this.roomLongitude;
	}

	public void setRoomLongitude(String roomLongitude)
	{
		this.roomLongitude = roomLongitude;
	}

	public int getRoomMapType()
	{
		return this.roomMapType;
	}

	public void setRoomMapType(int roomMapType)
	{
		this.roomMapType = roomMapType;
	}

	public int getRoomMaxArea()
	{
		return this.roomMaxArea;
	}

	public void setRoomMaxArea(int roomMaxArea)
	{
		this.roomMaxArea = roomMaxArea;
	}

	public int getRoomMinArea()
	{
		return this.roomMinArea;
	}

	public void setRoomMinArea(int roomMinArea)
	{
		this.roomMinArea = roomMinArea;
	}

	public String getRoomName()
	{
		return this.roomName;
	}

	public void setRoomName(String roomName)
	{
		this.roomName = roomName;
	}

	public int getRoomPrice()
	{
		return this.roomPrice;
	}

	public void setRoomPrice(int roomPrice)
	{
		this.roomPrice = roomPrice;
	}

	public String getRoomScore()
	{
		return this.roomScore;
	}

	public void setRoomScore(String roomScore)
	{
		this.roomScore = roomScore;
	}

	public int getRoomSittingCount()
	{
		return this.roomSittingCount;
	}

	public void setRoomSittingCount(int roomSittingCount)
	{
		this.roomSittingCount = roomSittingCount;
	}

	public String getRoomTypeDesc()
	{
		return this.roomTypeDesc;
	}

	public void setRoomTypeDesc(String roomTypeDesc)
	{
		this.roomTypeDesc = roomTypeDesc;
	}

	public String getRoomTypeId()
	{
		return this.roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId)
	{
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeMiniDesc()
	{
		return this.roomTypeMiniDesc;
	}

	public void setRoomTypeMiniDesc(String roomTypeMiniDesc)
	{
		this.roomTypeMiniDesc = roomTypeMiniDesc;
	}

	public String getRoomTypeTags()
	{
		return this.roomTypeTags;
	}

	public void setRoomTypeTags(String roomTypeTags)
	{
		this.roomTypeTags = roomTypeTags;
	}

	public String getRoomTypeTips()
	{
		return this.roomTypeTips;
	}

	public void setRoomTypeTips(String roomTypeTips)
	{
		this.roomTypeTips = roomTypeTips;
	}

	public Timestamp getRoomUpdateTime()
	{
		return this.roomUpdateTime;
	}

	public void setRoomUpdateTime(Timestamp roomUpdateTime)
	{
		this.roomUpdateTime = roomUpdateTime;
	}

	public RoomApartment getRoomApartment()
	{
		return this.roomApartment;
	}

	public void setRoomApartment(RoomApartment roomApartment)
	{
		this.roomApartment = roomApartment;
	}

	public List<RoomAmenity> getTbRoomAmenities()
	{
		return this.tbRoomAmenities;
	}

	public void setTbRoomAmenities(List<RoomAmenity> tbRoomAmenities)
	{
		this.tbRoomAmenities = tbRoomAmenities;
	}

	public RoomHolder getTbRoomHolder() {
		return tbRoomHolder;
	}

	public void setTbRoomHolder(RoomHolder tbRoomHolder) {
		this.tbRoomHolder = tbRoomHolder;
	}
}
package com.bohosi.yhf.dao.entity.order;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.bohosi.yhf.dao.entity.rooms.Room;

/**
 * The persistent class for the tb_orders database table.
 */
@Entity
@Table(name = "tb_orders")
@NamedQuery(name = "OrderAdmin.findAll", query = "SELECT o FROM OrderAdmin o")
public class OrderAdmin implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(name = "apartment_id")
	private int apartmentId;

	@Column(name = "apartment_name")
	private String apartmentName;

	@Column(name = "booker_id")
	private String bookerId;

	private int channel;

	@Column(name = "create_time")
	private Timestamp createTime;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_end")
	private Date dateEnd;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_start")
	private Date dateStart;

	private int discount;

	@Column(name = "discount_id")
	private String discountId;

	@Column(name = "last_pay_time")
	private Timestamp lastPayTime;

	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "pay_time")
	private Timestamp payTime;

	private int payment;

	@Column(name = "payment_callback")
	private String paymentCallback;

	private int price;

	@Column(name = "room_bathroom_count")
	private int roomBathroomCount;

	@Column(name = "room_bedroom_count")
	private int roomBedroomCount;

	@Column(name = "room_id")
	private String roomId;

	@Column(name = "room_img")
	private String roomImg;

	@Column(name = "room_kitchen_count")
	private int roomKitchenCount;

	@Column(name = "room_name")
	private String roomName;

	@Column(name = "room_sitting_count")
	private int roomSittingCount;

	@ManyToOne(cascade = { CascadeType.ALL } )
	@JoinColumn(name="room_id",insertable=false, updatable=false, referencedColumnName="room_id")
	private Room room;
	
	private int status;

	@Column(name = "user_display_status")
	private int userDisplayStatus;

	public int getUserDisplayStatus()
	{
		return userDisplayStatus;
	}

	public void setUserDisplayStatus(int userDisplayStatus)
	{
		this.userDisplayStatus = userDisplayStatus;
	}

	@Column(name = "total_price")
	private int totalPrice;

	@Column(name = "update_time")
	private Timestamp updateTime;

	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "contact_phone")
	private String contactPhone;

	public String getContactName()
	{
		return contactName;
	}

	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}

	public String getContactPhone()
	{
		return contactPhone;
	}

	public void setContactPhone(String contactPhone)
	{
		this.contactPhone = contactPhone;
	}

	public OrderAdmin()
	{
	}

	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getApartmentId()
	{
		return this.apartmentId;
	}

	public void setApartmentId(int apartmentId)
	{
		this.apartmentId = apartmentId;
	}

	public String getApartmentName()
	{
		return this.apartmentName;
	}

	public void setApartmentName(String apartmentName)
	{
		this.apartmentName = apartmentName;
	}

	public String getBookerId()
	{
		return this.bookerId;
	}

	public void setBookerId(String bookerId)
	{
		this.bookerId = bookerId;
	}

	public int getChannel()
	{
		return this.channel;
	}

	public void setChannel(int channel)
	{
		this.channel = channel;
	}

	public Timestamp getCreateTime()
	{
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	public Date getDateEnd()
	{
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd)
	{
		this.dateEnd = dateEnd;
	}

	public Date getDateStart()
	{
		return this.dateStart;
	}

	public Room getRoom()
	{
		return room;
	}

	public void setRoom(Room room)
	{
		this.room = room;
	}

	public void setDateStart(Date dateStart)
	{
		this.dateStart = dateStart;
	}

	public int getDiscount()
	{
		return this.discount;
	}

	public void setDiscount(int discount)
	{
		this.discount = discount;
	}

	public String getDiscountId()
	{
		return this.discountId;
	}

	public void setDiscountId(String discountId)
	{
		this.discountId = discountId;
	}

	public Timestamp getLastPayTime()
	{
		return this.lastPayTime;
	}

	public void setLastPayTime(Timestamp lastPayTime)
	{
		this.lastPayTime = lastPayTime;
	}

	public String getOrderNumber()
	{
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public Timestamp getPayTime()
	{
		return this.payTime;
	}

	public void setPayTime(Timestamp payTime)
	{
		this.payTime = payTime;
	}

	public int getPayment()
	{
		return this.payment;
	}

	public void setPayment(int payment)
	{
		this.payment = payment;
	}

	public String getPaymentCallback()
	{
		return this.paymentCallback;
	}

	public void setPaymentCallback(String paymentCallback)
	{
		this.paymentCallback = paymentCallback;
	}

	public int getPrice()
	{
		return this.price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public int getRoomBathroomCount()
	{
		return this.roomBathroomCount;
	}

	public void setRoomBathroomCount(int roomBathroomCount)
	{
		this.roomBathroomCount = roomBathroomCount;
	}

	public int getRoomBedroomCount()
	{
		return this.roomBedroomCount;
	}

	public void setRoomBedroomCount(int roomBedroomCount)
	{
		this.roomBedroomCount = roomBedroomCount;
	}

	public String getRoomId()
	{
		return this.roomId;
	}

	public void setRoomId(String roomId)
	{
		this.roomId = roomId;
	}

	public String getRoomImg()
	{
		return this.roomImg;
	}

	public void setRoomImg(String roomImg)
	{
		this.roomImg = roomImg;
	}

	public int getRoomKitchenCount()
	{
		return this.roomKitchenCount;
	}

	public void setRoomKitchenCount(int roomKitchenCount)
	{
		this.roomKitchenCount = roomKitchenCount;
	}

	public String getRoomName()
	{
		return this.roomName;
	}

	public void setRoomName(String roomName)
	{
		this.roomName = roomName;
	}

	public int getRoomSittingCount()
	{
		return this.roomSittingCount;
	}

	public void setRoomSittingCount(int roomSittingCount)
	{
		this.roomSittingCount = roomSittingCount;
	}

	public int getStatus()
	{
		return this.status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public int getTotalPrice()
	{
		return this.totalPrice;
	}

	public void setTotalPrice(int totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public Timestamp getUpdateTime()
	{
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime)
	{
		this.updateTime = updateTime;
	}

	@Override
	public String toString()
	{
		return "orderId:"+id + " roomId:" + roomId + " bookerId:"+bookerId + " checkIn:"+dateStart + " checkOut:"+ dateEnd;
	}

}
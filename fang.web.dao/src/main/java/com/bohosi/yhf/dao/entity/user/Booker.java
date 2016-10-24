package com.bohosi.yhf.dao.entity.user;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;

/**
 * The persistent class for the tb_booker database table.
 */
@Entity
@Table(name = "tb_booker")
@NamedQuery(name = "Booker.findAll", query = "SELECT b FROM Booker b")
public class Booker implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(name = "booker_email")
	private String bookerEmail;

	@Column(name = "booker_icon")
	private String bookerIcon;

	@Column(name = "booker_mobile")
	private String bookerMobile;

	@Column(name = "booker_name")
	private String bookerName;

	@Column(name = "booker_pwd")
	private String bookerPwd;

	@Column(name = "booker_sex")
	private String bookerSex;

	@Column(name = "booker_wechat")
	private String bookerWechat;

	@Column(name = "create_time")
	private Timestamp createTime;

	@Column(name = "update_time")
	private Timestamp updateTime;

	public Booker()
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

	public String getBookerEmail()
	{
		return this.bookerEmail;
	}

	public void setBookerEmail(String bookerEmail)
	{
		this.bookerEmail = bookerEmail;
	}

	public String getBookerIcon()
	{
		return this.bookerIcon;
	}

	public void setBookerIcon(String bookerIcon)
	{
		this.bookerIcon = bookerIcon;
	}

	public String getBookerMobile()
	{
		return this.bookerMobile;
	}

	public void setBookerMobile(String bookerMobile)
	{
		this.bookerMobile = bookerMobile;
	}

	public String getBookerName()
	{
		return this.bookerName;
	}

	public void setBookerName(String bookerName)
	{
		this.bookerName = bookerName;
	}

	public String getBookerPwd()
	{
		return this.bookerPwd;
	}

	public void setBookerPwd(String bookerPwd)
	{
		this.bookerPwd = bookerPwd;
	}

	public String getBookerSex()
	{
		return this.bookerSex;
	}

	public void setBookerSex(String bookerSex)
	{
		this.bookerSex = bookerSex;
	}

	public String getBookerWechat()
	{
		return this.bookerWechat;
	}

	public void setBookerWechat(String bookerWechat)
	{
		this.bookerWechat = bookerWechat;
	}

	public Timestamp getCreateTime()
	{
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime()
	{
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime)
	{
		this.updateTime = updateTime;
	}

}
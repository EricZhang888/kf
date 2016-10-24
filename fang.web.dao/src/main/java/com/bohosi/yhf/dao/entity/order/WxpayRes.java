package com.bohosi.yhf.dao.entity.order;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the tb_wxpay_res database table.
 */
@Entity
@Table(name = "tb_wxpay_res")
@NamedQuery(name = "WxpayRes.findAll", query = "SELECT w FROM WxpayRes w")
public class WxpayRes implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String appid;

	@Column(name = "bank_type")
	private String bankType;

	@Column(name = "cash_fee")
	private int cashFee;

	@Column(name = "err_code")
	private String errCode;

	@Column(name = "err_code_des")
	private String errCodeDes;

	@Column(name = "is_subscribe")
	private String isSubscribe;

	@Column(name = "mch_id")
	private String mchId;

	@Column(name = "nonce_str")
	private String nonceStr;

	private String openid;

	@Column(name = "out_trade_no")
	private String outTradeNo;

	@Column(name = "result_code")
	private String resultCode;

	private String sign;

	@Column(name = "time_end")
	private String timeEnd;

	@Column(name = "total_fee")
	private int totalFee;

	@Column(name = "trade_type")
	private String tradeType;

	@Column(name = "transaction_id")
	private String transactionId;

	public WxpayRes()
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

	public String getAppid()
	{
		return this.appid;
	}

	public void setAppid(String appid)
	{
		this.appid = appid;
	}

	public String getBankType()
	{
		return this.bankType;
	}

	public void setBankType(String bankType)
	{
		this.bankType = bankType;
	}

	public int getCashFee()
	{
		return this.cashFee;
	}

	public void setCashFee(int cashFee)
	{
		this.cashFee = cashFee;
	}

	public String getErrCode()
	{
		return this.errCode;
	}

	public void setErrCode(String errCode)
	{
		this.errCode = errCode;
	}

	public String getErrCodeDes()
	{
		return this.errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes)
	{
		this.errCodeDes = errCodeDes;
	}

	public String getIsSubscribe()
	{
		return this.isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe)
	{
		this.isSubscribe = isSubscribe;
	}

	public String getMchId()
	{
		return this.mchId;
	}

	public void setMchId(String mchId)
	{
		this.mchId = mchId;
	}

	public String getNonceStr()
	{
		return this.nonceStr;
	}

	public void setNonceStr(String nonceStr)
	{
		this.nonceStr = nonceStr;
	}

	public String getOpenid()
	{
		return this.openid;
	}

	public void setOpenid(String openid)
	{
		this.openid = openid;
	}

	public String getOutTradeNo()
	{
		return this.outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo)
	{
		this.outTradeNo = outTradeNo;
	}

	public String getResultCode()
	{
		return this.resultCode;
	}

	public void setResultCode(String resultCode)
	{
		this.resultCode = resultCode;
	}

	public String getSign()
	{
		return this.sign;
	}

	public void setSign(String sign)
	{
		this.sign = sign;
	}

	public String getTimeEnd()
	{
		return this.timeEnd;
	}

	public void setTimeEnd(String timeEnd)
	{
		this.timeEnd = timeEnd;
	}

	public int getTotalFee()
	{
		return this.totalFee;
	}

	public void setTotalFee(int totalFee)
	{
		this.totalFee = totalFee;
	}

	public String getTradeType()
	{
		return this.tradeType;
	}

	public void setTradeType(String tradeType)
	{
		this.tradeType = tradeType;
	}

	public String getTransactionId()
	{
		return this.transactionId;
	}

	public void setTransactionId(String transactionId)
	{
		this.transactionId = transactionId;
	}

}
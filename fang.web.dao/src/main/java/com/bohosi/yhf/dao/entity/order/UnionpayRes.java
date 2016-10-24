package com.bohosi.yhf.dao.entity.order;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the tb_unionpay_res database table.
 */
@Entity
@Table(name = "tb_unionpay_res")
@NamedQuery(name = "UnionpayRes.findAll", query = "SELECT u FROM UnionpayRes u")
public class UnionpayRes implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(name = "acc_no")
	private String accNo;

	@Column(name = "cert_id")
	private String certId;

	@Column(name = "order_id")
	private String orderId;

	@Column(name = "query_id")
	private String queryId;

	@Column(name = "resp_code")
	private String respCode;

	@Column(name = "resp_msg")
	private String respMsg;

	@Column(name = "settle_currency_code")
	private String settleCurrencyCode;

	@Column(name = "settle_date")
	private String settleDate;

	@Column(name = "trace_no")
	private String traceNo;

	@Column(name = "txn_sub_type")
	private String txnSubType;

	@Column(name = "txn_time")
	private String txnTime;

	@Column(name = "txn_type")
	private String txnType;

	public UnionpayRes()
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

	public String getAccNo()
	{
		return this.accNo;
	}

	public void setAccNo(String accNo)
	{
		this.accNo = accNo;
	}

	public String getCertId()
	{
		return this.certId;
	}

	public void setCertId(String certId)
	{
		this.certId = certId;
	}

	public String getOrderId()
	{
		return this.orderId;
	}

	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

	public String getQueryId()
	{
		return this.queryId;
	}

	public void setQueryId(String queryId)
	{
		this.queryId = queryId;
	}

	public String getRespCode()
	{
		return this.respCode;
	}

	public void setRespCode(String respCode)
	{
		this.respCode = respCode;
	}

	public String getRespMsg()
	{
		return this.respMsg;
	}

	public void setRespMsg(String respMsg)
	{
		this.respMsg = respMsg;
	}

	public String getSettleCurrencyCode()
	{
		return this.settleCurrencyCode;
	}

	public void setSettleCurrencyCode(String settleCurrencyCode)
	{
		this.settleCurrencyCode = settleCurrencyCode;
	}

	public String getSettleDate()
	{
		return this.settleDate;
	}

	public void setSettleDate(String settleDate)
	{
		this.settleDate = settleDate;
	}

	public String getTraceNo()
	{
		return this.traceNo;
	}

	public void setTraceNo(String traceNo)
	{
		this.traceNo = traceNo;
	}

	public String getTxnSubType()
	{
		return this.txnSubType;
	}

	public void setTxnSubType(String txnSubType)
	{
		this.txnSubType = txnSubType;
	}

	public String getTxnTime()
	{
		return this.txnTime;
	}

	public void setTxnTime(String txnTime)
	{
		this.txnTime = txnTime;
	}

	public String getTxnType()
	{
		return this.txnType;
	}

	public void setTxnType(String txnType)
	{
		this.txnType = txnType;
	}

}
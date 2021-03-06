package model;
// default package
// Generated Feb 25, 2015 11:58:03 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * Refund generated by hbm2java
 */
public class Refund implements java.io.Serializable {

	private Integer refundId;
	private Short customerId;
	private BigDecimal amount;

	public Refund() {
	}

	public Refund(Short customerId, BigDecimal amount) {
		this.customerId = customerId;
		this.amount = amount;
	}

	public Integer getRefundId() {
		return this.refundId;
	}

	public void setRefundId(Integer refundId) {
		this.refundId = refundId;
	}

	public Short getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Short customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}

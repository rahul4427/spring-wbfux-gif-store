package com.rk.gifstore.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "giff_purchse_txn")
public class GiffPurchaseEntity {

	@Id
	@Column(value = "purchse_id")
	private Long purchaseId;
	
	@Column(value = "usr_id")
	private long userId;

	@Column(value = "giff_id")
	private long giffId;

	public GiffPurchaseEntity(long userId, long giffId) {
		super();
		this.userId = userId;
		this.giffId = giffId;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getGiffId() {
		return giffId;
	}

	public void setGiffId(long giffId) {
		this.giffId = giffId;
	}

}

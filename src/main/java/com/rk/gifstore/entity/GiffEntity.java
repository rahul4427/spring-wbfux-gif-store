package com.rk.gifstore.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "giff_mst")
public class GiffEntity {

	@Id
	private Long giffId;

	private byte[] giff;

	private long ownerId;
	
	@Column(value = "price_usd")
	private long price;

	public GiffEntity(byte[] giff, long ownerId, long price) {
		super();
		this.giff = giff;
		this.ownerId = ownerId;
		this.price = price;
	}

	public long getPrice() {
		return price;
	}



	public void setPrice(long price) {
		this.price = price;
	}



	public Long getGiffId() {
		return giffId;
	}

	public void setGiffId(Long giffId) {
		this.giffId = giffId;
	}

	public byte[] getGiff() {
		return giff;
	}

	public void setGiff(byte[] giff) {
		this.giff = giff;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

}

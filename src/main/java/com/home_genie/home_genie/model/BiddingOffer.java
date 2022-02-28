package com.home_genie.home_genie.model;

import java.io.Serializable;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class BiddingOffer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String ListingId;

	private String BidderUserId;

	private String BiddingOffer;

	public String getListingId() {
		return ListingId;
	}

	public void setListingId(String listingId) {
		this.ListingId = listingId;
	}

	public String getBidderUserId() {
		return BidderUserId;
	}

	public void setBidderUserId(String bidderUserId) {
		this.BidderUserId = bidderUserId;
	}

	public String getBiddingOffer() {
		return BiddingOffer;
	}

	public void setBiddingOffer(String bindingOffer) {
		this.BiddingOffer = bindingOffer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

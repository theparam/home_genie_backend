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

	private String listingId;

	private String bidderUserId;

	private String bidUserName;

	private String bidUserEmail;

	private String bidUserPhone;

	private String bidUserBio;

	private String biddingOffer;

	private String isOfferAccepted;

	public String getListingId() {
		return listingId;
	}

	public void setListingId(String listingId) {
		this.listingId = listingId;
	}

	public String getBidderUserId() {
		return bidderUserId;
	}

	public void setBidderUserId(String bidderUserId) {
		this.bidderUserId = bidderUserId;
	}

	public String getBidUserName() {
		return bidUserName;
	}

	public void setBidUserName(String bidUserName) {
		this.bidUserName = bidUserName;
	}

	public String getBidUserEmail() {
		return bidUserEmail;
	}

	public void setBidUserEmail(String bidUserEmail) {
		this.bidUserEmail = bidUserEmail;
	}

	public String getBidUserPhone() {
		return bidUserPhone;
	}

	public void setBidUserPhone(String bidUserPhone) {
		this.bidUserPhone = bidUserPhone;
	}

	public String getBidUserBio() {
		return bidUserBio;
	}

	public void setBidUserBio(String bidUserBio) {
		this.bidUserBio = bidUserBio;
	}

	public String getBiddingOffer() {
		return biddingOffer;
	}

	public void setBiddingOffer(String bindingOffer) {
		this.biddingOffer = bindingOffer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String isOfferAccepted() {
		return isOfferAccepted;
	}

	public void setOfferAccepted(String isOfferAccepted) {
		this.isOfferAccepted = isOfferAccepted;
	}

}

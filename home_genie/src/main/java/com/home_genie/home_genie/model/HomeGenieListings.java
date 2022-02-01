package com.home_genie.home_genie.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class HomeGenieListings implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String title;
	
	private String description;
	
	private String category;
	
	private String condition;
	
	private String[] images;
	
	private String price;
	
	private String ownerUserId;
	
	private String bidderUserId;
	
	private Boolean isOfferAccepted;
	
	private String biddingOffer;
	
	private Boolean isNotificationRead;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getBiddingOffer()
	{
		return biddingOffer;
	}
	
	public void setBiddingOffer(String biddingOffer)
	{
		this.biddingOffer= biddingOffer;
	}
	
	public String[] getImages()
	{
		return images;
	}
	
	public void setImages(String[] images)
	{
		this.images= images;
	}
	
	public Boolean getIsOfferAccepted()
	{
		return isOfferAccepted;
	}
	
	public void setIsOfferAccepted(Boolean isOfferAccepted)
	{
		this.isOfferAccepted= isOfferAccepted;
	}
	
	public Boolean getIsNotificationRead()
	{
		return isNotificationRead;
	}
	
	public void setIsNotificationRead(Boolean isNotificationRead)
	{
		this.isNotificationRead= isNotificationRead;
	}
	
	public String getOwnerUserId()
	{
		return ownerUserId;
	}
	
	public void setOwnerUserId(String ownerUserId)
	{
		this.ownerUserId= ownerUserId;
	}
	
	public String getBidderUserId()
	{
		return bidderUserId;
	}
	
	public void setBidderUserId(String bidderUserId)
	{
		this.bidderUserId= bidderUserId;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

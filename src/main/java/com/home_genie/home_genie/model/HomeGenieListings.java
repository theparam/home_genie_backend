package com.home_genie.home_genie.model;

import java.io.Serializable;

import org.bson.types.Binary;
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

	private Binary image;

	private String price;

	private String listingOwner;

	private String contactNumber;

	private String email;

	private String address;

	private String city;

	private String province;

	private String postalCode;

	private String ownerUserId;

	private String[] biddingOffers;

	private String acceptedBiddingOffer;

	private Boolean isOfferAccepted;

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

	public String getListingOwner() {
		return listingOwner;
	}

	public void setListingOwner(String listingOwner) {
		this.listingOwner = listingOwner;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

//	province
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	public Boolean getIsOfferAccepted() {
		return isOfferAccepted;
	}

	public void setIsOfferAccepted(Boolean isOfferAccepted) {
		this.isOfferAccepted = isOfferAccepted;
	}

	public Boolean getIsNotificationRead() {
		return isNotificationRead;
	}

	public void setIsNotificationRead(Boolean isNotificationRead) {
		this.isNotificationRead = isNotificationRead;
	}

	public String getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String[] getBiddingOffers() {
		return biddingOffers;
	}

	public void setBiddingOffers(String[] biddingOffers) {
		this.biddingOffers = biddingOffers;
	}

	public String getAcceptedBiddingOffer() {
		return acceptedBiddingOffer;
	}

	public void setAcceptedBiddingOffer(String acceptedBiddingOffer) {
		this.acceptedBiddingOffer = acceptedBiddingOffer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Binary getImage() {
		return image;
	}

	public void setImage(Binary image) {
		this.image = image;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}

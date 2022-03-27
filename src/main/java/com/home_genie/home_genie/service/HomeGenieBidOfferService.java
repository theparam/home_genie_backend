package com.home_genie.home_genie.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.home_genie.home_genie.model.BiddingOffer;
import com.home_genie.home_genie.model.CustomerNotification;
import com.home_genie.home_genie.model.HomeGenieListings;
import com.home_genie.home_genie.model.Notifications;
import com.home_genie.home_genie.model.OwnerNotification;
import com.home_genie.home_genie.repo.CustomerNotificationsRepo;
import com.home_genie.home_genie.repo.HomeGenieBiddingRepo;
import com.home_genie.home_genie.repo.HomeGenieListingRepository;
import com.home_genie.home_genie.repo.OwnerNotificationsRepo;

import net.minidev.json.JSONArray;

@Service
public class HomeGenieBidOfferService {

	@Autowired
	private HomeGenieBiddingRepo homeGenieBiddingRepo;

	@Autowired
	private HomeGenieListingRepository homeGenieListingRepository;

	@Autowired
	private com.home_genie.home_genie.repo.OwnerNotificationsRepo notificationsRepo;

	@Autowired
	private CustomerNotificationsRepo customerNotificationsRepo;

	public ResponseEntity<BiddingOffer> register(BiddingOffer biddingOffer) {

		BiddingOffer biddingObj = new BiddingOffer();

		Optional<HomeGenieListings> homeGenieListings = homeGenieListingRepository
				.findById(biddingOffer.getListingId());
		System.out.println("homeGenieListings = " + homeGenieListings);
		biddingObj.setIsNotificationRead("unread");
		biddingObj = homeGenieBiddingRepo.save(biddingOffer);

		System.out.println("val = " + biddingObj);

		if (homeGenieListings.isPresent()) {
			if (homeGenieListings.get().getBiddingOffers() == null) {
				homeGenieListings.get().setBiddingOffers(new ArrayList<>());
			}
			OwnerNotification ownerNotification = new OwnerNotification();
			CustomerNotification customerNotification = new CustomerNotification();
			customerNotification.setCustomerId(biddingOffer.getBidderUserId());
			customerNotification.setListingId(biddingObj.getListingId());
			customerNotification.setPublishDate(LocalDateTime.now());
			customerNotification.setStatus("unread");
			customerNotificationsRepo.save(customerNotification);
			ownerNotification.setOwnerID(homeGenieListings.get().getOwnerUserId());
			ownerNotification.setListingId(biddingOffer.getListingId());
			ownerNotification.setbidOfferId(biddingOffer.getId());
			ownerNotification.setPublishDate(LocalDateTime.now());
			ownerNotification.setStatus("unread");
			notificationsRepo.save(ownerNotification);
			homeGenieListings.get().getBiddingOffers().add(biddingObj.getId());
//				homeGenieListings.get().setBiddingOffers(homeGenieListings.get().getBiddingOffers());
			homeGenieListingRepository.save(homeGenieListings.get());
		}

		return ResponseEntity.ok(biddingOffer);

	}

	public ResponseEntity<BiddingOffer> update(BiddingOffer biddingOffer) {
		// TODO Auto-generated method stub
		Optional<HomeGenieListings> homeGenieListings = homeGenieListingRepository
				.findById(biddingOffer.getListingId());

		if (homeGenieListings.isPresent()) {

			homeGenieListings.get().setIsOfferAccepted(Boolean.TRUE);
			homeGenieListings.get().setAcceptedBiddingOffer(biddingOffer.getId());
			homeGenieBiddingRepo.save(biddingOffer);
			OwnerNotification ownerNotification = new OwnerNotification();
			ownerNotification.setbidOfferId(biddingOffer.getId());
			ownerNotification.setOwnerID(homeGenieListings.get().getOwnerUserId());
			ownerNotification.setListingId(biddingOffer.getListingId());
			ownerNotification.setPublishDate(LocalDateTime.now());
			ownerNotification.setStatus("unread");
			notificationsRepo.save(ownerNotification);
			homeGenieListingRepository.save(homeGenieListings.get());
		}
		homeGenieListingRepository.save(homeGenieListings.get());
		return ResponseEntity.ok(biddingOffer);
	}

	public ResponseEntity<BiddingOffer> decline(BiddingOffer biddingOffer) {
		// TODO Auto-generated method stub
		Optional<HomeGenieListings> homeGenieListings = homeGenieListingRepository
				.findById(biddingOffer.getListingId());
		if (!Boolean.parseBoolean(biddingOffer.isOfferAccepted())) {
			if (homeGenieListings.isPresent()) {
				homeGenieListings.get().getBiddingOffers().remove(biddingOffer.getId());
//				homeGenieListings.get().setBiddingOffers(homeGenieListings.get().getBiddingOffers());
				homeGenieListingRepository.save(homeGenieListings.get());
				homeGenieBiddingRepo.delete(biddingOffer);
			}
		}
		return ResponseEntity.ok().build();
	}

	public BiddingOffer getBiddingOfferById(String id) {
		Optional<BiddingOffer> biddingOffer = homeGenieBiddingRepo.findById(id);
		BiddingOffer fetchedOffer = null;
		if (biddingOffer.isPresent()) {

			fetchedOffer = biddingOffer.get();
		}
		return fetchedOffer;

	}
}

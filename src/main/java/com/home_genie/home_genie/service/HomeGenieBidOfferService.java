package com.home_genie.home_genie.service;

import java.io.IOException;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.home_genie.home_genie.model.BiddingOffer;
import com.home_genie.home_genie.repo.HomeGenieBiddingRepo;

@Service
public class HomeGenieBidOfferService {

	@Autowired
	private HomeGenieBiddingRepo homeGenieBiddingRepo;

	public ResponseEntity<BiddingOffer> register(BiddingOffer biddingOffer) {

		BiddingOffer biddingObj;
		biddingObj = homeGenieBiddingRepo.save(biddingOffer);
		return ResponseEntity.ok(biddingOffer);

	}
}

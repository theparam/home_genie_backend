package com.home_genie.home_genie.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.home_genie.home_genie.model.HomeGenieListings;
import com.home_genie.home_genie.repo.HomeGenieListingRepository;

@Service
public class HomeGenieListingService {

	@Autowired
	private HomeGenieListingRepository homeGenieListingsRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	public ResponseEntity<?> create(HomeGenieListings listing,MultipartFile file) {
		try {
			listing.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		

		homeGenieListingsRepository.save(listing);
		return ResponseEntity.ok("{\"message\":\"List Added\"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResponseEntity<HomeGenieListings> UpdateListing(String id, HomeGenieListings homeGenieUser) {
		Optional<HomeGenieListings> listing = homeGenieListingsRepository.findById(id);

		HomeGenieListings updatedListing = null;
		if (listing.isPresent()) {
//			HomeGenieListings homeGenieValidUser =User.get();
//			homeGenieValidUser.setEmail(homeGenieUser.getEmail());
//			homeGenieValidUser.setLastName(homeGenieUser.getLastName());
//			homeGenieValidUser.setFirstName(homeGenieUser.getFirstName());
//			updatedUser= homeGenieListingsRepository.save(homeGenieValidUser);	
		}
		return ResponseEntity.ok(updatedListing);

	}

	public HomeGenieListings getListingById(String id) {
		Optional<HomeGenieListings> listing = homeGenieListingsRepository.findById(id);
		HomeGenieListings fetchedListing = null;
		if (listing.isPresent()) {
			
			fetchedListing =listing.get();
//			homeGenieValidUser.setEmail(homeGenieUser.getEmail());
//			homeGenieValidUser.setLastName(homeGenieUser.getLastName());
//			homeGenieValidUser.setFirstName(homeGenieUser.getFirstName());
//			updatedUser= homeGenieListingsRepository.save(homeGenieValidUser);	
		}
		return fetchedListing;
	}

	public HomeGenieListings getListingByOwnerId(String id) {
//		we have to get the listing by ownerId
		Optional<HomeGenieListings> listing = homeGenieListingsRepository.findById(id);
		HomeGenieListings fetchedListing = null;
		if (listing.isPresent()) {
			
			fetchedListing =listing.get();
//			homeGenieValidUser.setEmail(homeGenieUser.getEmail());
//			homeGenieValidUser.setLastName(homeGenieUser.getLastName());
//			homeGenieValidUser.setFirstName(homeGenieUser.getFirstName());
//			updatedUser= homeGenieListingsRepository.save(homeGenieValidUser);	
		}
		return fetchedListing;
	}

	public HomeGenieListings getListingByBidderId(String id) {
//		we have to get the listing by BidderId
		Optional<HomeGenieListings> listing = homeGenieListingsRepository.findById(id);
		HomeGenieListings fetchedListing = null;
		if (listing.isPresent()) {
			
			fetchedListing =listing.get();
//			homeGenieValidUser.setEmail(homeGenieUser.getEmail());
//			homeGenieValidUser.setLastName(homeGenieUser.getLastName());
//			homeGenieValidUser.setFirstName(homeGenieUser.getFirstName());
//			updatedUser= homeGenieListingsRepository.save(homeGenieValidUser);	
		}
		return fetchedListing;
	}

	public String UpdateListingByAcceptedOffer(String id, String ownerUserId, String bidderUserId,
			Boolean isOfferAccepted, HomeGenieListings homeGenieListing) {
		Optional<HomeGenieListings> listing = homeGenieListingsRepository.findById(id);

//		HomeGenieListings updatedListing = null;
		if (listing.isPresent()) {
//			HomeGenieListings homeGenieValidUser =User.get();
//			homeGenieValidUser.setEmail(homeGenieUser.getEmail());
//			homeGenieValidUser.setLastName(homeGenieUser.getLastName());
//			homeGenieValidUser.setFirstName(homeGenieUser.getFirstName());
//			updatedUser= homeGenieListingsRepository.save(homeGenieValidUser);	
		}
		return "ok";
	}

	public List<HomeGenieListings> searchListing(String title, String category) {
		Query query = new Query();
		if(!StringUtils.isEmpty(title)&& title!=null)
		query.addCriteria(Criteria.where("title").regex(title,"i"));
		if(!StringUtils.isEmpty(category) && category!=null)
		query.addCriteria(Criteria.where("category").regex(category,"i"));
//		
//	
//
		List<HomeGenieListings> result = mongoTemplate.find(query, HomeGenieListings.class);
//		
//		HomeGenieListings[] listings = homeGenieListingsRepository.findAll(query);
//
		return result;
//
	}

}

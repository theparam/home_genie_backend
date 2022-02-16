package com.home_genie.home_genie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.home_genie.home_genie.model.HomeGenieListings;
import com.home_genie.home_genie.repo.HomeGenieListingRepository;

@Service
public class HomeGenieListingService {

	@Autowired
	private HomeGenieListingRepository homeGenieListingsRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	public String create(HomeGenieListings listing) {
		homeGenieListingsRepository.save(listing);
		return "created";

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
		query.addCriteria(Criteria.where("title").is(title));
		query.addCriteria(Criteria.where("category").is(category));
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

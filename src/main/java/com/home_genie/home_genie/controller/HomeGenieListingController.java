package com.home_genie.home_genie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home_genie.home_genie.model.HomeGenieListings;
import com.home_genie.home_genie.service.HomeGenieListingService;

@RestController
@RequestMapping("/home/genie/listing")
public class HomeGenieListingController {

	@Autowired
	private HomeGenieListingService homeGenieListingService;

//	This is used to when new listing is created
	@PostMapping("/create")
	public String createListing(@RequestBody HomeGenieListings listing) {
		return homeGenieListingService.create(listing);
	}

//	Updating the Listing
	@PutMapping("/update/{id}")
	public ResponseEntity<HomeGenieListings> updateListing(@PathVariable(value = "id") String id,
			@RequestBody HomeGenieListings homeGenieUser) {

		return homeGenieListingService.UpdateListing(id, homeGenieUser);
	}

	// This will update the listing when offer of the customer is accepted by owner
	// of listing 	
	@PutMapping("/listing/{id}/{ownerUserId}/{bidderUserId}/{isOfferAccepted}")
	public String updateListing(@PathVariable(value = "id") String id,
			@PathVariable(value = "ownerUserId") String ownerUserId,
			@PathVariable(value = "bidderUserId") String bidderUserId,
			@PathVariable(value = "isOfferAccepted") Boolean isOfferAccepted,
			@RequestBody HomeGenieListings homeGenieListing) {

		return homeGenieListingService.UpdateListingByAcceptedOffer(id, ownerUserId, bidderUserId, isOfferAccepted,
				homeGenieListing);
	}

//	This is to get specific listing 
	@GetMapping(value = "/{id}")
	public HomeGenieListings getListingById(@PathVariable("id") String id) {

		return homeGenieListingService.getListingById(id);
	}

//	this is the get listing who created it 
//	will be used in View all listing
	@GetMapping(value = "/listingByOwner/{ownerUserId}")
	public HomeGenieListings getListingByOwnerId(@PathVariable("ownerUserId") String ownerUserId) {

		return homeGenieListingService.getListingByOwnerId(ownerUserId);
	}
	
//	will be used to get listing by bidderID
	@GetMapping(value = "/listingByBidder/{bidderUserId}")
	public HomeGenieListings getListingByBidderId(@PathVariable("bidderUserId") String bidderUserId) {

		return homeGenieListingService.getListingByBidderId(bidderUserId);
	}
	
//	Search all listing via specific category
//	we need to use only one api depending a category is selected or not
//	@GetMapping(value="/searchlisting/{title}/{category}")
//	public HomeGenieListings[] searchListing(@PathVariable("tittle") String title, @PathVariable("category") String category)
//	{
////		return HomeGenieListingService.searchListing(title, category);
//	}

}

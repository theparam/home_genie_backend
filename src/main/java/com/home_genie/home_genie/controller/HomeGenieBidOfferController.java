package com.home_genie.home_genie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home_genie.home_genie.model.BiddingOffer;
import com.home_genie.home_genie.service.HomeGenieBidOfferService;

@RestController
@RequestMapping("/home/genie/user")
public class HomeGenieBidOfferController {

	@Autowired
	private HomeGenieBidOfferService homeGenieBiddingOfferService;

	@PostMapping("/create")
	public ResponseEntity<BiddingOffer> registerBiddingOffer(@RequestBody BiddingOffer biddingOffer) {

		return homeGenieBiddingOfferService.register(biddingOffer);
	}

}

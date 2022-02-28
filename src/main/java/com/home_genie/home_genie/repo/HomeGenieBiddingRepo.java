package com.home_genie.home_genie.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.home_genie.home_genie.model.BiddingOffer;

public interface HomeGenieBiddingRepo extends MongoRepository<BiddingOffer,String> {
		
//	public BiddingOffer findByEmail(String email);
}

package com.home_genie.home_genie.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.home_genie.home_genie.model.HomeGenieListings;

public interface HomeGenieListingRepository extends MongoRepository<HomeGenieListings, String> {

//	public HomeGenieListings findByEmail(String email);
}

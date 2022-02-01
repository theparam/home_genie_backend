package com.home_genie.home_genie.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.home_genie.home_genie.model.HomeGenieUser;

public interface HomeGenieRepository extends MongoRepository<HomeGenieUser,String> {
		
	public HomeGenieUser findByEmail(String email);
}

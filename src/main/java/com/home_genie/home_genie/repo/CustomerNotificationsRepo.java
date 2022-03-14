package com.home_genie.home_genie.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.home_genie.home_genie.model.CustomerNotification;
import com.home_genie.home_genie.model.Notifications;

public interface CustomerNotificationsRepo extends MongoRepository<CustomerNotification,String> {
		
//	public BiddingOffer findByEmail(String email);
}

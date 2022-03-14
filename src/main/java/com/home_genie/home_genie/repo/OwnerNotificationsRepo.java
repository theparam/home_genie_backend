package com.home_genie.home_genie.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.home_genie.home_genie.model.Notifications;
import com.home_genie.home_genie.model.OwnerNotification;

public interface OwnerNotificationsRepo extends MongoRepository<OwnerNotification,String> {
		
//	public BiddingOffer findByEmail(String email);
}

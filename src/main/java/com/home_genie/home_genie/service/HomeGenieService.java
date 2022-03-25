package com.home_genie.home_genie.service;

import java.io.IOException;
import java.time.LocalDateTime;
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

import com.home_genie.home_genie.model.CustomerNotification;
import com.home_genie.home_genie.model.HomeGenieListings;
import com.home_genie.home_genie.model.HomeGenieUser;
import com.home_genie.home_genie.model.Notifications;
import com.home_genie.home_genie.model.OwnerNotification;
import com.home_genie.home_genie.repo.CustomerNotificationsRepo;
import com.home_genie.home_genie.repo.HomeGenieRepository;
import com.home_genie.home_genie.repo.OwnerNotificationsRepo;

@Service
public class HomeGenieService {

	@Autowired
	private HomeGenieRepository homeGenieRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CustomerNotificationsRepo customerNotificationsRepo;
	
	@Autowired
	private OwnerNotificationsRepo ownerNotificationsRepo;

	public ResponseEntity<HomeGenieUser> signUp(HomeGenieUser homeGenieUser) {
	 	homeGenieUser = homeGenieRepository.save(homeGenieUser);
		return ResponseEntity.ok(homeGenieUser);

	}

	public ResponseEntity<?> loginUser(HomeGenieUser homeGenieUser) throws Exception {
		
		HomeGenieUser storedHomeGenieUser = homeGenieRepository.findByEmail(homeGenieUser.getEmail());
		if(storedHomeGenieUser!=null) {
			if (storedHomeGenieUser.getEmail().equals(homeGenieUser.getEmail()) && storedHomeGenieUser.getPassword().equals( homeGenieUser.getPassword())) {
				return ResponseEntity.ok(storedHomeGenieUser);
			}
			else {
				homeGenieUser.setValid(false);
				return ResponseEntity.ok("{\"message\":\"Invalid User\"}");
			}
		}
		else {
			homeGenieUser.setValid(false);
			return ResponseEntity.ok("{\"message\":\"Invalid User\"}");
		}	}

	public ResponseEntity<HomeGenieUser> UpdateUser(String id, HomeGenieUser homeGenieUser) {
		Optional<HomeGenieUser> User = homeGenieRepository.findById(id);
		homeGenieUser.setId(id);
		homeGenieRepository.save(homeGenieUser);
		return ResponseEntity.ok(homeGenieUser);

	}
	
	public ResponseEntity<HomeGenieUser> getUserById(String id) {
		Optional<HomeGenieUser> user = homeGenieRepository.findById(id);
		
		if(user.isPresent())
		{
			return ResponseEntity.ok(user.get());
		}
		else
			return null;
	}

	public ResponseEntity<HomeGenieUser> updateProfileImage(String id, MultipartFile userImage) {
		// TODO Auto-generated method stub
		Optional<HomeGenieUser> user = homeGenieRepository.findById(id);

		try {

			user.get().setImage(new Binary(BsonBinarySubType.BINARY, userImage.getBytes()));
			homeGenieRepository.save(user.get());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//        photo = photoRepo.insert(photo); return photo.getId(););
		return ResponseEntity.ok(user.get());
	}
	
	public String uploadProfileImage(String id, MultipartFile userImage) {
		// TODO Auto-generated method stub
		try {
			Optional<HomeGenieUser> user = homeGenieRepository.findById(id);

			user.get().setImage(new Binary(BsonBinarySubType.BINARY, userImage.getBytes()));
			homeGenieRepository.save(user.get());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//        photo = photoRepo.insert(photo); return photo.getId(););
		return "Uploaded";
	}

	public ResponseEntity<CustomerNotification> updateCustomerNotifications(String id, String status) {
		// TODO Auto-generated method stub
		CustomerNotification customerNotification = customerNotificationsRepo.findById(id).get();
		customerNotification.setStatus(status);
		customerNotification.setPublishDate(LocalDateTime.now());

		customerNotificationsRepo.save(customerNotification);
		return ResponseEntity.ok(customerNotification);
	}

	public ResponseEntity<OwnerNotification> updateOwnerNotifications(String id, String status) {
		// TODO Auto-generated method stub
		OwnerNotification ownerNotification = ownerNotificationsRepo.findById(id).get();
		ownerNotification.setStatus(status);
		ownerNotification.setPublishDate(LocalDateTime.now());
		ownerNotificationsRepo.save(ownerNotification);

		return ResponseEntity.ok(ownerNotification);
	}
	
	public List<OwnerNotification> getOwnerNotifications(String ownerID)
	{
		Query query = new Query();
		if (!StringUtils.isEmpty(ownerID) && ownerID != null)
			query.addCriteria(Criteria.where("ownerID").regex(ownerID, "i"));

		List<OwnerNotification> result = mongoTemplate.find(query, OwnerNotification.class);

		return result;
	}
	
	public List<CustomerNotification> getCustomerNotifications(String customerId)
	{
		Query query = new Query();
		if (!StringUtils.isEmpty(customerId) && customerId != null)
			query.addCriteria(Criteria.where("customerId").regex(customerId, "i"));

		List<CustomerNotification> result = mongoTemplate.find(query, CustomerNotification.class);

		return result;
	}

}

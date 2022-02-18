package com.home_genie.home_genie.service;

import java.io.IOException;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.home_genie.home_genie.model.HomeGenieUser;
import com.home_genie.home_genie.repo.HomeGenieRepository;

@Service
public class HomeGenieService {

	@Autowired
	private HomeGenieRepository homeGenieRepository;

	public ResponseEntity<HomeGenieUser> signUp(HomeGenieUser homeGenieUser) {
	 	homeGenieUser = homeGenieRepository.save(homeGenieUser);
		return ResponseEntity.ok(homeGenieUser);

	}

	public ResponseEntity<?> loginUser(HomeGenieUser homeGenieUser) throws Exception {
		
		HomeGenieUser storedHomeGenieUser = homeGenieRepository.findByEmail(homeGenieUser.getEmail());
		if(storedHomeGenieUser!=null) {
			if (storedHomeGenieUser.getEmail().equals(homeGenieUser.getEmail()) && storedHomeGenieUser.getPassword().equals( homeGenieUser.getPassword())) {
				return ResponseEntity.ok(homeGenieUser);
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
//		HomeGenieUser updatedUser = new HomeGenieUser();
//		if (User.isPresent()) {
//			HomeGenieUser homeGenieValidUser = User.get();
//			homeGenieValidUser.setEmail(homeGenieUser.getEmail());
//			homeGenieValidUser.setLastName(homeGenieUser.getLastName());
//			homeGenieValidUser.setFirstName(homeGenieUser.getFirstName());
//			updatedUser =
					homeGenieRepository.save(homeGenieUser);
//		}
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

}

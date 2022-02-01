package com.home_genie.home_genie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.home_genie.home_genie.model.HomeGenieUser;
import com.home_genie.home_genie.repo.HomeGenieRepository;

@Service
public class HomeGenieService {

	@Autowired
	private HomeGenieRepository homeGenieRepository;

	public String signUp(HomeGenieUser homeGenieUser) {
		homeGenieRepository.save(homeGenieUser);
		return "created";

	}

	public String loginUser(HomeGenieUser homeGenieUser) {
		homeGenieRepository.findByEmail(homeGenieUser.getEmail());
		return "Fetch";
	}

	public HomeGenieUser getUserById(String id) {
		Optional<HomeGenieUser> user = homeGenieRepository.findById(id);
		
		if(user.isPresent())
		{
			return user.get();
		}
		else
			return null;
	}

	public ResponseEntity<HomeGenieUser> UpdateUser(String id, HomeGenieUser homeGenieUser) {
		Optional<HomeGenieUser> User = homeGenieRepository.findById(id);

		HomeGenieUser updatedUser = null;
		if (User.isPresent()) {
			HomeGenieUser homeGenieValidUser = User.get();
			homeGenieValidUser.setEmail(homeGenieUser.getEmail());
			homeGenieValidUser.setLastName(homeGenieUser.getLastName());
			homeGenieValidUser.setFirstName(homeGenieUser.getFirstName());
			updatedUser = homeGenieRepository.save(homeGenieValidUser);
		}
		return ResponseEntity.ok(updatedUser);

	}

}

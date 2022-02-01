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
import com.home_genie.home_genie.model.HomeGenieUser;
import com.home_genie.home_genie.service.HomeGenieService;

@RestController
@RequestMapping("/home/genie/user")
public class HomeGenieController {

	@Autowired
	private HomeGenieService homeGenieService;

	@PostMapping("/signup")
	public String userSignup(@RequestBody HomeGenieUser homeGenieUser) {
		return homeGenieService.signUp(homeGenieUser);
	}

	@PostMapping("/login")
	public String UserLogin(@RequestBody HomeGenieUser homeGenieUser) {
		return homeGenieService.loginUser(homeGenieUser);
	}

	@GetMapping(value = "/{id}")
	public HomeGenieUser getUserById(@PathVariable("id") String id) {

		return homeGenieService.getUserById(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<HomeGenieUser> updateUser(@PathVariable(value = "id") String id,
			@RequestBody HomeGenieUser homeGenieUser) {

		return homeGenieService.UpdateUser(id, homeGenieUser);
	}

}

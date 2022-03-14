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
import org.springframework.web.multipart.MultipartFile;

import com.home_genie.home_genie.model.CustomerNotification;
import com.home_genie.home_genie.model.HomeGenieUser;
import com.home_genie.home_genie.model.Notifications;
import com.home_genie.home_genie.model.OwnerNotification;
import com.home_genie.home_genie.service.HomeGenieService;

@RestController
@RequestMapping("/home/genie/user")
public class HomeGenieController {

	@Autowired
	private HomeGenieService homeGenieService;

	@SuppressWarnings("deprecation")
	@PostMapping("/signup")
	public ResponseEntity<HomeGenieUser> userSignup(@RequestBody HomeGenieUser homeGenieUser) throws Exception {
		if(StringUtils.isEmpty(homeGenieUser.getEmail()) || StringUtils.isEmpty(homeGenieUser.getFirstName()) || StringUtils.isEmpty(homeGenieUser.getPassword())|| StringUtils.isEmpty(homeGenieUser.getPhoneNumber())) {
			throw new Exception("Email, FirstName, PassWord Phone Number should not be blank");
		}
		return homeGenieService.signUp(homeGenieUser);
	}

	@PostMapping(value = "/upload-image/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String uploadProfileImage(@PathVariable(value = "id") String id,@RequestParam(value = "file",required = false) MultipartFile file) throws Exception {
		return homeGenieService.uploadProfileImage(id,file);
	}
	
	@PostMapping(value = "/update-image/{id}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}  )
	public ResponseEntity<HomeGenieUser> updateProfileImage(@PathVariable(value = "id") String id,@RequestParam(value = "file",required = false) MultipartFile file) throws Exception {
		return homeGenieService.updateProfileImage(id,file);
	}

	@PostMapping("/login")
	public ResponseEntity<?> UserLogin(@RequestBody HomeGenieUser homeGenieUser) throws Exception {
		if(StringUtils.isEmpty(homeGenieUser.getEmail()) || StringUtils.isEmpty(homeGenieUser.getPassword())) {
			throw new Exception("Email, PassWord should not be blank");
		}
		return homeGenieService.loginUser(homeGenieUser);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<HomeGenieUser> getUserById(@PathVariable("id") String id) {

		return homeGenieService.getUserById(id);
	}

	@SuppressWarnings("deprecation")
	@PutMapping("/update/{id}")
	public ResponseEntity<HomeGenieUser> updateUser(@PathVariable(value = "id") String id,
			@RequestBody HomeGenieUser homeGenieUser) throws Exception {
		if(StringUtils.isEmpty(homeGenieUser.getEmail()) || StringUtils.isEmpty(homeGenieUser.getFirstName()) || StringUtils.isEmpty(homeGenieUser.getPassword())|| StringUtils.isEmpty(homeGenieUser.getPhoneNumber())) {
			throw new Exception("Email, FirstName, PassWord Phone Number should not be blank");
		}
		return homeGenieService.UpdateUser(id, homeGenieUser);
	}
	
	@PostMapping(value = "/customer-notification/{id}")
	public ResponseEntity<CustomerNotification> homeGenieCustomerNotification(@PathVariable(value = "id") String id,@RequestParam(value = "status") String status) throws Exception {
		return homeGenieService.updateCustomerNotifications(id,status);
	}
	
	@PostMapping(value = "/owner-notification/{id}")
	public ResponseEntity<OwnerNotification> homeGenieOwnerNotification(@PathVariable(value = "id") String id,@RequestParam(value = "status") String status) throws Exception {
		return homeGenieService.updateOwnerNotifications(id,status);
	}

}

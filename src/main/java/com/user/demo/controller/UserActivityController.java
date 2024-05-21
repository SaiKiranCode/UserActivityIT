package com.user.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.demo.model.Activity;
import com.user.demo.model.User;
import com.user.demo.service.UserActivityService;

@RestController
public class UserActivityController {

	@Autowired
	UserActivityService userActivityService;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@PostMapping(value = "/createActivity", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Map<String, String>> createActivity(@RequestBody Activity activitydata) {
		final Map<String, String> responseMap = new HashMap<>();
		boolean status = false;

		status = userActivityService.putActivitytoDB(activitydata, namedParameterJdbcTemplate);

		if (status == true) {

			responseMap.put("Status", "Success");
		} else {
			responseMap.put("Status", "Failure");
		}
		return new ResponseEntity<Map<String, String>>(responseMap, HttpStatus.OK);
	}

	@DeleteMapping("/activity/{id}")
	public String deleteActivity(@PathVariable("id") Long activityId) {

		boolean status = false;

		status = userActivityService.deleteActivityById(activityId);

		if (status == true) {

			return "Activity deleted Succesuffully ";
		} else {
			return "failure while deleting activity with ID " + activityId;
		}

	}

	/*
	 * @GetMapping("/activity/{user}") public User
	 * deleteActivity(@PathVariable("id") String user) {
	 * 
	 * User useroutput;
	 * 
	 * useroutput = userActivityService.getUserbyUserName(user);
	 * 
	 * return useroutput;
	 * 
	 * }
	 */
	
	@GetMapping("/getActivityByuser/{user}")
	public ResponseEntity<Map<String, List<Activity>>> getActivitiesAssignedForUser(
			@PathVariable final String user) {
		final Map<String, List<Activity>> responseMap = new HashMap<>();
		final List<Activity> activityList = userActivityService.getActivityByUser(user);
		responseMap.put("activityList", activityList);
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}

	@GetMapping("/getActivityById/{activityId}")
	public ResponseEntity<Map<String, List<Activity>>> getActivitiesAssignedForId(
			@PathVariable final Long activityId) {
		final Map<String, List<Activity>> responseMap = new HashMap<>();
		final List<Activity> activityList = userActivityService.getActivityById(activityId);
		responseMap.put("activityList", activityList);
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}

	@GetMapping("/getUserByuser/{user}")
	public ResponseEntity<Map<String, List<User>>> getUserByUserName(@PathVariable final String user) {
		final Map<String, List<User>> responseMap = new HashMap<>();
		final List<User> userList = userActivityService.getUserByUserName(user);
		responseMap.put("userList", userList);
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}

}

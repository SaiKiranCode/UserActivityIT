package com.user.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.user.demo.DAOImpl.UserActivityDAOIRepositorympl;
import com.user.demo.model.Activity;
import com.user.demo.model.User;

@Service
public class UserActivityService {

	/*
	 * List<Activity> fetchStuydentlist();
	 * 
	 * Activity saveActivity(Activity activity); Activity updateActivity (Activity
	 * activity, Long activityid ); void deleteActivitybyId(Long activityid);
	 */

	@Autowired
	UserActivityDAOIRepositorympl userActivityDAOIRepositorympl;

	public Boolean putActivitytoDB(Activity activity, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		return userActivityDAOIRepositorympl.putActivitytoDB(activity, namedParameterJdbcTemplate);
	}

	public boolean deleteActivityById(Long Id) {
		return userActivityDAOIRepositorympl.deleteActivityById(Id);
	}

	public User getUserbyUserName(String user) {
		// TODO Auto-generated method stub
		return userActivityDAOIRepositorympl.getUserbyUserName(user);
	}

	public List<Activity> getActivityById(Long activityId) {
		// TODO Auto-generated method stub
		return userActivityDAOIRepositorympl.getActivityById(activityId);
	}

	public List<User> getUserByUserName(String user) {
		return userActivityDAOIRepositorympl.getUserByUserName(user);
	}

	public List<Activity> getActivityByUser(String user) {
		return userActivityDAOIRepositorympl.getActivityByUser(user);
	}
}

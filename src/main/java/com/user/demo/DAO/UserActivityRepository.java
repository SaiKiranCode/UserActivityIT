package com.user.demo.DAO;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.user.demo.model.Activity;
import com.user.demo.model.User;

@Repository
public interface UserActivityRepository {

	public Boolean putActivitytoDB(Activity activity, NamedParameterJdbcTemplate namedParameterJdbcTemplate);

	public Boolean deleteActivityById(Long Id);

	public User getUserbyUserName(String user);

	public List<Activity> getActivityById(Long activityId);

	public List<User> getUserByUserName(String user);
}

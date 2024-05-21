package com.user.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.user.demo.model.Activity;

public class ActivityRowMapper implements RowMapper<Activity> {

	@Override
	public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
		Activity activityDetails = new Activity();
		activityDetails.setId(rs.getLong("id"));
		activityDetails.setUser(rs.getString("user"));
		activityDetails.setActivity(rs.getString("activity"));
		activityDetails.setDate(rs.getDate("date"));
		activityDetails.setDetails(rs.getString("details"));
		activityDetails.setPoints(rs.getLong("points"));

		return activityDetails;
	}

}

package com.user.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.user.demo.model.User;

public class UserRowMpper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User uderdetails = new User();
		uderdetails.setName(rs.getString("name"));
		uderdetails.setTotal_points(rs.getLong("total_points"));
		uderdetails.setUser(rs.getString("user"));

		return uderdetails;

	}

}

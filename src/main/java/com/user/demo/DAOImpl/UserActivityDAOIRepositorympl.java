package com.user.demo.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.user.demo.DAO.UserActivityRepository;
import com.user.demo.mapper.ActivityRowMapper;
import com.user.demo.mapper.UserRowMpper;
import com.user.demo.model.Activity;
import com.user.demo.model.User;

@Service
public class UserActivityDAOIRepositorympl implements UserActivityRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Boolean putActivitytoDB(Activity activity, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

		try {
			KeyHolder holder = new GeneratedKeyHolder();

			final String sql = "insert into activity (id, user, activity, date, details,points) values(:id,:user,:activity,:date,:details,:points);";

			SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", activity.getId())
					.addValue("user", activity.getUser()).addValue("activity", activity.getActivity())
					.addValue("date", activity.getDate()).addValue("details", activity.getDetails())
					.addValue("points", activity.getPoints());

			int output = namedParameterJdbcTemplate.update(sql, parameters, holder);

			if (output == 1) {
				return true;
			} else {
				return false;
			}
			/*
			 * try { final String sql =
			 * "insert into activity (id, user, activity, date, details,points) values(?,?,?,?,?,?);"
			 * ; int output = jdbcTemplate.update(sql,
			 * activity.getId(),activity.getActivity(), activity.getUser(),
			 * activity.getDate(), activity.getDetails(), activity.getPoints()); if (output
			 * == 1) { return true; } else { return false; } } catch (Exception e) { return
			 * false; }
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Boolean deleteActivityById(Long Id) {
		final String DELETE_SQL = "Delete from " + "activity" + " where " + "id" + " =\"" + Id + "\"";

		int out_delete = jdbcTemplate.update(DELETE_SQL);
		System.out.println("Delete status  " + out_delete);
		return true;
	}

	@Override
	public User getUserbyUserName(String user) {

		User user1 = null;
		try {
			final String sql = "select * from User where user=?";
			user1 = (User) jdbcTemplate.query(sql, new UserRowMpper(), user);

		} catch (Exception e) {

		}

		return user1;

	}

	public List<Activity> getActivityById(Long activityId) {
		final String GET_ACTIVITY_BY_ACTIVITY_ID = "select * from activity where id=?";
		@SuppressWarnings("deprecation")
		List<Activity> activityList = jdbcTemplate.query(GET_ACTIVITY_BY_ACTIVITY_ID, new Object[] { activityId },
				new ActivityRowMapper());
		return activityList;
	}

	public List<User> getUserByUserName(String user) {
		final String GET_USER_BY_USER = "select * from User where user=?";
		@SuppressWarnings("deprecation")
		List<User> userList = jdbcTemplate.query(GET_USER_BY_USER, new Object[] { user }, new UserRowMpper());
		return userList;
	}

	public List<Activity> getActivityByUser(String user) {
		final String GET_ACTIVITY_BY_USER = "select * from activity where user=?";
		@SuppressWarnings("deprecation")
		List<Activity> activityList = jdbcTemplate.query(GET_ACTIVITY_BY_USER, new Object[] { user },
				new ActivityRowMapper());
		return activityList;
	}

}

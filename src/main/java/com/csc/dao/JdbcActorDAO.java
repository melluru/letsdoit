package com.csc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.csc.dao.ActorDAO;
import com.csc.models.Actor;
 

public class JdbcActorDAO implements ActorDAO{
	private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void insert(Actor actor){
 
		String sql = "INSERT INTO ACTOR " +
				"(ACTOR_ID, FIRST_NAME, LAST_NAME) VALUES (?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, actor.getId());
			ps.setString(2, actor.getFirstName());
			ps.setString(3, actor.getLastName());
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
 
	public Actor findByActorId(int actorId){
 
		String sql = "SELECT * FROM ACTOR WHERE ACTOR_ID = ?";
 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, actorId);
			Actor actor = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				actor = new Actor(
					rs.getInt("ACTOR_ID"),
					rs.getString("FIRST_NAME"), 
					rs.getString("LAST_NAME")
				);
			}
			rs.close();
			ps.close();
			return actor;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

}

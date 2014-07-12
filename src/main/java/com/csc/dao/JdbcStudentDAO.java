package com.csc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.csc.models.Student;

public class JdbcStudentDAO implements StudentDAO{
	private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void insert(Student std){
 
		String sql = "INSERT INTO CONTACT " +
				"(ID, FIRSTNAME, LASTNAME) VALUES (?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, std.getId());
			ps.setString(2, std.getFirstName());
			ps.setString(3, std.getLastName());
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
 
	public Student findByStudentId(int stdId){
 
		String sql = "SELECT * FROM CONTACT WHERE ID = ?";
 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, stdId);
			Student std = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				std = new Student(
					rs.getInt("ID"),
					rs.getString("FIRSTNAME"), 
					rs.getString("LASTNAME")
				);
			}
			rs.close();
			ps.close();
			return std;
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

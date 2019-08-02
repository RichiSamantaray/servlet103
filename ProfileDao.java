package com.maren.jdbcdemo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ProfileDao {

	public int save(Profile profile) throws IOException {
		Connection db = null;
		Statement st = null;
		int res = 0;
		try {
			db = DBConn.dbConn();
			st = db.createStatement();
			res = st.executeUpdate("INSERT INTO profile VALUES ('"+profile.getUserid()+"', '"+profile.getName()+"', '"+profile.getEmail()+"', "+profile.getMobile()+")"); 
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				db.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public List<Profile> fetchAll() throws IOException {
		List<Profile> list=null;
		Connection db = null;
		Statement st = null;
		try {
			db = DBConn.dbConn();
			st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM profile");
			if(rs != null)
				list = new ArrayList<>();
			while(rs.next()) {
				Profile pr = new Profile();
				pr.setUserid(rs.getString("userid"));
				pr.setName(rs.getString("name"));
				pr.setEmail(rs.getString("email"));
				pr.setMobile(rs.getLong("mobile"));
				list.add(pr);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}
	public static void main(String[] args) throws IOException {
		Connection db = null;
		Statement st = null;
		try {
			db=DBConn.dbConn();
			st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM profile");
			while(rs.next()) {
				String id = rs.getString("userid");
				String name = rs.getString("name");
				String email = rs.getString("email");
				long mobile = rs.getLong("mobile");
				System.out.println("Id : " +id + "\tName : "+ name+ "\tEmail : " +email + "\tMobile : " +mobile );
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}

	}

}

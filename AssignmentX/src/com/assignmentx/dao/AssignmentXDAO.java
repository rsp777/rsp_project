package com.assignmentx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.assignmentx.entity.AssignmentXEntity;

public class AssignmentXDAO implements AssignmentXDAOInterface {

	public static AssignmentXDAOInterface createObjectDAO(String string) {
		// TODO Auto-generated method stub
		return new AssignmentXDAO();
	}

	@Override
	public int createProfileDAO(AssignmentXEntity ae) {
		int i=0;	
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Zensar123");
			
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/zensar");
			Connection con = ds.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into assignment values(?,?,?,?,?,?)");
			ps.setString(1,ae.getName());
			ps.setString(2,ae.getEmail());
			ps.setString(3,ae.getPass());
			ps.setString(4,ae.getContact());
			ps.setString(5,ae.getCity());
			ps.setString(6,ae.getPincode());
			
			i = ps.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
			
		return i;
	}

	
//	public boolean loginProfileDAO(AssignmentXEntity ae) {
//		ResultSet rs;
//		boolean status=false;
//		
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Zensar123");
//			PreparedStatement ps = con.prepareStatement("select * from assignment where email=? and pass=?");
//			ps.setString(1,ae.getEmail());
//			ps.setString(2,ae.getPass());
//			rs = ps.executeQuery();
//			status = rs.next();
//			
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//			
//		return status;
//	}

}
;
package com.assignmentx.service;

import com.assignmentx.dao.AssignmentXDAO;
import com.assignmentx.dao.AssignmentXDAOInterface;
import com.assignmentx.entity.AssignmentXEntity;

public class AssignmentXService implements AssignmentXServiceInterface{

	private AssignmentXService() {}
	public static AssignmentXServiceInterface createServiceObject(String string) {
		// TODO Auto-generated method stub
		return new AssignmentXService();
	}
	@Override
	public int createProfile(AssignmentXEntity ae) {
		AssignmentXDAOInterface adi = AssignmentXDAO.createObjectDAO("adi"); 
		int i = adi.createProfileDAO(ae);
		return i;
	}
	
//	public boolean loginProfile(AssignmentXEntity ae) {
//		AssignmentXDAOInterface adi = AssignmentXDAO.createObjectDAO("adi"); 
//		boolean status = adi.loginProfileDAO(ae);
//		return status;
//	}
	
	

	

	

}

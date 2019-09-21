package com.assignmentx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignmentx.entity.AssignmentXEntity;
import com.assignmentx.service.AssignmentXService;
import com.assignmentx.service.AssignmentXServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		String option = request.getParameter("ac");
		
		
		if(option.equals("register")) {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String contact = request.getParameter("contact");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			
			AssignmentXEntity ae = new AssignmentXEntity();
			ae.setName(name);
			ae.setEmail(email);
			ae.setPass(pass);
			ae.setContact(contact);
			ae.setCity(city);
			ae.setPincode(pincode);
			
			AssignmentXServiceInterface asi = AssignmentXService.createServiceObject("asi");
			
			int i = asi.createProfile(ae);
			
			if (i > 0) {
				out.println("<h1 style=text-align:center>Profile Created<br> Click <a href=login.html>here</a> to Login.</h1>");
			} 
			else {
				out.println("<h1 style=text-align:center>Profile not Created<br> Please <a href=signup.html>Sign Up</a> again.</h1>");
			}
		}
		
//		 if(option.equals("login")) {
//			
//			String email1 = request.getParameter("email1");
//			String pass1 = request.getParameter("pass1");
//			
//			AssignmentXEntity ae = new AssignmentXEntity();
//			ae.setEmail(email1);
//			ae.setPass(pass1);
//			
//			AssignmentXServiceInterface asi = AssignmentXService.createServiceObject("asi");
//			
//			boolean status = asi.loginProfile(ae);
//			if (status==true) {
//				out.println("<h1 style=text-align:center>Login Successful</h1>");
//			} 
//			else {
//				out.println("<h1 style=text-align:center>Login not Successful</h1>");
//			}
//		}
		out.print("</body></html>");
	}

}

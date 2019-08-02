package com.maren.jdbcdemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfMain
 */
@WebServlet("/ProfMain")
public class ProfMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Profile profile = new Profile();
		profile.setUserid(request.getParameter("userid"));
		profile.setName(request.getParameter("name"));
		profile.setEmail(request.getParameter("email"));
		profile.setMobile(Long.parseLong(request.getParameter("mobile")));
		// save in database
		int res = new ProfileDao().save(profile);
		request.setAttribute("RES", res);
		request.getRequestDispatcher("/profileViewAction").forward(request, response);
	
		
	}


}

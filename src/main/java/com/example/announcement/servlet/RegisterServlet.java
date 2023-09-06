package com.example.announcement.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.announcement.User;
import com.example.announcement.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="RegisterServlet", urlPatterns= {"/register"})
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	UserRepository repo;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("i am here");
		req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		
//		User user = repo.findByUsernameAndPassword(uname, pass);
		User user=repo.findByUsername(uname);
		if(user != null) {
			out.write("<h1>User Already registered</h1>");
			out.write("<br><a href=register>Click here to go back</a>");
			out.write("<br><a href=login>Click here to Log-In</a>");
			
		}else {
			repo.save(new User(uname,pass));
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
	}

}

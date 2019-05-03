package com.capgemini.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloWorld", loadOnStartup = 1, urlPatterns = { "/hello", "/helloWorld", "/login" })
public class HelloWorldController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloWorldController() {
		System.out.println("object is created");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		System.out.println("HelloWorld!!!");// this prints on console of server

		PrintWriter out = response.getWriter();
		out.println("Hello World!!!");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		RequestDispatcher dispatcher = null;
		
		if (username.equals("pratiksha") && password.equals("root@123")) {
			dispatcher = request.getRequestDispatcher("success.html");
					} else
			dispatcher = request.getRequestDispatcher("error.html");			
	}
	
	


}

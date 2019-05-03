package com.capgemini.controller.creditCard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"*.do"},loadOnStartup=1)
public class CreditCardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CreditCardController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		PrintWriter writer=response.getWriter();
		String path=request.getServletPath();
		System.out.println(path);
		if(path.equals("/credit.do")) {
			String cardHolderName =request.getParameter("customer name");
			Double amount=Double.parseDouble(request.getParameter("amount"));
			String cardType=request.getParameter("card type");
			RequestDispatcher dispatcher= request.getRequestDispatcher("CreditCard.jsp");
			request.setAttribute("name", cardHolderName);
			request.setAttribute("amount", amount);
			request.setAttribute("card type",cardType );
			dispatcher.forward(request, response);
		}
		
		
		
		
		
		
	}

}

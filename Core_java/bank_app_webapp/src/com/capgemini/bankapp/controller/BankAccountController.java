package com.capgemini.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.bankapp.service.impl.BankAccountServiceImpl;

@WebServlet(urlPatterns = { "*.do" }, loadOnStartup = 1)
public class BankAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankAccountService bankService;

	public BankAccountController() {
		bankService = new BankAccountServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String path = request.getServletPath();
		if (path.equals("/getAllBankAccounts.do")) {
			List<BankAccount> bankAccounts = bankService.displayAllAccounts();
			RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayAllBankDetails.jsp");
			request.setAttribute("accounts", bankAccounts);
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String path = request.getServletPath();
		System.out.println(path);

		if (path.equals("/addNewBankAccount.do"))

		{
			String accountHolderName = request.getParameter("accountName");
			String accountType = request.getParameter("accountType");
			double balance = Double.parseDouble(request.getParameter("accountBalance"));

			BankAccount account = new BankAccount(accountHolderName, accountType, balance);
			if (bankService.addNewBankAccount(account)) {
				out.println("<h2>BankAccount is created successfully");
				out.print("<h2><a href ='index.html'>go back");
				out.close();
			}

		}

		if (path.equals("/withdraw.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			double balance = Double.parseDouble(request.getParameter("amount"));

			try {
				try {
					bankService.withdraw(accountId, balance);
				} catch (com.capgemini.bankapp.exception.AccountNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.println("<h2>successfull withdrow ");
				out.print("<h2><a href='index.html'go back");

			} catch (LowBalanceException e) {
				e.printStackTrace();
			}

		}
		if (path.equals("/deposit.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			double balance = Double.parseDouble(request.getParameter("amount"));
			try {
				bankService.deposit(accountId, balance);
			} catch (com.capgemini.bankapp.exception.AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("<h2>successfully deposited");
			out.print("<h2><a href='index.html'go back");

		}

		if (path.equals("/deleteBankAccount.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			try {
				bankService.deleteBankAccount(accountId);
			} catch (com.capgemini.bankapp.exception.AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.println("<h2>Deleted successfully");
			out.print("<h2><a href='index.html'go back");

		}
		if (path.equals("/FundTransfer.do")) {
			long fromAccount = Long.parseLong(request.getParameter("FromAccount"));
			long toAccount = Long.parseLong(request.getParameter("ToAccount"));
			double amount = Double.parseDouble(request.getParameter("Amount"));
			try {
				try {
					bankService.fundTransfer(fromAccount, toAccount, amount);
				} catch (com.capgemini.bankapp.exception.AccountNotFoundException e) {

					e.printStackTrace();
				}
				out.println("<h2>fund transfered");
				out.println("<h2><a href='index.html'go back");
			} catch (LowBalanceException e) {

				e.printStackTrace();
			}
		}
		if (path.equals("/CheckBalance.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			try {
				bankService.checkBalance(accountId);
			} catch (com.capgemini.bankapp.exception.AccountNotFoundException e) {

				e.printStackTrace();
			}
			out.println("<h2> Balance is");
			out.println("<h2><a href='index.html'go back");
		}

		if (path.equals("/search.do")) {
			long accountId = Long.parseLong(request.getParameter("account_id"));
			BankAccount bankAccounts;

			try {
				bankAccounts = bankService.findAccountById(accountId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("searchAccount.jsp");
				request.setAttribute("account", bankAccounts);
				dispatcher.forward(request, response);
			} catch (com.capgemini.bankapp.exception.AccountNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if (path.equals("/update.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			BankAccount bankAccounts;

			try {
				bankAccounts = bankService.findAccountById(accountId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("infoBankAccount.jsp");
				request.setAttribute("account", bankAccounts);
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				out.println("account doesnt exists");
			} catch (com.capgemini.bankapp.exception.AccountNotFoundException e) {
				// TODO Auto-generated catch block
				out.println("account doesnt exists");
			}

		}

		if (path.equals("/UpdateAccount.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			String accountHolderName = request.getParameter("customer_name");
			String accountType = request.getParameter("account_type");
			boolean result = bankService.updateAccountDetails(accountId, accountHolderName, accountType);
			if (result) {
				response.sendRedirect("getAllBankAccounts.do");
				out.println("updated successfully");
				out.println("<h2><a href='index.html'go back");
			} else {
				out.println("failed to update");
				out.println("<h2><a href='index.html'go back");
			}
		}

	}
}

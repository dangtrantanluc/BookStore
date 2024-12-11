package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CustomerDAO;
import model.Customer;

/**
 * Servlet implementation class RegiserServlet
 */
@WebServlet("/register")
public class RegiserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegiserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repass = request.getParameter("repass");
		String fullname = request.getParameter("fullname");
		String sex = request.getParameter("sex");
		String dateOfBirth = request.getParameter("dayofbirth");
		String address = request.getParameter("address");
		String deliveryaddress = request.getParameter("deliveryaddress");
		String invoiceAddress = request.getParameter("invoiceAddress");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String check = request.getParameter("check");

		request.setAttribute("username", username);
		request.setAttribute("fullname", fullname);
		request.setAttribute("sex", sex);
		request.setAttribute("dateOfBirth", dateOfBirth);
		request.setAttribute("address", address);
		request.setAttribute("deliveryaddress", deliveryaddress);
		request.setAttribute("invoiceAddress", invoiceAddress);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("check", check);

		String error = "";
		String url = "";
		CustomerDAO customerDAO = new CustomerDAO();
		if (customerDAO.checkUsername(username)) {
			error += "Username had exist. Please change it.</br>";
		}
		if (!password.equals(repass)) {
			error += "Password do not same. Please check again. <br/>";
		}
		if (error.length() > 0) {
			url = "/register.jsp";
		} else {
			Random rd = new Random();
			String idCus = System.currentTimeMillis() + rd.nextInt(10000) + "";
			Customer cus = new Customer(idCus, username, password, fullname, sex, address, deliveryaddress,
					invoiceAddress, Date.valueOf(dateOfBirth), Integer.parseInt(phone), email, check != null);
			customerDAO.insert(cus);
			url = "/success.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

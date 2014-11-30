package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mysql.MysqlUtils;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MysqlUtils mysqlUtils;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        mysqlUtils=new MysqlUtils();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		boolean isRegisted=mysqlUtils.createUser(name, pass, phone, email);
		JSONObject jo=new JSONObject();
		jo.put("isRegisted", isRegisted);
		PrintWriter out=response.getWriter();
		out.println(jo.toString());
		
	}

}

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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MysqlUtils mysqlUtils=new MysqlUtils();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf8");
		request.setCharacterEncoding("utf8");
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		
		JSONObject jo=mysqlUtils.checkUser(name, pass);
		PrintWriter out=response.getWriter();
		out.println(jo.toString());
		//if(name.equals("fanz")&&pass.equals("1111"))
		//{out.println("success");}else{out.println("fail");}
	   
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}

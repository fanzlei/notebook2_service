package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import net.sf.json.JSONObject;

import com.Utils.Note;
import com.mysql.MysqlUtils;

/**
 * Servlet implementation class CreateNote
 */
@WebServlet("/CreateNote")
public class CreateNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNote() {
        super();
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
		System.out.println("bo");
		response.setContentType("text/html;charset=utf8");
		request.setCharacterEncoding("utf8");
		InputStream is= request.getInputStream();
		Note note=new Note(is);
		int id=new MysqlUtils().createNote(note);
		System.out.println("保存note成功serverId="+id);
		PrintWriter out=response.getWriter();
	    out.print(id);
		
	}

}

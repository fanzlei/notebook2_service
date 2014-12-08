package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Utils.JsonUtils;
import com.mysql.MysqlUtils;

/**
 * Servlet implementation class DeleteNote
 */
@WebServlet("/DeleteNote")
public class DeleteNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jsonString=new JsonUtils().inputStreamToString(request.getInputStream());
		JSONArray jsonArray=JSONArray.fromObject(jsonString);
		MysqlUtils util=new MysqlUtils();
		Iterator it=jsonArray.iterator();
		while(it.hasNext()){
			JSONObject jo=new JSONObject();
			jo= (JSONObject) it.next();
			String serverId=jo.getString("serverId");
			util.deleteNote(serverId);
			it.remove();
		}
		
		PrintWriter out=response.getWriter();
		out.print("hello");
	}

}

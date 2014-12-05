package com.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.json.JSONObject;

import com.Utils.Note;

public class MysqlUtils {

	Statement stmt;
	ResultSet result;
	public MysqlUtils() {
		// TODO Auto-generated constructor stub
		MysqlConnector connector=new MysqlConnector();
		stmt=connector.connectToMysql();
		
	}
	public boolean createUser(String name,String pass,String phone,String email){
	
		String sql="insert into user(name,pass,phone,email) "
				+ "values('"+name+"','"+pass+"','"+phone+"','"+email+"')";
		System.out.println("即将创建用户\n"+"用户名："+name);
		System.out.println("密码："+pass);
		System.out.println("手机："+phone);
		System.out.println("邮箱："+email);
		try {
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//登陆确认用户名和密码是否匹配
	public JSONObject checkUser(String name,String pass){
		String sql="select * from user where name='"+name+"'";
		try {
			result = stmt.executeQuery(sql);
			result.first();
			if(pass.equals(result.getString("pass"))){
				//用户名密码和传人密码一致
				System.out.println("密码验证正确，密码为："+result.getString("pass"));
				JSONObject jo=new JSONObject();
				jo.put("phone", result.getString("phone"));
				jo.put("email", result.getString("email"));
				jo.put("isChecked", true);
				return jo;
			}else{
				System.out.println("认证用户密码错误返回false,用户密码为：");
				System.out.println(result.getString("pass"));
				System.out.println("传人的密码为："+pass);
				JSONObject jo=new JSONObject();
				jo.put("isChecked", false);
				return jo;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("用户名不存在");
			JSONObject jo=new JSONObject();
			jo.put("isChecked", false);
			return jo;
		}
    }
  public int createNote(Note note){
	  //保存note到数据库，返回该note的id
	  System.out.println("创建sql");
		  String sql="insert into user_notebook(user_name,title,content,date,type) "
			  		+ "values('"+note.getUser_name()+"','"+note.getTitle()+"',"
			  				+ "'"+note.getContent()+"','"+note.getDate()+"','"+note.getType()+"')";
			  try {
				System.out.println("开始执行execute(sql)");
				stmt.execute(sql);
				System.out.println("note已插入数据库");
				sql="select id from user_notebook where user_name='"+note.getUser_name()+"'";
				result=stmt.executeQuery(sql);
				result.last();
				return result.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("执行插入笔记出错");
				return -1;
			} 
  }
public JSONObject changePassword(JSONObject jo) {
	// TODO Auto-generated method stub
	String name=jo.getString("name");
	String pass=jo.getString("pass");
	String newPass=jo.getString("newPass");
	JSONObject joo= this.checkUser(name, pass);
	if(joo.getBoolean("isChecked")){
		String sql="update user set pass='"+newPass+"' where name='"+name+"'";
		try {
			stmt.executeUpdate(sql);
			JSONObject jooo=new JSONObject();
			jooo.put("isChangedPass", true);
			return jooo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject jooo=new JSONObject();
			jooo.put("isChangedPass", false);
			return jooo;
		}
	}
	JSONObject jooo=new JSONObject();
	jooo.put("isChangedPass", false);
	return jooo;
	
}
}

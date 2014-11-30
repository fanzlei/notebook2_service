package com.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
				+ "values('"+name+"','"+pass+"''"+phone+"''"+email+"')";
		try {
			return stmt.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//登陆确认用户名和密码是否匹配
	public boolean checkUser(String name,String pass){
		String sql="select pass from user where name='"+name+"'";
		try {
			result = stmt.executeQuery(sql);
			result.first();
			if(pass.equals(result.getString("pass"))){
				//用户名密码和传人密码一致
				return true;
			}else{return false;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("用户名不存在");
			return false;
		}
			}

}

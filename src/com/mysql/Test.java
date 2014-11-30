package com.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MysqlConnector c=new MysqlConnector();
		Statement stmt= c.connectToMysql();
		String name="abc";
		String pass="abc";
		String sql="select * from user where name='"+name+"'";
		try {
			ResultSet res= stmt.executeQuery(sql);
			res.first();
			System.out.println(res.getString("pass"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

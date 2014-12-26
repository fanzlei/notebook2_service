package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnector {

	private Connection conn;
	private Statement stmt;
	
	public MysqlConnector() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动加载成功");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/notebook?useUnicode=true&characterEncoding=utf8","root","");
			System.out.println("数据库连接成功");
			stmt=conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Statement connectToMysql(){
		
		return stmt;
	}

}

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
			System.out.println("���ݿ��������سɹ�");
			conn=DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/notebook","fanz","123456");
			System.out.println("���ݿ����ӳɹ�");
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

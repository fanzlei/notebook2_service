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
		String nam="abctt";
		String pas="abctt";
		String sql="insert into user(name,pass,email) values('"+nam+"','"+pas+"','fanz@123.com')";
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

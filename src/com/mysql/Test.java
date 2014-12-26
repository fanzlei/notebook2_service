package com.mysql;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.json.JSONObject;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement stmt=new MysqlConnector().connectToMysql();
		try {
			stmt.execute("insert into user_notebook(user_name,title,content,date,type) "
					+ "values('fanz','标题','内容','2012-12-12','1')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

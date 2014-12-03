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
		JSONObject jsonObject=new JSONObject();
			jsonObject.put("user_name", "fanz");
			jsonObject.put("title", "我的笔记");
			jsonObject.put("content","今天很开心");
			jsonObject.put("date", "2014.12.03");
			System.out.println(jsonObject.toString());
	}

}

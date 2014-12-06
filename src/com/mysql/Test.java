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
		JSONObject jo=new JSONObject();
		jo.put("key", 1);
		jo.put("key", 2);
		jo.size();
		System.out.println(jo);
	}

}

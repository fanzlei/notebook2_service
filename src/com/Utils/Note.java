package com.Utils;

import java.io.InputStream;
import java.sql.Date;

import net.sf.json.JSONObject;
import net.sf.json.JSONString;

public class Note {

	String user_name;
	String pass;
	String title;
	String content;
	String date;
	String type;
	
	
	public Note(InputStream is) {
		JSONObject jsonObject;
		// TODO Auto-generated constructor stub
		String jsonString=new JsonUtils().inputStreamToString(is);
		jsonObject=JSONObject.fromObject(jsonString);
		user_name=jsonObject.getString("user_name");
	//	pass=jsonObject.getString("pass");
		title=jsonObject.getString("title");
		content=jsonObject.getString("content");
		date=jsonObject.getString("date");
		type=String.valueOf(jsonObject.getInt("type"));
	}
	public String getUser_name() {
		return user_name;
	}
	
	public String getPass() {
		return pass;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getType(){
		return type;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setType(String type) {
		this.type = type;
	}
}

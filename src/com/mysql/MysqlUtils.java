package com.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.json.JSONArray;
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
		System.out.println("���������û�\n"+"�û�����"+name);
		System.out.println("���룺"+pass);
		System.out.println("�ֻ���"+phone);
		System.out.println("���䣺"+email);
		try {
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//��½ȷ���û����������Ƿ�ƥ��
	public JSONObject checkUser(String name,String pass){
		String sql="select * from user where name='"+name+"'";
		try {
			result = stmt.executeQuery(sql);
			result.first();
			if(pass.equals(result.getString("pass"))){
				//�û�������ʹ�������һ��
				System.out.println("������֤��ȷ������Ϊ��"+result.getString("pass"));
				JSONObject jo=new JSONObject();
				jo.put("phone", result.getString("phone"));
				jo.put("email", result.getString("email"));
				jo.put("isChecked", true);
				return jo;
			}else{
				System.out.println("��֤�û�������󷵻�false,�û�����Ϊ��");
				System.out.println(result.getString("pass"));
				System.out.println("���˵�����Ϊ��"+pass);
				JSONObject jo=new JSONObject();
				jo.put("isChecked", false);
				return jo;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�û���������");
			JSONObject jo=new JSONObject();
			jo.put("isChecked", false);
			return jo;
		}
    }
  public int createNote(Note note){
	  //����note�����ݿ⣬���ظ�note��id
	  System.out.println("����sql");
		  String sql="insert into user_notebook(user_name,title,content,date,type) "
			  		+ "values('"+note.getUser_name()+"','"+note.getTitle()+"',"
			  				+ "'"+note.getContent()+"','"+note.getDate()+"','"+note.getType()+"')";
			  try {
				System.out.println("��ʼִ��execute(sql)");
				stmt.execute(sql);
				System.out.println("note�Ѳ������ݿ�");
				sql="select id from user_notebook where user_name='"+note.getUser_name()+"'";
				result=stmt.executeQuery(sql);
				result.last();
				return result.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ִ�в���ʼǳ���");
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
public JSONArray getAllNote(String name) {
	// TODO Auto-generated method stub
	String sql="select * from user_notebook where user_name='"+name+"'";
	JSONObject jo=new JSONObject();
	JSONArray ja=new JSONArray();
	try {
		result=stmt.executeQuery(sql);
		while(result.next()){
			jo.put("serverId", result.getString("id"));
			jo.put("name", result.getString("user_name"));
			jo.put("title", result.getString("title"));
			jo.put("content", result.getString("content"));
			jo.put("date", result.getString("date"));
			jo.put("type", result.getString("type"));
			ja.add(jo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ja;
}
public void updateNote(String jsonString) {
	// TODO Auto-generated method stub
	JSONObject jo=JSONObject.fromObject(jsonString);
	String name=jo.getString("name");
	String title=jo.getString("title");
	String content=jo.getString("content");
	String date=jo.getString("date");
	String type=jo.getString("date");
	String sql="update user_notebook set user_name='"+name+"',"
			+ "title='"+title+"',content='"+content+"',date='"+date+"',type='"+type+"'";
	try {
		stmt.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}

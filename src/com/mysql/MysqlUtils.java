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
	public boolean checkUser(String name,String pass){
		String sql="select pass from user where name='"+name+"'";
		try {
			result = stmt.executeQuery(sql);
			result.first();
			if(pass.equals(result.getString("pass"))){
				//�û�������ʹ�������һ��
				System.out.print("������֤��ȷ������Ϊ��"+result.getString("pass"));
				return true;
			}else{
				System.out.print("��֤�û�������󷵻�false,�û�����Ϊ��");
				System.out.println(result.getString("pass"));
				System.out.println("���˵�����Ϊ��"+pass);
				return false;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("�û���������");
			return false;
		}
			}

}

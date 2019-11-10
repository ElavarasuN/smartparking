package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 

class Just
{  
public static String data(String user,String pass){  
String s="";

int uId=0;
String username="";
String password="";
String slot="";
String status="";
int i=0;
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://bc6a65415bf050:8b6b5a41@us-cdbr-iron-east-02.cleardb.net/heroku_c99eabcae4dc3e2?reconnect=true","bc6a65415bf050","8b6b5a41");  
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from data;");  
pass=Crypt.crypt(pass);
while(rs.next())  
{uId=rs.getInt(1);
 username=rs.getString(2);
 password=rs.getString(3);
 
 if(username.equals(user)&&password.equals(pass))
 {
	i=1;
	break;
 }
 else
 {
	 i=0;
 }
}

if(i==1)
{
	rs=stmt.executeQuery("select * from slot where U_ID="+uId);
	if(rs.next())
	{
		slot=rs.getString(2);
		status=" in";
		s="status:"+status+"  slot:"+slot;
	}
	else
	{
		slot="--";
		status="out";
		s="status:"+status+"  slot:"+slot;
	}
}
else
{
	s="none";
}

con.close();  
return s;
}catch(Exception e){ System.out.println(e);}  
return null;
}  
}  
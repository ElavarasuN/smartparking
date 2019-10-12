package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 

class Just
{  
public static String data(){  
String s="";
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://bc6a65415bf050:8b6b5a41@us-cdbr-iron-east-02.cleardb.net/heroku_c99eabcae4dc3e2?reconnect=true","bc6a65415bf050","8b6b5a41");  
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from rfid");  
while(rs.next())  
s=s+rs.getInt(1)+"  "+rs.getInt(2);  
con.close();  
return s;
}catch(Exception e){ System.out.println(e);}  
return null;
}  
}  
package spn_test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class LoginDAO
{
static Connection currentCon = null;
static ResultSet rs = null;
public static LoginBean login(LoginBean bean)
{
Statement stmt = null;
String username = bean.getUsername();
String password = bean.getPassword();
String searchQuery = "select * from student where s_name ='" + username + "' AND password ='" + password + "'";
 
try
{
//connecting to the DB
currentCon = ConnectionManager.getConnection();
stmt=currentCon.createStatement();
rs = stmt.executeQuery(searchQuery);
boolean userExists = rs.next();
 
if (!userExists)
{
System.out.println("Username/Password entered is Incorrect or User doesnot Exists.");
bean.setValid(false);
}
else if (userExists)
{
String fullName = rs.getString("s_name");
System.out.println("Welcome " + fullName);
bean.setValid(true);
}
 
}
catch (Exception ex)
{
System.out.println("Log In failed: An Exception has occurred! " + ex);
}
return bean;
}
}
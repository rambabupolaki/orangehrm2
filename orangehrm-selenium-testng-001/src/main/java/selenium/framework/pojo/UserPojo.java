package selenium.framework.pojo;
import selenium.framework.common.CommonMethods;
public class UserPojo extends CommonMethods
{
String userRole;
String employeeName;
String userName;
String status;
String password;
String confirmPassword;


/*//Data for User Role
public String getUserRole() {
	if (this.userRole == null) {
		userRole = "ESS";
	}
	return userRole;
}*/
/*public void setUserRole(String employeeName) {
	this.employeeName = employeeName;
}*/

//Data for Employee Name field
public String getEmployeeName() {
	if (this.employeeName == null) {
		employeeName = "F";
		
	}
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}


//Data for User Name field
public String getUserName()
{
	if(this.userName==null)
	{
		userName=randomUesrNameGenerator();
	}
	return userName;
}
public void setUserName(String userName)
{
	this.userName= userName;
}

/*//Data for Status
public String getStatus()
{
	if(status==null)
	{
		this.status="Enabled";
	}
	return status;
}
public void setStatus(String status)
{
	this.status=status;
}*/

//Data for Password
public String getPassword()
{
	if(password==null)
	{
		this.password="Anusha@123";
	}
	return password;
}
public void setPassword(String password)
{
	this.password=password;
}

//Data for Confirm password
public String getConfirmPassword()
{
	if(confirmPassword==null)
	{
		this.confirmPassword="Anusha@123";
	}
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword)
{
	this.confirmPassword=confirmPassword;
}

}

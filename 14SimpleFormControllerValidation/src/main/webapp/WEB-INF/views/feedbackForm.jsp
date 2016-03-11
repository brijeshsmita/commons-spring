<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback Page</title>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
</head>
<body>

<form:form method="POST" commandName="user">
	<table>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email" cssClass="error" /></td>	
		</tr>	
		<tr>
			<td>Profession:</td>
			<td><form:radiobutton path="profession" value="Student" 
					label="Student" /> 
				<form:radiobutton path="profession" value="Programmer" 
					label="Programmer" />
				</td>
			<td><form:errors path="profession" cssClass="error" /></td>
		</tr>			
		<tr>
			<td>Country :</td>
			<td><form:select path="country">
				<form:option value="select" label="Select" />
				<form:option value="India" label="India" />
				<form:option value="United States" label="United States" />
				<form:option value="United Kingdom" label="United Kingdom" />
				<form:option value="Europe" label="Europe" />
				<form:option value="Canada" label="Canada" />
			</form:select></td>
			<td><form:errors path="country" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Feedback:</td>
			<td><form:textarea path="feedback" /></td>
			<td><form:errors path="feedback" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Frameworks:</td>
			<td>
				<form:checkbox path="frameworks" value="Spring" 
					label="Spring" /> 
				<form:checkbox path="frameworks" value="Hibernate" 
					label="Hibernate" />
				<form:checkbox path="frameworks" value="Struts" 
					label="Struts" />
				<form:checkbox path="frameworks" value="Dojo" 
					label="Dojo" />
			</td>
			<td><form:errors path="frameworks" cssClass="error" /></td>
		</tr>
		<tr>
			<td></td>
			<td><form:checkbox path="mailingList"
				label="Would you like to join our mailinglist?" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="submit"></td>
		</tr>
	</table>
</form:form>

</body>
</html>
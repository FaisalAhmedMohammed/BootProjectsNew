<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<title>User Form</title>
</head>
<body>

	<form:form action="./register" method="post" modelAttribute="user">

		<table>
			<tr>
				<td>User Name :</td>
				<td><form:input path="username" /></td>
				<td><font color='red'></font> <form:errors path="username" /></td>
			</tr>

			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
				<td><font color='red'> <form:errors path="email">
						</form:errors></font></td>
			</tr>

			<tr>
				<td>Mobile :</td>
				<td><form:input path="mobile" /></td>
				<td><font color='red'> <form:errors path="mobile"></form:errors></font></td>
			</tr>

			<tr>
				<td>Gender :</td>
				<td><form:radiobutton path="gender" value="Male" /> Male <form:radiobutton
						path="gender" value="Female" /> Female</td>
				<td><font color='red'> <form:errors path="gender"></form:errors></font></td>
			</tr>
			<tr>
				<td>Date Of Birth :</td>
				<td><form:input type="date" path="dob" /></td>
				<td><font color='red'> <form:errors path="dob">
						</form:errors>
				</font></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>

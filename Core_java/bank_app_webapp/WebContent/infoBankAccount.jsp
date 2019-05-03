<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="UpdateAccount.do" method="post">


		Account number:<br>
		<input type="text" name="accountId" value="${account.accountId}"
			readonly="readonly">
		<div class="form-group">
			<label for="exampleInputPassword1">CustomerName</label> <input
				type="text" class="form-control" name="customer_name" 
				value="${account.accountHolderName}">
		</div>
		<div class="container">
			<h3>AccountType</h3>
			<select name="accountType">
				<option value="select"></option>
				<option value="Saving">SAVING</option>
				<option value="CURRENT">CURRENT</option>

			</select>
		</div>
		<label for="Balance">AccountBalance</label> <input type="text"
			class="form-control" name="accountBalance"
			value="${account.accountBalance}" readonly="readonly">

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>
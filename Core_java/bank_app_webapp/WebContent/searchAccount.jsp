<%@ page isELIgnored="false"%> 
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: left;
}
</style>
</head>
<body>

	<h2>Bank Details</h2>


	<table style="width: 100%">
		<caption>Bank Account details</caption>
		<col>
		<thead>
			<tr>
				<th> account_id</th>
				<th>customer_name</th>
				<th>account_type</th>
				<th>account_balance</th>
			</tr>
		</thead>
		<tbody>
			
				<tr>

					<td>${account.accountId}</td>
					<td>${account.accountHolderName}</td>
					<td>${account.accountType}</td>
					<td>${account.accountBalance}</td>
				</tr>
		

		</tbody>
	</table>

</body>
</html>


	
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		</center>
		<h1>Conversion of Currency</h1>
		<thead>
			<tr>
				<th>rupees</th>
				<th>dollars</th>
			</tr>
		</thead>
		</tbody>
		<c:forEach var="i" begin="1" end="50" step="1">
			<tr>
				<td>${i}</td>
				<td>${i*45}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
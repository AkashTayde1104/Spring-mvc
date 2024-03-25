<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function withdraw()
{
	{
		window.location.search;
		document.my_form.action="withdraw";
		document.my_form.submit();
	}
}

</script>
<meta charset="ISO-8859-1">
<title>Withdraw Money</title>
</head>
<body style="text-align:center; background-color: lightyellow">
<form name="my_form">
<pre>
<h2>

<input type="button" value="Go back !" style="background-color: lightgreen" onclick="history.back()">
<input type="hidden" name="a_Num" value="${a_Num}">
<input type="hidden" name="a_Name" value="${a_Name}">
<input type="hidden" name="acc_Type" value="${acc_Type}">
<input type="hidden" name="amt" value="${amount}">


Enter Withdrawal Money  : <input type="text" name="a_DepositMoney">

Enter Pin               : <input type="password" name="pin">

<input type="button" value="Withdraw" style="background-color:skyblue" onclick="withdraw()">
</h2>
</pre>
</form>
</body>
</html>
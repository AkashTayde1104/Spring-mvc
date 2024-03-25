<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.tech.model.Account" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function info()
{
	window.location.search;//transfer hiden data to url and through url access data in controller
	document.myform.action="info";// map in controller /info.........
	document.myform.submit();     //when submit action goes to controller perfrom all  backend oper on onclick button
}

function balance()
{
	window.location.search;
	document.myform.action="before_balance";
	document.myform.submit();
}
	
function deposit()
{
	window.location.search;
   document.myform.action="before_deposit";
   document.myform.submit();
}

function withdraw()
{
	window.location.search;
	document.myform.action="before_withdraw";
	document.myform.submit();
}

function transaction()
{
	   window.location.search;
	   document.myform.action="before_transfer";
	   document.myform.submit();
	
}

function pin()
{
	   window.location.search;
	   document.myform.action="before_pin";
	   document.myform.submit();
	
}
function logout()
{
	document.myform.action="index.jsp";
	document.myform.submit();
	}
</script>
<meta charset="ISO-8859-1">
<title>Operation Page</title>
</head>
<body >
<form name="myform">
<h1 >
<marquee direction="left" style="color:blue" >Hello <font style="color:red ">${a_Name}</font>, Welcome To XXX Bank</marquee></h1>
<pre>
<input type="hidden" name="a_Num" value="${a_Num}">                                     
<input type="hidden" name="a_Name" value="${a_Name}">                                                                                     
<input type="hidden" name="acc_Type" value="${acc_Type}">
<input type="hidden" name="a_DepositMoney" value="${amount}">
<h1>
       <b>::</b><input type="button" value="Account Info" onclick="info()"> <!-- onclick goes to function info() above -->              

       <b>::</b><input type="button" value="Balance Enquiry" onclick="balance()">   

       <b>::</b><input type="button" value="Withdraw" onclick="withdraw()">        &nbsp;&emsp;      <span style="color:red">${ope_msg}</span>
             
       <b>::</b><input type="button" value="Deposit" onclick="deposit()">
              
       <b>::</b><input type="button" value="Transaction" onclick="transaction()">
             
       <b>::</b><input type="button" value="Pin Change" onclick="pin()">    
                                                        <input type="button" value="LOGOUT" style="background-color: red" onclick="logout()">
             
             
            
                                                                       
</h1>
</pre>
</form>

</body>
</html>
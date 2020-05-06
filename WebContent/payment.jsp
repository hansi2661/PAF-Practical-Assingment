<%@ page import="model.Payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
	if (request.getParameter("payType") != null) {
	Payment itemObj = new Payment();
	String stsMsg = "";
	//Insert payments----------------------------------  
	if (request.getParameter("hidPayIDSave") == "") {

		stsMsg = itemObj.insertPay(request.getParameter("payType"), request.getParameter("payAmount"),
		request.getParameter("payDate"), request.getParameter("payEmail"), request.getParameter("payDesc")

		);

	}

	else//update

	{

		stsMsg = itemObj.updatePay(request.getParameter("hidPayIDSave"), request.getParameter("payType"),
		request.getParameter("payAmount"), request.getParameter("payDate"), request.getParameter("payEmail"),
		request.getParameter("payDesc")

		);
	}
	session.setAttribute("statusMsg", stsMsg);

}

//Delete item----------------------------------  
if (request.getParameter("hidPayIDDelete") != null) {
	Payment itemObj = new Payment();
	String stsMsg = itemObj.deletePay(request.getParameter("hidPayIDDelete"));
	session.setAttribute("statusMsg", stsMsg);
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/payment.js"></script>

</head>
<body >
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<!-- 	payID,payType,payAmount,payDate,payEmail,PayDesc -->

				<h1>Payment Mgt System</h1>

				<form id="formPayment" name="formPayment" action="payment.jsp"
					method="post">
					Type:<input placeholder="Enter Card Type.Ex:VISA" type="text"
						id="payType" name="payType" class="form-control"><br>
					Amount:<input placeholder="Enter Amount of Pay" type="text"
						id="payAmount" name="payAmount" class="form-control"><br>
					Date:<input placeholder="YYYY-MM-DD" type="text" id="payDate"
						name="payDate" class="form-control"><br> Email:<input
						placeholder="Enter Your Email Address" type="text" id="payEmail"
						name="payEmail" class="form-control"><br>
					Description:<input placeholder="Write down anything" type="text"
						id="payDesc" name="payDesc" class="form-control"><br>
					<input type="submit" id="btnSave" name="btnSubmit" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidPayIDSave" name="hidPayIDSave" value="">
				</form>

				<br>


				<div class="alert alert-success">
					<%
						out.print(session.getAttribute("statusMsg"));
					%>

				</div>

				<br>
				<%
					Payment itemObj = new Payment();
				out.print(itemObj.readPay());
				%>



			</div>
			<div class="col-sm-2"></div>





		</div>
	</div>

</body>
</html>
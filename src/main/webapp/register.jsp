<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>

<style>
.red {
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<div class="text-center">
			<h1>Sign Up</h1>
		</div>

		<div class="red" id="error"></div>
		<form class="form" action="register" method="post">
			<div class="row">
				<div class="col-sm-6">
					<h3>Username</h3>
					<div class="mb-3">
						<label for="username" class="form-label">Username<span
							class="red">*</span></label> <input type="text" class="form-control"
							id="username" name="username" required="required">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password<span
							class="red">*</span></label> <input type="password" class="form-control"
							id="password" name="password" required="required"
							onkeyup="checkPass()">
					</div>
					<div class="mb-3">
						<label for="repass" class="form-label">Re-Password <span
							class="red">*</span> <span id="msg" class="red"></span>
						</label> <input type="password" class="form-control" id="repass"
							name="repass" required="required" onkeyup="checkPass()">
					</div>
					<hr />
					<h3>Customer Information</h3>
					<div class="mb-3">
						<label for="fullname" class="form-label">Full Name</label> <input
							type="text" class="form-control" id="fullname" name="fullname">
					</div>
					<div class="mb-3">
						<label for="sex" class="form-label">Sex</label> <select
							class="form-control" id="sex" name="sex">
							<option></option>
							<option value="male">Male</option>
							<option value="Female">Female</option>
							<option value="sceret">Sceret</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="dayofbirth" class="form-label">Day Of Birth</label> <input
							type="date" class="form-control" id="dayofbirth"
							name="dayofbirth">
					</div>
				</div>
				<div class="col-sm-6">
					<h3>Address</h3>
					<div class="mb-3">
						<label for="address" class="form-label"> Customer Address
						</label> <input type="text" class="form-control" id="address"
							name="address">
					</div>
					<div class="mb-3">
						<label for="deliveryaddress" class="form-label">Delivery
							Address</label> <input type="text" class="form-control"
							id="deliveryaddress" name="deliveryaddress">
					</div>
					<div class="mb-3">
						<label for="invoiceAddress" class="form-label">Invoice
							Address</label> <input type="text" class="form-control"
							id="invoiceAddress" name="invoiceAddress">
					</div>
					<div class="mb-3">
						<label for="phone" class="form-label">Phone Number</label> <input
							type="tel" class="form-control" id="phone" name="ohone">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email">
					</div>
					<hr />
					<div class="mb-3">
						<label for="check" class="form-label">Agree to the <a href="#">terms</a><span
							class="red">*</span>
						</label> <input type="checkbox" class="form-check-input" id="check"
							name="check" required="required" onchange="handleConfirm()">
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Sign Up" name="submit" id="submit"
						style="visibility: hidden;" />
				</div>
			</div>
		</form>
	</div>
</body>

<script>
	function checkPass() {
		var pass = document.getElementById("password").value;
		var repass = document.getElementById("repass").value;

		if (pass != repass) {
			document.getElementById("msg").innerHTML = "Passwords do not same!"
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}

	  function handleConfirm() {
          var checkbox = document.getElementById("check");
          if (checkbox.checked) {
              document.getElementById("submit").style.visibility = "visible";
          } else {
              document.getElementById("submit").style.visibility = "hidden";
          }
      }
</script>
</html>
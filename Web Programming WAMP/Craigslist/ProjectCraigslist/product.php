<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Craigs List</title>
		<link href="css/main.css" rel="stylesheet">
		<link href="css/custom.css" rel="stylesheet">
		<link rel="icon" href="images/logo.jpg" type="image/gif">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="js/main.js"></script>
	</head>

	<body>
	
	<?php session_start();?>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
					<?php if (isset($_SESSION['user_id'])) echo '<a class="navbar-brand" href="index2.html">Criags List</a>';
						else echo '<a class="navbar-brand" href="index.html">Criags List</a>';?>
			</div>
		<!--<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index2.html">Home</a></li>
					<?php if (isset($_SESSION['user_id']))
						  { echo '<li><a href="sellProduct.html">Sell Product</a></li>
								<li><a href="cart.html">Go To Cart</a></li>
								<li><a href="log_status.php">Logout</a></li>';
							}
						else
						 {	echo '<li><a href="register.html">Create Account</a></li>';
						 }
					?>								
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div><!--/.navbar -->
	
	<div class="container">
		<div class="row">
		
			<div class="col-md-4">
				<div class="panel panel-default panel-list">
					<div class="panel-heading panel-heading-dark">
						<h3 class="panel-title">Menu Options</h3>
					</div>
					<!-- List group -->
					<ul class="list-group">
						<?php if (isset($_SESSION['user_id'])) 
								{echo '<li class="list-group-item"><a href="index2.html">Home</a></li>
								<li class="list-group-item"><a href="sellProduct.html">Sell Product</a></li>
								<li class="list-group-item"><a href="cart.html">Go To Cart</a></li>
								<li class="list-group-item"><a href="log_status.php">Logout</a></li>';
								}
							  else
							  {echo '<li class="list-group-item"><a href="index2.html">Home</a></li>
									<li class="list-group-item"><a href="register.html">Create Account</a></li>';
							  }
						?>
					</ul>
				</div>			
			</div>

			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading panel-heading-green">
						<h3 class="panel-title">Criags List</h3>
					</div>
					<div class="panel-body">
						<div class="row details">
							<div class="col-md-4">
								<img src="images/<?php if(isset($_GET['img_name'])) echo $_GET['img_name']; else echo'image not available';?>" />
							</div>
							<div class="col-md-8">
								<h3><?php if(isset($_GET['title'])) echo $_GET['title']; else echo'Title not available';?></h3>
								<div class="details-price">
									Price: $<?php if(isset($_GET['price'])) echo $_GET['price']; else echo '0.0(NA)';?>
								</div>
								<div class="details-description">
									<?php if(isset($_GET['desc'])) echo $_GET['desc']; else echo'Description Unavailable';?>
								</div>
								<div class="details-description">
									<b>Seller Name:</b>
									<?php if(isset($_GET['name'])) echo $_GET['name']; else echo'Description Unavailable';?>
								</div>
								<div class="details-description">
									<b>Seller Email:</b>
									<?php if(isset($_GET['email'])) echo $_GET['email']; else echo'Description Unavailable';?>
								</div>
								<div class="details-description">
									<b>Seller Contact number:</b>
									<?php if(isset($_GET['phone'])) echo $_GET['phone']; else echo'Description Unavailable';?>
								</div>
								
								<br/><br/>
								<br/><br/>
								<br/><br/>
								<br/><br/>
								<br/><br/>
							</div><!--col-md-4-->
						</div><!-- /.row details-->
					</div><!-- /.panelbody -->
				</div><!-- /.panel -->
			</div><!-- /.col-md-8 -->
		
		</div><!-- /.row -->
	</div><!-- /.container -->

	<div class="row footer">
		<div class="container">
			<p>Criags List &copy; 2015, All Rights Reserved</p>
		</div>
	</div>
   
  </body>
</html>

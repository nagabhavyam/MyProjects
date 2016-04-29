<?php 
	session_start();
	
	$folder_name = "Misc";
	switch (intval($_POST['p_category'])) {
		case 8:
			$folder_name = "AutoMobiles";
			break;
		case 9:
			$folder_name = "Electronics";
			break;
		case 10:
			$folder_name = "Furniture";
			break;
		case 11:
			$folder_name = "HomeApp";
			break;
		case 12:
			$folder_name = "Misc";
			break;
	}
	$titleErr =""; $priceErr ="";$descErr ="";$nameErr ="";$phoneErr ="";$phonerr ="";$emailErr ="";$imgErr ="";$commonErr ="";
		
	if (empty($_POST['p_title']))  
	{$titleErr = 'Enter the title';
	return require 'sellProduct.html';
	//echo ' <h4>Please enter the title</h4>';
	//echo '<br/>';
	}
	else if(empty($_POST['p_cost']))
	{$priceErr = 'Enter the product cost';
	return require 'sellProduct.html';
	//echo ' <h4>Please enter the product cost</h4>';
	//echo '<br/>';
	}
	else if(empty($_POST['p_details']))
	{$descErr = 'Enter the product description';
	return require 'sellProduct.html';
	//echo ' <h4>Please enter the product details</h4>';
	//echo '<br/>';
	}
	else if(empty($_POST['p_owner']))
	{$nameErr = 'Enter the seller name';
	return require 'sellProduct.html';
	//echo ' <h4>Please enter the seller name</h4>';
	//echo '<br/>';
	}
	else if(empty($_POST['p_phone']))
	{$phoneErr = 'Enter phone number';
	return require 'sellProduct.html';
	//echo ' <h4>Please enter the seller phone</h4>';
	//echo '<br/>';
	}
	else if(empty($_POST['p_email']))
	{$emailErr = 'Enter seller`s email';
	return require 'sellProduct.html';
	//echo ' <h4>Please enter the seller email</h4>';
	//echo '<br/>';
	}
	else if(!isset($_SESSION['user_id']))
	{$submitErr = 'Please login to continue';
	return require 'sellProduct.html';
	//echo ' <h4>Please login and continue </h4>';
	//echo '<br/>';
	}	
	else if(!isImageValid($folder_name))
	{$imgErr = 'Please add a valid image';
	return require 'sellProduct.html';
	//echo ' <h4>Please add a valid image</h4>';
	//echo '<br/>';
	}
	else
	{
		//user, password, and database variables 
		$db_user = "root"; 
		$db_password = '';     
		$db_dbname = 'craigslist'; 
		$db_server='localhost';

		//connect to the database server 
		$db = new mysqli($db_server, $db_user, $db_password, $db_dbname); 
		if (!$db) { 
		   die('Could Not Connect: ' . mysql_error()); 
		} 

		$p_title= $_POST['p_title'];
		$p_cost= $_POST['p_cost'];
		$p_category= $_POST['p_category'];
		$p_details= $_POST['p_details'];
		$p_image= $folder_name.'/'.basename($_FILES["p_image"]["name"],".jpg");
		$p_owner= $_POST['p_owner'];
		$p_phone= $_POST['p_phone'];
		$p_email= $_POST['p_email'];
		$user_id=$_SESSION['user_id'];

		$isActive=1;

		//run query and output results 
		 $sql = "INSERT INTO product (title, user_id, email, category, price, img_desc, phone, prod_desc, name, sold_flag)
									VALUES('" . $p_title . "','" . $user_id . "','" . $p_email . "'," . $p_category . ", " . $p_cost . ",'" . $p_image . "','" . $p_phone . "','" . $p_details . "','" . $p_owner . "','N');";
									
			if ($db->query($sql) === TRUE) {
				
				$sql_history = "Insert into producthistory (user_id) values ('" . $user_id . "')";
				$db->query($sql_history);
				echo "New record created successfully";
			
			} else {
			echo "Error: " . $sql . "<br>" . $conn->error;
			}

		$db->close();
		header('Location: cart.html');
	}

	function isImageValid($folder_name)
	{	
		$target_dir = "images/".$folder_name."/";
		$target_file = $target_dir . basename($_FILES["p_image"]["name"]);
		$uploadOk = 1;
		$imageFileType = pathinfo($target_file,PATHINFO_EXTENSION);
		
		if(empty(basename($_FILES["p_image"]["name"])))
		{	echo "Filename cannot be blank.";
			$uploadOk = 0;
		}
		else if(!getimagesize($_FILES["p_image"]["tmp_name"])) {
			// Check if image file is a actual image or fake image
			echo "File is not an image.";
			$uploadOk = 0;
		} 
		else if (file_exists($target_file)) {
			// Check if file already exists
			echo "Sorry, file already exists.";
			$uploadOk = 0;
		}
		
		else if ($_FILES['p_image']["size"] > 500000) {
			// Check file size
			echo "Sorry, your file is too large.";
			$uploadOk = 0;
		}
		
		else if($imageFileType != "jpg") {
			// Allow certain file formats
			echo "Sorry, only JPG, JPEG files are allowed.";
			$uploadOk = 0;
		}
		// Check if $uploadOk is set to 0 by an error
		if ($uploadOk == 0) {
			echo "Your file was not uploaded.";
		// if everything is ok, try to upload file
		} else {
			if (move_uploaded_file($_FILES['p_image']["tmp_name"], $target_file)) 
			{ $uploadOk =1;
				//echo "The file ". basename( $_FILES['p_image']["name"]). " has been uploaded.";
			} else 
			{$uploadOk =0;
				echo "Sorry, there was an error uploading your file.";
			}
		}
		return $uploadOk;
	}
?>
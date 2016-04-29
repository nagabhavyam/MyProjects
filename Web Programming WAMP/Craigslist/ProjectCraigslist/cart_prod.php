<?php
	session_start();

	$db_user = "root"; 
	$db_password = '';     
	$db_dbname = 'craigslist'; 
	$db_server='localhost';

	//connect to the database server 
	$db = new mysqli($db_server, $db_user, $db_password, $db_dbname);  
	if (!$db) { 
	   die('Could Not Connect: ' . mysql_error()); 
	} 

	//select database name 
	//mysql_select_db($db_dbname) or die (mysql_error());
	if(isset($_SESSION['user_id']))
	{	$user_id=$_SESSION['user_id'];
		$count=0;
		$subtotal=0;
		$shipping=4.99;
			
		$select_query = "select prod_id, title, price, sold_flag from product where user_id='$user_id';";
		$result = $db->query($select_query);  
		$num_rows = mysqli_num_rows($result);
		
		if($num_rows == 0)
			echo '<tr> <td>There are no items in the cart</td> </tr>';
		else
		{
			while($row = $result->fetch_assoc()) 
			{ 			
				$prod_id=$row['prod_id'];
				$title=$row['title'];
				$price= $row['price'];
				$sold_flag= $row['sold_flag'];
				$count=$count+1;
				echo '<tr>';
				echo '<td>'.$title .'</td> ';
				echo '<td>$'.$price.'</td>';
				if($sold_flag == "Y")
					echo '<td>Item Sold</td>';
				else
					echo '<td><input class="btn  btn-primary" type="button" name="update" id="update" value="Update to sold" onclick="update_cart('.$row['prod_id'].');"></td>';
				echo '</tr>';
			}
		}
	}
	$db->close();
?>
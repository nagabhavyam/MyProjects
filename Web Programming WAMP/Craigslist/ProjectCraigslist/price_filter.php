<?php

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

//select database name 
//mysql_select_db($db_dbname) or die (mysql_error());
$st_pr=$_GET['start_pr']; 

//$st_pr=mysql_real_escape_string($st_pr);
$last_pr=$_GET['end_pr']; 

//$last_pr=mysql_real_escape_string($last_pr);
if ($st_pr == "" || $last_pr == "")
{
echo '<h3> No match found. Please provide the valid price range </h3>';
}
else
{
//run query and output results 
 
  //run a select query 
  $select_query = "select price,img_desc,title,prod_id,prod_desc,email,phone,name from product where price between '$st_pr' and '$last_pr' and sold_flag='N' "; 
  $result = $db->query($select_query);  
  $num_rows = mysqli_num_rows($result);
   echo'<div class="panel-heading panel-heading-green">';
	echo'<h3 class="panel-title"> <b>Price category: Between '.$st_pr.' and '.$last_pr.' </b></h3>';
	echo'</div>';
	echo '<br/><br/>';
	  if ($num_rows == 0)
	  echo '<h3> No match found </h3>';
	  else
	  {
while($row = $result->fetch_assoc()) 
  { 	
		$img_name=$row['img_desc'];
		$prod_id=$row['prod_id'];
		$price= $row['price'];
		$title=$row['title'];
		$desc=$row['prod_desc'];
		$email=$row['email'];
		$phone=$row['phone'];
		$name=$row['name'];
		echo '<div class="col-md-4 game">';
		echo '<div class="game-price">$'.$price.'</div>';
		echo '<a href="product.php?price='.$price.'&title='.$title.'&img_name='.$img_name.'.jpg'.'&prod_id='.$prod_id.'&desc='.$desc.'&email='.$email.'&phone='.$phone.'&name='.$name.'">';
		echo '<img  src="images/'.$img_name.'.jpg" width="175" height="200"/>';
		echo '</a>';
		echo '<div class="game-title">';
		echo $title;
		echo '</div>';
		echo '<div class="game-add">';
		//echo '<a class="btn btn-primary" onclick="cart('.$prod_id.')">Add To Cart</a>';
		echo '<br>';
		echo'</div>';
		echo'</div>';
	}		
  
  }  
  }
$db->close();
?>
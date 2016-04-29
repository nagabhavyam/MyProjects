
<?php 

//user, password, and database variables 
$db_user = "root"; 
$db_password = '';     
$db_dbname = 'craigslist'; 
$db_server='localhost';
/** 
* Run MySQL query and output  
* results in a HTML Table 
*/ 

//connect to the database server 
$db = new mysqli($db_server, $db_user, $db_password, $db_dbname); 
if (!$db) { 
   die('Could Not Connect: ' . mysql_error()); 
} 

//select database name 
//mysql_select_db($db_dbname) or die (mysql_error());
$cat=$_GET['category']; 


//$cat=mysql_real_escape_string($cat);

//run query and output results 
 if($cat == "0")
 {
	
 }
 else
 {
	  $cat_query ="select category_name from category where category_id='$cat'";
   $cat_res= $db->query($cat_query);
   $cat_name=$cat_res->fetch_assoc();
 }
  
  //run a select query 
  if($cat == "0")
 {
	$select_query = "select price,img_desc,title,prod_id,prod_desc,email,phone,name from product where sold_flag='N' order by prod_id"; 
 }
 else
 {
	 $select_query = "select price,img_desc,title,prod_id,prod_desc,email,phone,name from product where category='$cat' and sold_flag='N' order by prod_id"; 
 }
  
  $result = $db->query($select_query);
   echo'<div class="panel-heading panel-heading-green">';
    if($cat == "0")
	{
		echo'<h3 class="panel-title"> <b>All Products</b></h3>';
	}
	else
	{
	echo'<h3 class="panel-title"> <b>'.$cat_name['category_name'].'</b></h3>';
	}
	echo'</div>';
	echo '<br/><br/>';
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
		echo '<a href="product.php?price='.$price.'&title='.$title.'&img_name='.$img_name.'.jpg'.'&prod_id='.$prod_id.'&desc='.$desc.'&email='.$email.'&phone='.$phone.'&name='.$name.'" onclick="history_add('.$prod_id.')">';
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
  //output data in a table 
  
//close database connection 
$db->close();

?> 

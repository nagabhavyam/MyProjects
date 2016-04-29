<?php
session_start();
//print_r($_SESSION);
//echo '<tr> <td>im inside cart_prod php file</td> </tr>';

$db_user = "root"; 
$db_password = '';     
$db_dbname = 'craigslist'; 
$db_server='localhost';

//connect to the database server 
$db = mysql_connect($db_server, $db_user, $db_password); 
if (!$db) { 
   die('Could Not Connect: ' . mysql_error()); 
} 

 
//select database name 
mysql_select_db($db_dbname) or die (mysql_error());
$user_id=$_SESSION['user_id'];
$add1=$_GET['add1'];
$add2=$_GET['add2'];
$city=$_GET['city'];
$state=$_GET['state'];
$zip=$_GET['zip'];

  $cart_query ="select cart_id,user_id from cart where user_id='$user_id' and isActive=1";
   $cart_res= mysql_query($cart_query) or die (mysql_error());
   $cart_row=mysql_fetch_array($cart_res);
   $cart_id=$cart_row['cart_id'];

    $check_query ="select cart_id from checkout where cart_id='$cart_id'";
   $check_res= mysql_query($check_query) or die (mysql_error());
    $num_rows = mysql_num_rows($check_res);
   if ($num_rows==0)
   {
   
if(mysql_query("insert into checkout (cart_id,addr,addr_2,city,state,zip,order_status) values ('$cart_id','$add1','$add2', '$city','$state',$zip,1);"))
{
echo "<tr><td>You have successfully checkout :)</td></tr>";

   $cart_up_query="update cart set isActive=0 where cart_id='$cart_id'";
  if( mysql_query($cart_up_query) or die (mysql_error()))
   echo '<tr> <td> updated cart activation</td> </tr>';

}
}




?>
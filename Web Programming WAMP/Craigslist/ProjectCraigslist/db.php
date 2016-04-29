<?php


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

?>
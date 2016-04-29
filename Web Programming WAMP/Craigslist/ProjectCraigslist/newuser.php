
<?php 
if (!isset($_GET['fname']))  
{echo ' Please provide your First name';
echo '<br/>';}
else if (!isset($_GET['phone']))  
{echo ' Please provide your Last name';
echo '<br/>';}
else if (!isset($_GET['email']))  
{echo ' Please provide your Email Address';
echo '<br/>';}
else if (!isset($_GET['username']))  
{echo ' Please provide your Username to be used for login';
echo '<br/>';}
else if (!isset($_GET['pwd']))  
{echo ' Please provide your Password to be used for login';
echo '<br/>';
}
else
{

$db_user = "root"; 
$db_password = '';     
$db_dbname = 'craigslist'; 
$db_server='localhost';
/** 
* Run MySQL query and output  
* results in a HTML Table 
*/ 

//connect to the database server 
$db = mysql_connect($db_server, $db_user, $db_password); 
if (!$db) { 
   die('Could Not Connect: ' . mysql_error()); 
} 

//select database name 
mysql_select_db($db_dbname) or die (mysql_error());
$fname=$_GET['fname'];
$phone=$_GET['phone'];
$email=$_GET['email'];
$username=$_GET['username'];
$pwd=$_GET['pwd'];
if(mysql_query("insert into user values('$fname','$phone','$email','$username','$pwd')"))
echo "<h2> Successfully added user</h2>";
else
echo "<h2>Insertion Failed</h2>";
}
mysql_close($db) 

?> 

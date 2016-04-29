<!-- if you need user information, just put them into the $_SESSION variable and output them here -->
<?php 

echo str_replace('</head>', '<script type="text/javascript" src="js/another_script.js"></script></head>', '</head><META http-equiv="refresh" content="5;URL=http://localhost/ProjectCraigslist/index2.html">
</head>')

?>

Hey, <?php echo $_SESSION['user_id']; ?>. You are logged in. Redirecting you back.

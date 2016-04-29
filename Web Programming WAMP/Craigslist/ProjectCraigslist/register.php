<?php

	define("DB_HOST", "localhost");
	define("DB_NAME", "craigslist");
	define("DB_USER", "root");
	define("DB_PASS", "");
	
	class Registration
	{

		private $db_connection = null;

		public $errors = array();

		public $messages = array();


		public function __construct()
		{
			if (isset($_POST["register"])) {
				$this->registerNewUser();
			}
		}


		private function registerNewUser()
		{	$unameErr =""; $fnameErr =""; $phoneErr ="";$pwdErr =""; $cpwdErr ="";$emailErr ="";$commonErr ="";
			if (empty($_POST['user_name'])) {
				$unameErr = "Empty Username"; return require 'register.html';
			}elseif (empty($_POST['user_fname'])) {
				$fnameErr  = "Empty first name";return require 'register.html';
			}elseif (empty($_POST['phone'])) {
				$phoneErr  = "Empty Phone Number"; return require 'register.html';
			} elseif (empty($_POST['user_password_new']) || empty($_POST['user_password_repeat'])) {
				$pwdErr = "Empty Password"; return require 'register.html';
			} elseif ($_POST['user_password_new'] !== $_POST['user_password_repeat']) {
				$cpwdErr = "Passwords are not the same"; return require 'register.html';
			} elseif (strlen($_POST['user_password_new']) < 6) {
				$pwdErr = "Password has a minimum length of 6 characters"; return require 'register.html';
			} elseif (strlen($_POST['user_name']) > 64 || strlen($_POST['user_name']) < 2) {
				$unameErr = "Username cannot be shorter than 2 or longer than 64 characters";return require 'register.html';
			} elseif (!preg_match('/^[a-z\d]{2,64}$/i', $_POST['user_name'])) {
				$unameErr = "Username does not fit the name scheme: only a-Z and numbers are allowed, 2 to 64 characters";return require 'register.html';
			} elseif (empty($_POST['user_email'])) {
				$emailErr = "Email cannot be empty"; return require 'register.html';
			} elseif (strlen($_POST['user_email']) > 64) {
				$emailErr = "Email cannot be longer than 64 characters"; return require 'register.html';
			} elseif (!filter_var($_POST['user_email'], FILTER_VALIDATE_EMAIL)) {
				$emailErr = "Your email address is not in a valid email format"; return require 'register.html';
			} elseif (!empty($_POST['user_name'])
				&& strlen($_POST['user_name']) <= 64
				&& strlen($_POST['user_name']) >= 2
				&& preg_match('/^[a-z\d]{2,64}$/i', $_POST['user_name'])
				&& !empty($_POST['user_email'])
				&& !empty($_POST['user_fname'])
				&& !empty($_POST['phone'])
				&& strlen($_POST['user_email']) <= 64
				&& filter_var($_POST['user_email'], FILTER_VALIDATE_EMAIL)
				&& !empty($_POST['user_password_new'])
				&& !empty($_POST['user_password_repeat'])
				&& ($_POST['user_password_new'] === $_POST['user_password_repeat'])
			) {
				// create a database connection
				$this->db_connection = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

				// change character set to utf8 and check it
				if (!$this->db_connection->set_charset("utf8")) {
					$commonErr = $this->db_connection->error;return require 'register.html';
				}

				// if no connection errors (= working database connection)
				if (!$this->db_connection->connect_errno) 
				{

					$user_id = $this->db_connection->real_escape_string(strip_tags($_POST['user_name'], ENT_QUOTES));
					$user_fname = $this->db_connection->real_escape_string(strip_tags($_POST['user_fname'], ENT_QUOTES));
					$phone = $this->db_connection->real_escape_string(strip_tags($_POST['phone'], ENT_QUOTES));
					$user_email = $this->db_connection->real_escape_string(strip_tags($_POST['user_email'], ENT_QUOTES));

					$user_password = $_POST['user_password_new'];


					$user_password_hash = password_hash($user_password, PASSWORD_DEFAULT);

					// check if user or email address already exists
					$sql = "SELECT * FROM user WHERE user_id = '" . $user_id . "' OR user_email = '" . $user_email . "';";
					$query_check_user_name = $this->db_connection->query($sql);
					
					
					if ($query_check_user_name!=false) {
						
						$commonErr = "Sorry, that username / email address is already taken.";return require 'register.html';
						
					} else {
						// write new user's data into database
						
						$sql = "INSERT INTO user (email, user_fname, phone, user_id, user_password)
								VALUES('" . $user_email . "','" . $user_fname . "','" . $phone . "','" . $user_id . "', '" . $user_password_hash . "');";
						
						$query_new_user_insert = $this->db_connection->query($sql);
						

						// if user has been added successfully
						if ($query_new_user_insert) {
							$this->messages[] = "Your account has been created successfully. You can now log in.";
							
						} else {
							$commonErr  = "Sorry, your registration failed. Please go back and try again.";return require 'register.html';
						}
					}
				} else {
					$commonErr = "Sorry, no database connection.";return require 'register.html';
				}
			} else {
				$commonErr = "An unknown error occurred.";return require 'register.html';
			}
		}
	}
	
	$registration = new Registration();
	// show potential errors / feedback (from registration object)
	if (isset($registration)) {
		/*if ($registration->errors) {
			foreach ($registration->errors as $error) {
				echo $error;
				echo str_replace('</head>', '<script type="text/javascript" src="js/another_script.js"></script></head>', '</head><META http-equiv="refresh" content="5;URL=http://localhost/ProjectCraigslist/register.html"></head>');
			}
		}
		*/
		if ($registration->messages) {
			foreach ($registration->messages as $message) {
				echo $message;
				echo str_replace('</head>', '<script type="text/javascript" src="js/another_script.js"></script></head>', '</head><META http-equiv="refresh" content="5;URL=http://localhost/ProjectCraigslist/index.html"> </head>');
			}
		}
}

?>
<h1> Please wait while we redirect you </h1>

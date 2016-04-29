<?php

class Login
{
   
    private $db_connection = null;
    
    public $errors = array();
    
    public $messages = array();

    
    public function __construct()
    {
        
        session_start();

       
        if (isset($_GET["logout"])) {
            $this->doLogout();
        }
        
        elseif (isset($_POST["login"])) {
            $this->dologinWithPostData();
        }
    }

    
    private function dologinWithPostData()
    {
        // check login form contents
        if (empty($_POST['user_name'])) {
            $this->errors[] = "Username field was empty.";
        } elseif (empty($_POST['user_password'])) {
            $this->errors[] = "Password field was empty.";
        } elseif (!empty($_POST['user_name']) && !empty($_POST['user_password'])) {

            // create a database connection, using the constants from config/db.php (which we loaded in index.php)
            $this->db_connection = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

            // change character set to utf8 and check it
            if (!$this->db_connection->set_charset("utf8")) {
                $this->errors[] = $this->db_connection->error;
            }

            // if no connection errors (= working database connection)
            if (!$this->db_connection->connect_errno) {

                // escape the POST stuff
                $user_id = $this->db_connection->real_escape_string($_POST['user_name']);

                // database query, getting all the info of the selected user (allows login via email address in the
                // username field)
                $sql = "SELECT user_id, email, user_password
                        FROM user
                        WHERE user_id = '" . $user_id . "' OR email = '" . $user_id . "';";
                $result_of_login_check = $this->db_connection->query($sql);

                // if this user exists
                if ($result_of_login_check->num_rows == 1) {

                    // get result row (as an object)
                    $result_row = $result_of_login_check->fetch_object();

                    // using PHP 5.5's password_verify() function to check if the provided password fits
                    // the hash of that user's password
                    if (password_verify($_POST['user_password'], $result_row->user_password)) {

                        // write user data into PHP SESSION (a file on your server)
                        $_SESSION['user_id'] = $result_row->user_id;
                        $_SESSION['user_email'] = $result_row->email;
                        $_SESSION['user_login_status'] = 1;

                    } else {
                        echo "Wrong password. Try again.";
                    }
                } else {
                    $this->errors[] = $sql;
                }
            } else {
                $this->errors[] = "Database connection problem.";
            }
        }
    }

    public function doLogout()
    {

        $_SESSION = array();
        session_destroy();
        $this->messages[] = "You have been logged out.";

    }


    public function isUserLoggedIn()
    {
        if (isset($_SESSION['user_login_status']) AND $_SESSION['user_login_status'] == 1) {
            return true;
        }

        return false;
    }
}

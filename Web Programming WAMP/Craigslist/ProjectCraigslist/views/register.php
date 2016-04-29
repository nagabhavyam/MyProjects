<?php
// show potential errors / feedback (from registration object)
if (isset($registration)) {
    if ($registration->errors) {
        foreach ($registration->errors as $error) {
            echo $error;
            echo str_replace('</head>', '<script type="text/javascript" src="js/another_script.js"></script></head>', '</head><META http-equiv="refresh" content="5;URL=http://localhost/ProjectCraigslist/register.html"></head>');
        }
    }
    if ($registration->messages) {
        foreach ($registration->messages as $message) {
            echo $message;
            echo str_replace('</head>', '<script type="text/javascript" src="js/another_script.js"></script></head>', '</head><META http-equiv="refresh" content="5;URL=http://localhost/ProjectCraigslist/index.html"> </head>');
        }
    }
}
?>

<h1> Redirecting in 5 seconds </h1>
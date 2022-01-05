<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['username']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->update("users", $_POST['username'], $_POST['password'])) {
            echo "Update Success";
        } else echo "Update Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>

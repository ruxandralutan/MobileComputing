<?php
$servername = "myServerName";
$username = "myUserName";
$password = "myPassword";
$dbname = "myDBName";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}



$Name=$_POST['Name'];


$sql = "INSERT INTO phototable(name)
VALUES ('{$Name}')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?> 
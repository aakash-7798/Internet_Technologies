<?php

$fname = $_POST["fname"];
$lname = $_POST["lname"];
$email = $_POST["email"];
$username = $_POST["usernme"];
$psswd = md5($_POST["pswd"]);
$cnfrpsswd = md5($_POST["cfmpswd"]);
var_dump($fname,$lname,$email,$username,$psswd,$cnfrpsswd);

$localhost = "localhost:8111";
$mysql_username = "root";
$password = "";
$dbname = "aakash_schema";

$connection = mysqli_connect($localhost,$mysql_username,$password,$dbname);

if(mysqli_connect_error()){
    die("Connection Error : ".mysqli_connect_error());
}

echo "<br> Connection Successful <br>";

$sql = "Insert into registration_form(FirstName,LastName,Email,Username,Password,ConfirmPassword) values (?,?,?,?,?,?)";
$stmt = mysqli_stmt_init($connection);

if(!mysqli_stmt_prepare($stmt,$sql)){
    die(mysqli_error($connection));
}

mysqli_stmt_bind_param($stmt,'ssssss',$fname,$lname,$email,$username,$psswd,$cnfrpsswd);
mysqli_stmt_execute($stmt);
echo "Data Submitted Succesfully..."

?>

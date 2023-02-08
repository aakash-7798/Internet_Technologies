<?php

$fname = $_POST["fname"];
$lname = $_POST["lname"];
$email = $_POST["email"];
$username = $_POST["usernme"];
$psswd = md5($_POST["pswd"]);
$cnfrpsswd = md5($_POST["cfmpswd"]);

//var_dump($fname,$lname,$email,$username,$psswd,$cnfrpsswd);

$localhost = "localhost:8111";
$mysql_username = "root";
$password = "";
$dbname = "aakash_schema";

$connection = mysqli_connect($localhost,$mysql_username,$password,$dbname);

if(mysqli_connect_error()){
    die("Connection Error : ".mysqli_connect_error());
}


$sql = "Insert into registration_form(FirstName,LastName,Email,Username,Password,ConfirmPassword) values (?,?,?,?,?,?)";
$emailcheck = "Select * from registration_form where Email= '$email'";
$usernamecheck = "Select * from registration_form where Username = '$username'";

$emlqry = mysqli_query($connection,$emailcheck);
//echo mysqli_num_rows($emlqry)." <br> email/s are present in the database.<br>";

$usrnmeqry = mysqli_query($connection,$usernamecheck);


if(mysqli_num_rows($emlqry)!=0 && mysqli_num_rows($usrnmeqry)!=0){
    echo "<span class='alert alert-danger'>Email and Username both Exists..<br></span>";
}
else if (mysqli_num_rows($usrnmeqry)!=0){
    echo "Username Already Exists <br>";
}
else if(mysqli_num_rows($emlqry)!=0 ){
    echo "Email Already Exists <br> Try to Login ... <br>";
}
else{
    $stmt = mysqli_stmt_init($connection);

    if(!mysqli_stmt_prepare($stmt,$sql)){
        die(mysqli_error($connection));
    }
//    echo "<br> Connection Successful <br>";

    mysqli_stmt_bind_param($stmt,'ssssss',$fname,$lname,$email,$username,$psswd,$cnfrpsswd);
    mysqli_stmt_execute($stmt);
    echo "Data Submitted Succesfully...";
}



?>

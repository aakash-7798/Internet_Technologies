<?php
// Establish a connection to xampp server
// Change the below port number to the portnumber what you see when you start mysql in xampp
$server_name = "localhost:8111";
// The following are same for every xampp server by default;
$server_username = "root";
$server_password = "";

$database_name = "it_lab_php";
$table_name = "registration_form_data";

$connection = mysqli_connect($server_name,$server_username,$server_password,$database_name) ;

$password = md5($_POST["pswd"]);

$password_query = mysqli_query($connection,"select Password from {$table_name} where Password = '{$password}'");
$password_query_result = mysqli_fetch_all($password_query);

if($password_query_result[0][0]==$password){
    $data_query = mysqli_query($connection,"select * from {$table_name} where Password = '{$password}'");
    $data_query_result = mysqli_fetch_all($data_query);
    echo "<html><head><style> body{
background-image: url('online-book-shopping-in-india.jpg');
background-repeat: no-repeat;
background-size: cover;
font-family: 'Poppins',sans-serif;
 color:white;;
 font-size:20px; 
}
}</style>
</head>".
        "<br><br><br><center><h3>  MY PERSONAL INFORMATION  </h3></center><br>".
        "<center><p>"."<b>".
        "FirstName    = {$data_query_result[0][0]} <br><br>".
        "LastName     = {$data_query_result[0][1] }<br><br>".
        "Email       = {$data_query_result[0][2]}<br><br>".
        "Gender      = {$data_query_result[0][3]}<br><br>".
        "LoginID     = {$data_query_result[0][4]}<br><br>".
        "Password    = {$data_query_result[0][5]}<br><br>".
        "Contact     = {$data_query_result[0][6]}<br><br>".
        "Address     = {$data_query_result[0][7]}</p></b></center>";
//    print_r($data_query_result);
}
else{
    echo"<br><br> <center><h1>ATTEMPT UNSUCCESSFULL  <span style='color: red; font-size:30px'>&#x274C;</span></h1></center> ".
        "<br><br><center><h3>INVALID PASSWORD !!!!....</h3></center>".
        "<center><h4>ENTER YOUR PASSWORD AGAIN</h4> <p style='font-size: 40px;'> &#128542; </p> </h4>".
        "<br><br><a href='profile.html'><input type='submit' value='TRY AGAIN'></a> </center>";
}


//print_r($password_query_result);

//$data_query = mysqli_query($connection,"select * from {$table_name}");
//$data_query_result = mysqli_fetch_all($data_query);
//print_r($data_query_result);
?>
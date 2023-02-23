<?php

//  To post the values create a variable
//  then extract the value by considering form name
// of that parameter.
//  check names in the html file (name what I have given for this file will be same for html file)
//
//$Firstname = $_POST["fname"];
//$Lastname = $_POST["lname"];
//$email = $_POST["email"];
//$gender = $_POST["gender"];
//$loginid = $_POST["lgnid"];
////Converting the password to md5 hasing algorithm
//$password = md5($_POST["pswd"]);
//$contact = $_POST["phno"];
//$address = $_POST["address"];

// Establish a connection to xampp server
// Change the below port number to the portnumber what you see when you start mysql in xampp
$server_name = "localhost:8111";
// The following are same for every xampp server by default;
$server_username = "root";
$server_password = "";

// I create a database and create table and send data to server
$database_name = "it_lab_php";
$table_name = "registration_form_data";

$connection = mysqli_connect($server_name,$server_username,$server_password) ;
//echo "Successfully connected";

//$use_database = mysqli_query($connection,"use datab")


//function my_query($con,$qry){
//    return mysqli_query($con,$qry);
//}

function fn_database_check($databases,$db_name){
    $db_exists=false;
    for($x=0;$x<count($databases);$x++){
        if($databases[$x][0]==$db_name){
            $db_exists =true;
            break;
        }
        else{
            $db_exists = false;
        }
    }
    return $db_exists;
}

function fn_table_check($tables,$table_name){
    $tb_exists = false;
    for($t=0;$t<count($tables);$t++){
        if($tables[$t][0]==$table_name){
            $tb_exists=true;
            break;
        }
        else{$tb_exists=false;}
    }
    return $tb_exists;
}

function send_data_to_server($connection,$tab_name){
    $Firstname = $_POST["fname"];
    $Lastname = $_POST["lname"];
    $email = $_POST["email"];
    $gender = $_POST["gender"];
    $loginid = $_POST["lgnid"];
//Converting the password to md5 hasing algorithm
    $password = md5($_POST["pswd"]);
    $contact = $_POST["phno"];
    $address = $_POST["address"];

    $insert_values = "Insert into"." ".$tab_name." "."(FirstName,LastName,Email,Gender,LoginId,Password,Contact,Address) values (?,?,?,?,?,?,?,?)";

    $stmt = mysqli_stmt_init($connection);

    if(!mysqli_stmt_prepare($stmt,$insert_values)){
        die(mysqli_error($connection));
        echo " <br><br> <center><h1>YOUR REGISTRATION IS  UNSUCCESSFULL  <span style='color: red; font-size:30px'>&#x274C;</span></h1></center> <br><br> ".
            "<center><h4>REGISTER ONCE AGAIN <p style='font-size:40px'>&#128542;</p></h4> <h4><br> CLICK BELOW TO REGISTER</h4><br><br><a href='reg.html'><input type='submit' value =Register ></a> </center>";
    }

    mysqli_stmt_bind_param($stmt,'ssssssss',$Firstname,$Lastname,$email,$gender,$loginid,$password,$contact,$address);
    mysqli_stmt_execute($stmt);
//     echo "<br> Data Submitted Succesfully...";
    echo "<br><br> <center><h1>YOUR REGISTRATION IS  SUCCESSFULL  <span style='color: green; font-size:30px'>&#x2713;</span></h1></center> <br><br>".
        "<center><h4>THANK YOU FOR REGISTERING <p style='font-size:40px'>&#128512;</pstyle></h4> <h4><br> CLICK BELOW TO LOGIN AND CHECK YOUR DASHBOARD</h4><br><br> <a href='login.html'><input type='submit' value =Login ></a> </center>";

}


// Following data gives result as array of list of associative arrays
//$database_check_result = mysqli_fetch_all($database_check);



//
//echo $database_check_result;
//print_r($database_check_result[0][0]);

//$database_check_query = "show databases";
//$table_check_query = "show tables from "." ".$database_name;
//$database_create_query ="create database ".$database_name;
//$use_database_query = "use"." ".$database_name;
//$table_create_query = "CREATE TABLE"." ".$table_name."(".
//    "FirstName CHAR(30) not null,"."LastName CHAR(30) not null,"
//    ."Email VARCHAR(50) not null,"."Gender CHAR(8) not null,"
//    ."LoginId VARCHAR(15) not null,"."Password VARCHAR(50) not null,"
//    ."Contact VARCHAR(12) not null,"."Address VARCHAR(20)"
//    .")";

$database_check = mysqli_query($connection,"show databases");
$database_check_result = mysqli_fetch_all($database_check);
//$table_check = mysqli_query($connection,"show tables from "." ".$database_name);
//$database_check_result = mysqli_fetch_all($database_check);
$database_create = mysqli_query($connection,"create database if not exists "." ".$database_name);
$use_database = mysqli_query($connection,"use"." ".$database_name);

$table_create_query = "CREATE TABLE if not exists"." ".$table_name."(".
    "FirstName CHAR(30) not null,"."LastName CHAR(30) not null,"
    ."Email VARCHAR(50) not null,"."Gender CHAR(8) not null,"
    ."LoginId VARCHAR(15) not null,"."Password VARCHAR(50) not null,"
    ."Contact VARCHAR(12) not null,"."Address VARCHAR(20)"
    .")";
$table_create = mysqli_query($connection,$table_create_query);

//print_r(count($database_check_result));

//if(mysqli_num_rows($database_check)===0){
//    $database_create;
//    echo "Database Created";
//    $use_database;
//    echo " <br> Database Used";
//    $table_create_query;
//    echo " <br> Table Created Succesfully";
//}
//else if (mysqli_num_rows($database_check)!==0){
//    echo "Database already existed";
//    $use_database;
//    echo " <br> Database Used";
//    if(mysqli_num_rows($table_check===0)){
//        $table_create_query;
//        echo " <br> Table Created Succesfully";
//    }
//    elseif (mysqli_num_rows($table_check)!==0)
//    {
//        echo " <br> Table Already Created";
//    }
//}




if(fn_database_check($database_check_result,$database_name)===false){

    $database_create;
//    echo "<br>Database Created";


    $use_database;
//    echo "<br>"."Database used";

    $table_check = mysqli_query($connection,"show tables from "." ".$database_name);
    $table_check_result = mysqli_fetch_all($table_check);

    if(fn_table_check($table_check_result,$table_name) === false){
        $table_create;
//        echo "<br> Table created successfully";
        send_data_to_server($connection,$table_name);
    }
    else{
//        {echo "<br>Table Already Existed";
            send_data_to_server($connection,$table_name);
        }
    }


else{
//    echo "<br> Database Already Existed";
    $table_check = mysqli_query($connection,"show tables from "." ".$database_name);
    $table_check_result = mysqli_fetch_all($table_check);

    if(fn_table_check($table_check_result,$table_name) === false){
        $table_create;
//        echo "<br> Table created successfully";
        send_data_to_server($connection,$table_name);
    }
    else{
//        {echo "<br>Table Already Existed";
            send_data_to_server($connection,$table_name);
        }

}

?>
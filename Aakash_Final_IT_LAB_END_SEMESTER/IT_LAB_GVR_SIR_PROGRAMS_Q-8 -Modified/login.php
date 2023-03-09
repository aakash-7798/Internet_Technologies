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

//$login_password_data = mysqli_query($connection,"select LoginId,Password from ".$table_name." where LoginId== ".$id);
//$login_password_data_result = mysqli_fetch_all($login_password_data);
//print_r($login_password_data_result);

function login_result_status_failure(){
    echo "<br><br><center><h3>InvalidID or Password  !!!!....</h3></center>" .
        "<br><br> <center><h1>Your Login is Unsuccessfull  <span style='color: red; font-size:30px'>&#x274C;</span></h1></center> <br><br>" .
        "<center><h4>Login Once Again <p>&#128542;</p></h4>" .
        "<br><br>Click here to --> <a href='login.html'>Login</a>"." </center>";
}

function loginid_password_check($con,$id,$pwd,$tb_name)
{
    $flag = false;
    try{
        $login_password_data = mysqli_query($con,"select LoginId,Password from ".$tb_name." where LoginId = '{$id}'");
        $login_password_data_result = mysqli_fetch_all($login_password_data);
        if ($login_password_data_result[0][0] ===$id && $login_password_data_result[0][1]===$pwd)
        {
            $flag=true;
        }
        else{
            $flag;
        }
    }
    catch (Exception $e){
        login_result_status_failure();
    }
    return $flag;
}

$loginid = $_POST["lgnid"];
$password = md5($_POST['pswd']);
//var_dump($loginid,$password);

//$Name_query = mysqli_query($connection,"select FirstName,LastName from "." ".$table_name." "." where LoginId = '21031F0005'");
//$lg = "21031F0005";
//$Name_query = mysqli_query($connection,"select LoginId,Password from ".$table_name." where LoginId = '{$lg}'");
//$Name_query_result = mysqli_fetch_all($Name_query);
//print_r($Name_query_result);
//
//$login_password_data = mysqli_query($connection,"select LoginId,Password from ".$table_name." where LoginId = '{$lg}'");
//$login_password_data_result = mysqli_fetch_all($login_password_data);
//print_r($login_password_data_result);
try {
    if (loginid_password_check($connection, $loginid, $password, $table_name) === true) {
        $Name_query = mysqli_query($connection, "select FirstName,LastName from " . $table_name . " where  LoginId = '{$loginid}' ");
        $Name_query_result = mysqli_fetch_all($Name_query);
//    print_r($Name_query_result);
        if(isset($Name_query)) {
            echo '  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="navbar.css">
<body>
<div class="topnav navbar-default navbar-fixed-top">
    <a class="active" href="home.html"><i class="fa fa-fw fa-home"></i> Home</a>
    <a href="profile.html" target="_self"><i class="fa fa-fw fa-newspaper-o"></i> Profile</a>
    <!--<a href="book.html" target="_self"><i class = "fa fa-fw fa-books">Books Catalogue</a>-->
    <a href="shoppingcart.html"><i class="fa fa-fw fa-envelope"></i> ShoppingCart</a>
    <div class="topnav-right">
       <a href="store.html"  target="_top"><i class="fa fa-fw fa-user"></i>'.$Name_query_result[0][0].$Name_query_result[0][1];'.</a>
</div>
</div>
</body>
</html> 
            ';

//            echo "<br><br><br><h1 align=\"center\">AAKASH ONLINE BOOK STORAGE </h1>" .
//                "<br><br><center><h2> Welcome {$Name_query_result[0][0]}  {$Name_query_result[0][1]} </h2></center>" .
//                "<br><br><center><a href = 'aakashbookstore.html'><input type='submit' value='CONTINUE TO DASHBOARD'></center>";
        }
        else {
            login_result_status_failure();
        }
    } else {
        login_result_status_failure();
    }
}
catch (Exception $e){
    login_result_status_failure();
}

?>
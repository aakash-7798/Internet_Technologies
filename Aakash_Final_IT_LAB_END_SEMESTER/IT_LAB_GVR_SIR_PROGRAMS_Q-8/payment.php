<?php
// Establish a connection to xampp server
// Change the below port number to the portnumber what you see when you start mysql in xampp
$server_name = "localhost:3306";
// The following are same for every xampp server by default;
$server_username = "root";
$server_password = "";

$database_name = "it_lab_php";
$table_name = "registration_form_data";

$connection = mysqli_connect($server_name,$server_username,$server_password,$database_name) ;

$creditcardnumber = $_POST["crdcd"] ;
$password = md5($_POST["pswd"]);

$credit_substr = substr($creditcardnumber,0,10);
echo substr("9951414365414365",0,10)."<br>";


$credit_query = mysqli_query($connection,"select * from {$table_name} where Contact = '{$credit_substr}' ");
$credit_query_result = mysqli_fetch_all($credit_query);
print_r($credit_query_result[0][6]);

$contact_to_credit = $credit_query_result[0][6].substr($credit_query_result[0][6],4,10);



if(isset($credit_query_result[0][6]))
{
    if($credit_query_result[0][6]==$contact_to_credit){

        echo "<br><br> <center><h1>\r\n".
            "    AAKASH ONLINE BOOK STORAGE\r\n".
            "  </h1><br><br><h1>Your Payment is Successfull  <span style='color: green; font-size:30px'>&#x2713;</span></h1></center> <br><br>".
        "<center><h4>ThankYou For Choosing Aakash Book Store<p>&#128512;</p></h4> ".
             "<pre>\r\n".
             "    <strong>\r\n".
             "      <h2>THANK YOU </h2>\r\n".
             "      <h2> Visit Again</h2>\r\n".
             "    </strong>\r\n".
             "  </pre>".
              "</center>";
    }
    else{

    }
}


?>
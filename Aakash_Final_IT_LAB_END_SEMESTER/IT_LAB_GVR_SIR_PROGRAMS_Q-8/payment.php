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

$creditcardnumber = $_POST["crdcd"] ;
$password = md5($_POST["pswd"]);

//$credit_substr = substr($creditcardnumber,0,10);
//echo substr("9951414365414365",0,10)."<br>";


$data_query = mysqli_query($connection,"select * from {$table_name}  ");
$data_query_result = mysqli_fetch_all($data_query);
//print_r($credit_query_result[0][6]);

function credit_card_check($contact,$crdcard){
    $flag=0;
    for($c=0;$c<count($contact);$c++){
        if(substr($contact[0][6],4,10)==$crdcard){
            $flag=1;
            break;
        }
        else{
            $flag;
        }
    }
    return $flag;
}

//echo "$contact_to_credit";


function result_status_success(){
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

function result_status_failure(){
    echo "<br><br> <center><h1>\r\n".
        "AAKASH ONLINE BOOK STORAGE\r\n".
        "  </h1><br><br><h1>YOUR PAYMENT TRANSACTION FAILED  <span style='color: red; font-size:30px'>&#x274C;</span></h1></center> <br><br>".
        "<center><h3>ORDER ONCE AGAIN<p STYLE='font-size: 40px;'>&#128542;</p></h3>".
        "<br><br><a href='shoppingcart.html'><input type='submit' value='ORDER AGAIN'></a> </center>";
}


if(credit_card_check($data_query_result,$creditcardnumber)==0){
    if($data_query_result[0][5]==$password){
        result_status_success();
    }
    else{
        result_status_failure();
    }
}
else{
    result_status_failure();
}

    
?>

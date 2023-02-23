<?php
// Establish a connection to xampp server
// Change the below port number to the portnumber what you see when you start mysql in xampp
$server_name = "localhost:8111";
// The following are same for every xampp server by default;
$server_username = "root";
$server_password = "";

$database_name = "it_lab_php";
$table_name = "book_catalogue";

$connection = mysqli_connect($server_name,$server_username,$server_password,$database_name) ;



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

function preview($connection,$table_name){
    $bookormagazine_select = $_POST['booklist'];
    $quantity = $_POST["qnty"];

    $data_query = mysqli_query($connection,"select * from {$table_name} where BooksandMagazines= '{$bookormagazine_select}' ");
    $data_query_result = mysqli_fetch_all($data_query);
    if(!empty($data_query_result)){

        echo "<br><br><h2 align='center'>PREVIEW ORDER DETAILS</h2>".
        "<br> <p align='center'> BookorMagazine = {$data_query_result[0][0]}</h3>".
        "<br> <p align='center'> Author = {$data_query_result[0][1]}</h3>".
        "<br> <p align='center'> Publication = {$data_query_result[0][2]}</h3>".
        "<br> <p align='center'> Quantity = {$quantity}</h3>".
        "<br> <p align='center'> Item-cost = {$data_query_result[0][3]}</h3>".
        "<br> <p align='center'> TotalAmount = ".$quantity*$data_query_result[0][3]."</h3>".
        "<br><br><br><a href = 'payment.html'><input type='submit' value = 'CONTINUE TO PAYMENT'></a>";
    }
}

$table_check = mysqli_query($connection,"show tables from $database_name");
$table_check_result = mysqli_fetch_all($table_check);

$table_create_query = "CREATE TABLE if not exists {$table_name} (".
    "BooksandMagazines CHAR(100) not null,Author CHAR(50) not null,".
    "Publication VARCHAR(50) not null,Price Integer not null)";

$table_create = mysqli_query($connection,$table_create_query);

$table_data_result = mysqli_num_rows(mysqli_query($connection,"select * from {$table_name}"));
//print_r($table_data_result);

$insert_values_query = "Insert into {$table_name} values".
    "('The Complete Reference PC Hardware','Craig Zacker','McGraw Hill',265),".
    "('Computer Hardware','Kevin Wilson','Elluminet Press',1268),".
    "('Modern Computer Hardware','Manahar Lotia','BPB Publications',596),".
    "('Java The Complete Reference','Herbert Schildt','McGraw Hill',1650),".
    "('Automate the boring Stuff with Python','AI Sweigart','Nostarch',3589),".
    "('Flutter and Dart Cookbook','Richard Rose','Shroff Publishers',1200),".
    "('TimesNow','Malhotra','TimesNow',525),".
    "('Forbes','Antonine Gara','Forbes',2587),".
    "('NewYork Magazine','Jia Tolentino','Oscars',3025)";


if(fn_table_check($table_check_result,$table_name)==false){
    $table_create;
    if(!$table_data_result>0){
        
        $insert_values = mysqli_query($connection,$insert_values_query);
        $insert_values;
    }
    preview($connection,$table_name);

}
else{
    preview($connection,$table_name);
}

?>
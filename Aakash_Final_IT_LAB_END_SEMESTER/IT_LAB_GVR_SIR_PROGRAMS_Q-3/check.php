<!--https://www.php.net/manual/en/function.simplexml-load-file.php-->

<?php

function printdetails($xml,$ct){
    echo "<br><br><br>";
    echo "<center>";
    echo "<h3> PERSONAL INFORMATION</h3>";
    echo "UserId =  {$xml->user[$ct]->userid} ";
    echo "<br>";
    echo "Name = {$xml->user[$ct]->Name}";
    echo "<br>";
    echo "Gender =   {$xml->user[$ct]->gender}";
    echo "<br>";
    echo "Contact =  {$xml->user[$ct]->contact}";
    echo "<br>";
    echo "Address = {$xml->user[$ct]->address}";
    echo "<br>";
    echo "</center>";
}

$xml = simplexml_load_file("userinformation.xml");
//print_r($xml);
//echo "<br>";
$usrid = $_POST["usrid"];
$ct = 0;
$flag = false;
for($x=0;$x<count($xml->user);$x++){
    if($xml->user[$x]->userid == $usrid){
        $flag=true;
        break;
    }
    else{
        $flag;
    }
    $ct+=1;
}
if($flag==false){
    echo "User Information Not Found...";
}
else{
    printdetails($xml,$ct);
}

//echo "<br>".$fl->asXML();


?>
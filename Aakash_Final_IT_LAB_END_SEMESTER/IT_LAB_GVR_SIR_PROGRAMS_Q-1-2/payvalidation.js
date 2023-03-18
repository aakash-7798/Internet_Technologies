function updateamount(){
    var book =  document.forms["shpfrm"]['booklist'].value;
    var quantity = document.forms["shpfrm"]['qnty'].value;
    alert(quantity);
    document.getElementById("toamt").innerHTML = book;
    // if(book=="JTCR"){
    //     document.getElementById("toamt").innerHTML = 1650*quantity;
    // }
}
function frmvalidation(){
    // var amount = document.forms["payform"]["amt"].value;
    var crdcard = document.forms["payform"]["crdcd"].value;
    // amt_regx = /^[0-9]*$/;
    crd_regx = /^[0-9]\d{15}$/;
    // if(!amt_regx.test(amount)){
    //     alert("Enter only Amount.. !!! Invalid Amount");
    // }
    if(!crd_regx.test(crdcard)){
        alert("Invalid Credit Card Number");
    }
}


function frmvalidation(){
    // var amount = document.forms["payform"]["amt"].value;
    var crdcard = document.forms["payform"]["crdcd"].value;
    var cnfrm_msg = confirm("Do you proceed to pay ?");
    // amt_regx = /^[0-9]*$/;
    crd_regx = /^[0-9]\d{15}$/;
    // if(!amt_regx.test(amount)){
    //     alert("Enter only Amount.. !!! Invalid Amount");
    // }
    if(!crd_regx.test(crdcard)){
        alert("Invalid Credit Card Number");
        return false;
    }
    if(!cnfrm_msg){
	alert("Are you sure you want to cancel?");
	return false;
    
}

}
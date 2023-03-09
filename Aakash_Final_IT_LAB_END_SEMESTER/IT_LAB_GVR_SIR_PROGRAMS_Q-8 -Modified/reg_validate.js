function reg_validate(){
	
	var fname = document.forms["regform"]['fname'].value;
    var lname = document.forms["regform"]['lname'].value;
    var email = document.forms["regform"]['email'].value;
    var gender = document.forms["regform"]['gender'].value;
    var loginid = document.forms["regform"]['lgnid'].value;
    var password = document.forms["regform"]['pswd'].value;
    var contact = document.forms["regform"]['phno'].value;
    var cnfrm_msg = confirm("Do you really want to submit the form?");

     
    
    var name_regx = /^[A-Za-z ]+$/
    var email_regx = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var login_regx = /\d\d\d\d\dF\d\d\d\d/;
    var pswd_regx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$/;
    var cntct_regx =/^[6-9]\d{9}$/    


if(!name_regx.test(fname)){
        alert("Firstname should not contain numericals or specialcharacters");
        return false ;
        /*window.location.reload(true);*/
    }
    if(!name_regx.test(lname)){
            alert("Lastname should not contain numericals or specialcharacters");
            return false ;
    }
    if(!email_regx.test(email)){
        alert("Invalid Email");
        return false ;
    }
    if(!login_regx.test(loginid)){
		alert("Invalid ID Pattern");
		return false ;
	}
    if(password.length<=7){
        alert("Password should have atleast 8 characters");
        return false ;
    }
    else if(password.length>7){
        if(password.length<=16){
            if(!pswd_regx.test(password)){
                alert("Password Pattern Not Matching");
                return false ;
            }
        }
        else{
            alert("Your Password must be between 8 and 16 characters");
            return false ;
        }
    }

    if(!cntct_regx.test(contact)){
        alert("Invalid Mobile Number");
        return false ;
    }
   if(!cnfrm_msg){
	alert("Are you sure you want to cancel?");
	return false;
}
}
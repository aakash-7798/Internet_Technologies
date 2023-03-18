function frmvalidation(){

    var fname = document.forms["regform"]['fname'].value;
    var lname = document.forms["regform"]['lname'].value;
    var email = document.forms["regform"]['eml'].value;
    var username = document.forms["regform"]['usrnm'].value;
    var password = document.forms["regform"]['pswd'].value;
    var contact = document.forms["regform"]['phno'].value;
    var gender = document.forms["regform"]['gender'].value;


    var name_regx = /^[A-Za-z ]+$/
    var email_regx = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var usrname_regx = /^[A-Za-z][A-Za-z0-9_]{7,19}$/;
    var pswd_regx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$/;
    var cntct_regx =/^[6-9]\d{9}$/

    if(!name_regx.test(fname)){
        alert("Firstname should not contain numericals or specialcharacters");
    }
    if(!name_regx.test(lname)){
        alert("Lastname should not contain numericals or specialcharacters");
    }
    if(!email_regx.test(email)){
        alert("Invalid Email")
    }
    if(username.length<=7){
        alert("Username should have atleast 8 characters");
    }
    else if(username.length>=8){
        if(username.length<=20){
            if(!usrname_regx.test(username)){
                alert("Invalid Username");
            }
        }
        else{
            alert("Your username must be between 8 and 20 characters");
        }
    }

    if(password.length<=7){
        alert("Password should have atleast 8 characters");
    }
    else if(password.length>7){
        if(password.length<=16){
            if(!pswd_regx.test(password)){
                alert("Password Pattern Not Matching");
            }
        }
        else{
            alert("Your Password must be between 8 and 16 characters");
        }
    }

    if(!cntct_regx.test(contact)){
        alert("Invalid Mobile Number");
    }

}
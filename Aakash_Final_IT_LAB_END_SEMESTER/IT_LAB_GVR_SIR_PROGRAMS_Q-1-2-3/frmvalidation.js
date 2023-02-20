function frmvalidation(){
    var username = document.forms["lgnform"]['usnme'].value;
    var password = document.forms["lgnform"]['psd'].value;
    var usrname_regx = /^[A-Za-z][A-Za-z0-9_]{7,19}$/;
    var pswd_regx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$/;
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

}
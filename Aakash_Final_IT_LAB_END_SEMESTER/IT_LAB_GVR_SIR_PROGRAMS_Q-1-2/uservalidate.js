function frmvalidation(){
    var username = document.forms["usrfrm"]['usrnm'].value;
    var usrname_regx = /^[A-Za-z][A-Za-z0-9_]{7,19}$/;
    if(username.length<=7){
        alert("Username should have atleast 8 characters");
        window.location.reload();
    }
    else if(username.length>=8){
        if(username.length<=20){
            if(!usrname_regx.test(username)){
                alert("Invalid Username");
                window.location.reload();
            }
        }
        else{
            alert("Your username must be between 8 and 20 characters");
            window.location.reload();
        }
    }

}
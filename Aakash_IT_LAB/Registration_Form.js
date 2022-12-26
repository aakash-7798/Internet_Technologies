 function validate_firstname(){
    var fname = document.forms["Rgstrform"]["fname"].value;
    if(fname==null || fname==""){
    document.getElementById("fnm").innerHTML = "FirstName is Empty";
}
    else if(fname!=null || fname!="")
{
    var regx = /^[A-Za-z ]+$/;
    if(!regx.test(fname)){
    document.getElementById("fnm").innerHTML = "Field should not contain numericals or specialcharacters";
}
    else{
    document.getElementById("fnm").innerHTML= "<span style='color: green; font-size:15px'>&#x2713;</span>";
}
}
}

    function validate_lastname(){
    var lname = document.forms["Rgstrform"]["lname"].value;
    if(lname==null || lname==""){
    document.getElementById("lnm").innerHTML = "LastName is Empty";
}
    else if(lname!=null || lname!="")
{
    var regx = /^[A-Za-z ]+$/;
    if(!regx.test(lname)){
    document.getElementById("lnm").innerHTML = "Field should not contain numericals or specialcharacters";
}
    else{
    document.getElementById("lnm").innerHTML = "<span style='color: green; font-size:15px'>&#x2713;</span>";
}
}
}

    function validate_email(){
    var email = document.forms["Rgstrform"]["email"].value;
    if(email==null || email==""){
    document.getElementById("eml").innerHTML = "Email is Empty";
}
    else{
    var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(!regex.test(email)){
    document.getElementById("eml").innerHTML = "Invalid Email";
}
    else{
    document.getElementById("eml").innerHTML = "<span style='color: green; font-size:15px'>&#x2713;</span>";
}
}
}

function validate_username(){
    // username consists of 8 to 20 characters
    // it can only contain alphanumeric characters and underscores
    // first character of username should be alphanumeric character i.e either [a z] or [A Z]
    var username = document.forms["Rgstrform"]["usernme"].value;
    if(username==null || username==""){
        document.getElementById("usnme").innerHTML = "Username is Empty";
    }
    else{
        if(username.length<8){
            document.getElementById("usnme").innerHTML = "Your username should have alteast 8 characters";
        }
        else{
            if(username.length<20){
                var regex = /^[A-Za-z][A-Za-z0-9_]{7,19}$/;
                if(!regex.test(username)){
                    document.getElementById("usnme").innerHTML = "Invalid Username";
                }
                else{
                    document.getElementById("usnme").innerHTML = "<span style='color: green; font-size:15px'>&#x2713;</span>";
                }
            }
            else{
                document.getElementById("usnme").innerHTML = "Your Username must be between 8 and 20 characters";
            }
        }
        
    }
}



    function validate_password(){
    var psswd = document.forms["Rgstrform"]["pswd"].value;
    if(psswd==null || psswd==""){
    document.getElementById("pswwd").innerHTML = "Password is Empty";
}
    else if(psswd!=null || psswd!=""){
    if(psswd.length<8){
    document.getElementById("pswwd").innerHTML = "Your password must be at least 8 characters";
}
    else{
    if(psswd.length < 16){
    // var regex = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*].{6,16}$/;
    // Minimum eight and maximum 16 characters, at least one uppercase letter, one lowercase letter, one number and one special character:
    var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$/

    if (!regex.test(psswd)) {
    document.getElementById('pswwd').innerHTML = "Invalid Password Pattern"
}
    else{
    document.getElementById("pswwd").innerHTML = "<span style='color: green; font-size:15px'>&#x2713;</span>";
}
}
    else{
    document.getElementById("pswwd").innerHTML = "Your password must be between 8 and 16 characters";
}
}

}
}

    function validate_confirmpassword(){
    var psswd = document.forms["Rgstrform"]["pswd"].value;
    var cnfmpsswd = document.forms["Rgstrform"]["cfmpswd"].value;
    if(cnfmpsswd==null || cnfmpsswd==""){
    document.getElementById("cnfrpswd").innerHTML = "ConfirmPassword is Empty";
}
    if(psswd == null || psswd == ""){
    document.getElementById("cnfrpswd").innerHTML = "Above Password is Empty";
}
    else{
    if(psswd==cnfmpsswd){
    document.getElementById("cnfrpswd").innerHTML = "<span style='color: green; font-size: 10px'>Password Matched &#x2713;</span>";
}
    else{
    document.getElementById("cnfrpswd").innerHTML = "Password Not Matching";
}
}
}

    
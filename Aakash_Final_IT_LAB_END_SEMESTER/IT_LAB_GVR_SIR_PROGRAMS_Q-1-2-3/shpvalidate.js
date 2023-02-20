// function updateamount(){
//     var book =  document.forms["shpfrm"]['booklist'].value;
//     var quantity = document.forms["shpfrm"]['qnty'].value;
    // alert(quantity);
    // document.getElementById("toamt").innerHTML = book;
    // if(book=="JTCR"){
    //     document.getElementById("toamt").innerHTML = 1650*quantity;
    // }
// }

function frmvalidation(){
    // var qty = document.forms["shpfrm"]["qnty"].value;
    // qty_regx = /^[1-9]{1,2}/;
    // if(!qty_regx.test(qty)){
    //     alert("Enter only numbers..");
    // }
    // else if(qty>=5){
    //     alert("Nuvvu Chadhive moham kaadu kaani quantity tagginchuko.. neeku okate ekuvva. ")
    // }
    // else{
    //     updateamount();
    // }

    var qty = document.forms["shpfrm"]["qnty"].value;
    

    qty_regx = /^[1-9]{0,2}$/;

    if(!qty_regx.test(qty)){
        alert("Enter only numbers..");
        return false;
    }
    if(qty>=5){
        alert("Nuvvu Chadhive moham kaadu kaani quantity tagginchuko.. neeku okate ekuvva. ");
        return false;
    }
    var cnfrm_msg = confirm("Do you really want to continue to payment?");
    if(!cnfrm_msg){
        alert("Are you sure you want to cancel?");
        return false;
    }
    
}
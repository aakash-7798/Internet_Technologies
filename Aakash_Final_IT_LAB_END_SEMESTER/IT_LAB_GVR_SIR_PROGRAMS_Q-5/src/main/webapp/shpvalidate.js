function shp_validate(){
    var qty = document.forms["shpfrm"]["qnty"].value;
    var cnfrm_msg = confirm("Do you really want to place order?");
    
    qty_regx = /^[1-9]{0,2}$/;
    
    if(!qty_regx.test(qty)){
        alert("Enter only numbers..");
        return false;
    }
    
    if(qty>=5){
        alert("Nuvvu Chadhive moham kaadu kaani quantity tagginchuko.. neeku okate ekuvva. ");
        return false;
    }
    if(!cnfrm_msg){
	alert("Are you sure you want to cancel?");
	return false;
	}
}
function update_cart(isbn){
var ajaxReq;
try{
ajaxReq = new XMLHttpRequest();
}
catch(e)
{
try
{
ajaxReq= new ActiveXObject("Microsoft.XMLHTTP");
}
catch(e)
{
alert("The browser broke!");
return false;
}

}

ajaxReq.onreadystatechange=function()
{
if(ajaxReq.readyState == 4)
{
	document.getElementById("cart_res").innerHTML=ajaxReq.responseText;
}

}

var prod_no=isbn;
var qty="";
var qstr="?prod_no="+prod_no+"&qty="+qty;
alert("Updating product to sold");
ajaxReq.open("GET","updatecart.php"+qstr,true);
ajaxReq.send(null);

}


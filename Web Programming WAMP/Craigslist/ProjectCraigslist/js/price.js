function price()
{



var ajaxReq;
try{
ajaxReq = new XMLHttpRequest();
}
catch(e)
{
try{
ajaxReq= new ActiveXObject("Msxml2.XMLHTTP");
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
}

ajaxReq.onreadystatechange=function()
{
if(ajaxReq.readyState == 4)
{
	document.getElementById("row1").innerHTML=ajaxReq.responseText;
}

}


var start_pr=document.getElementById('start').value;
var end_pr=document.getElementById('end').value;
var qstr="?start_pr="+start_pr+"&end_pr="+end_pr;

//alert("start:"+start_pr+"end:"+end_pr+"qstr:"+qstr);
ajaxReq.open("GET","price_filter.php"+qstr,true);
ajaxReq.send(null); 
}

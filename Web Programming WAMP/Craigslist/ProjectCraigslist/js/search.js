function prod_search()
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

var src_name=document.getElementById('src').value;

var qstr="?src_name="+src_name;

//alert("Search name:"+src_name+"qstr:"+qstr);
ajaxReq.open("GET","prod_search.php"+qstr,true);
ajaxReq.send(null); 
}

function insertUser()
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
	document.getElementById("ajaxDiv").innerHTML=ajaxReq.responseText;
}

}
var fname=document.getElementById('fname').value;
var phone=document.getElementById('phone').value;
var email=document.getElementById('email').value;
var username=document.getElementById('username').value;
var pwd=document.getElementById('pwd').value;
var pwd2=document.getElementById('pwd2').value;
var qstr="?fname="+fname+"&phone="+phone;
alert(qstr);
ajaxReq.open("GET","register.php"+qstr,true);
ajaxReq.send(null);
}
function showProducts(cat)
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
			try{
				ajaxReq= new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch(e)
			{
				alert("The browser broke!");
				return false;
			}
		}
	}
	
	ajaxReq.onreadystatechange=
	function()
	{
		if(ajaxReq.readyState == 4)
			document.getElementById("row1").innerHTML=ajaxReq.responseText;
	}

	var category=cat;
	var qstr="?category="+category;
	ajaxReq.open("GET","prod_Display.php"+qstr,true);
	ajaxReq.send(null);
}

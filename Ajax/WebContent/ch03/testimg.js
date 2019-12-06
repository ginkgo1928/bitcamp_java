var xhr=null;
function imgclick(){
	xhr=new XMLHttpRequest();
	xhr.onreadystatechange=resultProcess;
	xhr.open("GET","imgtest.xml",true);
	xhr.send(null);
}
function resultProcess(){
	if(xhr.readyState==4){
		if(xhr.status==200){
		document.getElementById("displayArea").innerHTML = xhr.responseText;
		//document.getElementById("displayArea").style.display="block";
		document.getElementById("displayArea").style.visibility="visible";
		}
	}
	
}
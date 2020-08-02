var stateBtn = document.querySelectorAll(".stateBtn");

for(var i = 0; i < stateBtn.length; i++){
	
	stateBtn[i].addEventListener("click",function(){
		var sub = this.parentNode;
		var article = sub.parentNode;
		var btn = sub.childNodes[1];
		
	    id = article.id;
	    type = article.className;

	    var xhttp = new XMLHttpRequest();
	    xhttp.onreadystatechange = function() {
	    	
	          if (this.readyState == 4 && this.status == 200) {
	          if (type === "TODO"){	  
	        	  document.getElementById("todoSection").removeChild(article);
	        	  article.className = "DOING";
	              document.getElementById("doingSection").appendChild(article);
	              type = "DOING";
	              
	            }else if (type === "DOING") {
	            	document.getElementById("doingSection").removeChild(article);
	            	article.className = "DONE";
	            	document.getElementById("doneSection").appendChild(article);
		            sub.removeChild(btn);
		            type = "DONE";
	            }
	          };
	    }
	        xhttp.open("GET", "update?id="+id+"&type="+type, true);
	        xhttp.send();
	}
);
}

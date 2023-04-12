function openNav() {
    document.getElementById("mySidenav").style.width = "12%";
  }
  
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}

function myfunction(){
				var source = document.getElementById("source");
				var num = source.selectedIndex;
				var text = source.options[num].text;
				const cities = ['NADIAD','VADODARA','AHMEDABAD','BHAVNAGAR']
				var selected=[];
				var dest = document.getElementById("destination");
				for (let index = 0; index < cities.length; index++) {
					if(text==cities[index]){
						console.log(text);
					}else{						
					selected.push(cities[index])
					}
					
				}
				while (dest.options.length > 1) {                
			        dest.remove(1);
			    }
				console.log(selected);
				
				for(let i = 0;i< selected.length;i++){
					var o = document.createElement("option");
					o.text = selected[i];
					dest.options.add(o,i+1);
				}
		}
//for the changing the seat visibility
let previous=-2;
let flag = -1;
var arr =[];
function hideshow(k,noseat){
	var y = document.getElementsByName("change");
	var x = document.getElementById(""+k+"");
	console.log(y);
	for (let i = 0; i < y.length; i++) {
  		// Do stuff
	  	if(y[i].id==k){
			  if (y[i].style.display === "none") {
				y[i].style.display = "grid";
				console.log("hello from first")
				arr=[];
			} else {
				console.log("hello from ")
				var undo = document.getElementById(k).getElementsByTagName('img');
				for (let i = 0; i < undo.length; i++) {
					if(undo[i].src=="https://gsrtc.in/OPRSOnline/images2/Sleeper-Seat_Selected.gif"){
						undo[i].src="https://gsrtc.in/OPRSOnline/images2/Sleeper-Seat_Available.gif";
					}else if(undo[i].src=="https://gsrtc.in/OPRSOnline/images2/selectedSeat.gif"){
						undo[i].src="https://gsrtc.in/OPRSOnline/images2/availableSeatnew.gif";
					}
				}
				var d = document.querySelector('[hello]');
				console.log(d);
        		if(d){
					d.remove();
				}
				console.log(undo);
				y[i].style.display = "none";
			}
		}else{
			var undo = document.getElementById(k).getElementsByTagName('img');
				for (let i = 0; i < undo.length; i++) {
					if(undo[i].src=="https://gsrtc.in/OPRSOnline/images2/Sleeper-Seat_Selected.gif"){
						undo[i].src="https://gsrtc.in/OPRSOnline/images2/Sleeper-Seat_Available.gif";
					}
					else if(undo[i].src=="https://gsrtc.in/OPRSOnline/images2/selectedSeat.gif"){
						undo[i].src="https://gsrtc.in/OPRSOnline/images2/availableSeatnew.gif";
					}
				}
			var d = document.querySelector('[hello]');
			console.log(d);
        	if(d){
				d.remove();
			}
			y[i].style.display="none";
		}
  		console.log(y[i].id);
  		console.log(i);
	}
}

// for changing the seat colour
function changeToBW(i,itemid,noseat){
	//let colorImage = document.querySelector('[title="'+i+'"]');
	var colorImage = document.getElementById(itemid).querySelector('[title="'+i+'"]');
	var images = document.getElementById(itemid).getElementsByTagName('img')
	console.log("hello from the change color"+images.length);
	
	
    if (colorImage.src == "https://gsrtc.in/OPRSOnline/images2/Sleeper-Seat_Selected.gif") { 
        colorImage.src = "https://gsrtc.in/OPRSOnline/images2/Sleeper-Seat_Available.gif";
        var d = document.querySelector('[hello="'+i+'"]');
        d.remove();
        const index = arr.indexOf(colorImage);
        const x = arr.splice(index,1);
    }
    else if(colorImage.src=="https://gsrtc.in/OPRSOnline/images2/Sleeper-Seat_Available.gif"){
        colorImage.src = "https://gsrtc.in/OPRSOnline/images2/Sleeper-Seat_Selected.gif";
        var d = document.createElement('p');
        d.setAttribute("hello",i);
        d.innerText=i+" , ";
        d.id = "created"
        var position = document.getElementById(itemid).querySelector('[id="selecteseat"]');
        console.log("hello from position "+position);
       	position.insertAdjacentElement("afterend",d);
       	if(arr.length == noseat){
			const x = arr.shift();
			x.src = "https://gsrtc.in/OPRSOnline/images2/Sleeper-Seat_Available.gif";
			var d = document.querySelector('[hello="'+x.title+'"]');
        	d.remove();
		 }
       	arr.push(colorImage);
    }else{
			 if(colorImage.src=="https://gsrtc.in/OPRSOnline/images2/availableSeatnew.gif"){
			colorImage.src = "https://gsrtc.in/OPRSOnline/images2/selectedSeat.gif";
	        var d = document.createElement('p');
	        d.setAttribute("hello",i);
	        d.innerText=i+" , ";
	        d.id = "created"
	        var position = document.getElementById(itemid).querySelector('[id="selecteseat"]');
	        console.log("hello from position "+position);
	       	position.insertAdjacentElement("afterend",d);
	       	if(arr.length == noseat){
				const x = arr.shift();
				x.src = "https://gsrtc.in/OPRSOnline/images2/availableSeatnew.gif";
				var d = document.querySelector('[hello="'+x.title+'"]');
	        	d.remove();
			 }
	       	arr.push(colorImage);
			}else if(colorImage.src=="https://gsrtc.in/OPRSOnline/images2/selectedSeat.gif"){
			colorImage.src = "https://gsrtc.in/OPRSOnline/images2/availableSeatnew.gif";
	        var d = document.querySelector('[hello="'+i+'"]');
	        d.remove();
	        const index = arr.indexOf(colorImage);
	        const x = arr.splice(index,1);
		}
	}
			
    
			
    console.log("hello this is a arr + "+ arr.length);
}

function formsubmit(itemid,noseat){
	if(arr.length<noseat || arr.length==0){
		alert("Please select '"+noseat+"' seat/s to proceed !")
		return false;
	}
	var bt = document.getElementById(itemid).querySelector('[id="booknow"]');
	console.log(bt);
	for(let i = 0;i<arr.length;i++){
	var button = document.createElement('input')
	button.type = 'hidden';
    button.name = 'selected';
    button.value = ''+arr[i].title+'';
    button.className = 'btn';
    console.log(button);
    var po = document.getElementById(itemid).querySelector('[id="bookform"]');;
    po.insertAdjacentElement("beforeend",button);
	//document.body.appendChild(button);
		//document.getElementById(itemid).querySelector('[id="bookform"]').submit();
	}
}
function toggle(elem, marginLeft) {
	if (elem.style.marginTop == "-100%") {
		diminish(elem);
	} else {
		enlarge(elem, marginLeft);
	}
}

function enlarge(elem, marginLeft){
  var anim = { 
	height: "300%",
	position: "absolute",
	top:"10%",
	left:"10%",
    	zIndex:"10000"
  };
  anim["marginLeft"]=marginLeft;
  $(elem).animate(anim, 1000 );
};
function diminish(elem){
  $(elem).animate({ 
	position:"relative",
	top:"auto",
	left:"auto",
	height: "100%",
	marginLeft: "5px",
	marginTop:"0px",
    	zIndex:"0"
  }, 1000 );
};


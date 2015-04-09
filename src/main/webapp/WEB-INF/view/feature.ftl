<html>
	<head>
		<title>Feature in</title>
	</head>
	
	<body>
		<h2>Canvas:</h2>
		<canvas id="canvas" width="600" height="600"></canvas>
	</body>
	<script>
		window.onload = function() {
			 var canvas = document.getElementById("canvas"),
			      context = canvas.getContext("2d");
			  
			  context.shadowColor = "rgba(0, 0, 0, 0.8)";
			  
			  document.body.addEventListener("mousemove", function(event) {
			    context.clearRect(0, 0, 600, 600);
			    console.log(event.clientX + " " + event.clientY);
			    var dx = 300 - event.clientX,
			        dy = 300 - event.clientY,
			        distance = Math.sqrt(dx * dx + dy * dy);
			    
			    context.shadowOffsetX = dx * 0.5;
			    context.shadowOffsetY = dy * 0.5;
			    context.shadowBlur = distance * 0.25;
			    context.fillStyle = "red";
			    context.fillRect(250, 250, 100, 100);
			  });
		}
	</script>
</html>
<style>
	<style>
		body {
			font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
			margin: auto;
			position: relative;
			width: 960px;
		}

		#isLight {
			position: absolute;
			right: 100px;
			top: 10px;
		}

	</style>		
</style>
<h3>
	D3 Digramm
	<div id="d3">
		<button id="light" onclick="light()"> The light! </button>
	</div>
	<svg width="300" height="200"> </svg>
</h3>

<script src="/javascript/d3.min.js"></script>
<script>
	isLight = true;
	function light() {
		if(isLight) {
			d3.select('body').transition().style('background-color', "black");
			isLight = false;
		}
		else {
			d3.select('body').transition().style('background-color', "white");
			isLight = true;										
		}
	}

	d3.selectAll("p").style("color", "yellow");
</script>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

 <style>
  body
  {
      background-image: url("<%=request.getContextPath()%>/img/planta.jpg");
      background-repeat: no-repeat; 
          
  } 
 
</style> 
<link href="<%=request.getContextPath()%>/css/cssLayout.css" rel="stylesheet" type="text/css" >

<title>SensoCity</title>


</head>

<body>
<div id="container"> 

      <div id="header">
      
      </div> 
      
      
      <div id="content">
      
      <div id="main">
      
          <div id="lamp" >
          <img src="<%= request.getContextPath() %>/img/lampada-on.png" >
          </div>
          
          <div id="audio" >
          <img  src="<%= request.getContextPath() %>/img/audio.png" >
          </div>
          
          <div id="luminosity" >
          <img  src="<%= request.getContextPath() %>/img/luminosity.png">
          </div>
          
          <div id="temperature" >
          <img  src="<%= request.getContextPath() %>/img/temperature.png"> 34
          </div>
          
          <div id="humidity" >
          <img  src="<%= request.getContextPath() %>/img/humidity.png">
          </div>
          
          <div id="atmpressure" >
          <img  src="<%= request.getContextPath() %>/img/atmpressure.png">
          </div>
     </div>     
     <div id="sidebar">
          
          <div>
          <h3>Sensor House</h3>
          </div>
          
          <div>
          <img  src="<%= request.getContextPath() %>/img/lampada-on.png" id="img1">Lamp
          </div>
          
          <div>
          <img  src="<%= request.getContextPath() %>/img/audio.png" id="img1">Audio
          </div>
          
          <div>
          <img  src="<%= request.getContextPath() %>/img/luminosity.png" id="img1">Luminosity
          </div>
          
          <div>
          <img  src="<%= request.getContextPath() %>/img/temperature.png" id="img1">Temperature
          </div>
          
          <div >
          <img  src="<%= request.getContextPath() %>/img/humidity.png" id="img1">Humidity
          </div>
          
          <div >
          <img  src="<%= request.getContextPath() %>/img/atmpressure.png" id="img1">AtmPressure
          </div>
   </div> 
   
   </div>
   
    <div id="footer">
    <img  src="<%= request.getContextPath() %>/img/house.png" id="img2">Budapest,ICT Labs;
    <img  src="<%= request.getContextPath() %>/img/clock.png" id="img2">Time
    
    </div>
</div>
</body>
</html>
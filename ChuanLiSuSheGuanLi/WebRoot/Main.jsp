<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>川理宿舍管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <link rel="stylesheet" href="css/Maincss.css" type="text/css"></link>
    <script type="text/javascript" src="jQuery/jquery.min.js"></script>
    <script type="text/javascript" >
          $(document).ready(function(){
               $('#ChaCha').addClass('QuChaCha');
          });
          
          function renyuanclick(){
              location.href='PeopleManege/RenYuanGuanLi.jsp';
          }
    </script>
    <script type="text/javascript">
   //初始化各指钟的位置
   window.onload = function(){
      var date = new Date(),
      second = date.getSeconds(),
      minute = date.getMinutes(),
      minuteDeg,
      hour = date.getHours(),
      hourDeg;
      var secondrotate = 'rotate('+second*6+'deg)';
      var scss = '-moz-transform:' + secondrotate + ';-o-transform:' + secondrotate + ';-ms-transform:' + secondrotate;
      //对?于úwebkit的?浏ˉ览à器÷,要a这a样ù定¨义?
     document.getElementById('second').style.cssText = scss;
     document.getElementById('second').style.webkitTransform = secondrotate;

     minuteDeg = minute*6 + second*6/60;
     var minuterotate = 'rotate('+minuteDeg+'deg)';
     var minutecss = '-moz-transform:' + minuterotate + ';-o-transform:' + minuterotate + ';-ms-transform:' + minuterotate ;
     document.getElementById('minute').style.cssText = minutecss;
     document.getElementById('minute').style.webkitTransform = minuterotate; //对?于úwebkit的?浏ˉ览à器÷,要a这a样ù定¨义?
     if(hour>12){
        hour = hour -12;
     }
     hourDeg = hour * 30 + minute*30/60;
     var hourtrotate = 'rotate('+hourDeg+'deg)';
     var hcss = '-moz-transform:' + hourtrotate + ';-o-transform:' + hourtrotate + ';-ms-transform:' + hourtrotate;
     document.getElementById('hour').style.cssText = hcss;
     document.getElementById('hour').style.webkitTransform = hourtrotate; //对?于úwebkit的?浏ˉ览à器÷,要a这a样ù定¨义?

  }; 

  //周ü期ú性?改?变?秒?钟ó的?位?置?
  setInterval(function(){
     var date = new Date(),
     second = date.getSeconds();

     var secondrotate = 'rotate('+second*6+'deg)';
     var scss = '-moz-transform:' + secondrotate + ';-o-transform:' + secondrotate + ';-ms-transform:' + secondrotate ;
     document.getElementById('second').style.cssText = scss;
     document.getElementById('second').style.webkitTransform = secondrotate; //对?于úwebkit的?浏ˉ览à器÷,要a这a样ù定¨义?

  },1000)

  //周ü期ú性?改?变?分?钟ó的?位?置?
  setInterval(function(){
     var date = new Date(),
     second = date.getSeconds(),
     minute = date.getMinutes(),
     minuteDeg;
     minuteDeg = minute*6 + second*6/60;
     var minuterotate = 'rotate('+minuteDeg+'deg)';
     var minutecss = '-moz-transform:' + minuterotate + ';-o-transform:' + minuterotate + ';-ms-transform:' + minuterotate ;
     document.getElementById('minute').style.cssText = minutecss;
     document.getElementById('minute').style.webkitTransform = minuterotate; //对?于úwebkit的?浏ˉ览à器÷,要a这a样ù定¨义?

  },6000)

  //周ü期ú性?改?变?时±钟ó的?位?置?
  setInterval(function(){
      var date = new Date(),
      second = date.getSeconds(),
      minute = date.getMinutes(),
      hour = date.getHours(),
      hourDeg;

      if(hour>12){
          hour = hour -12;
      }
      hourDeg = hour * 30 + minute*30/60;
      var hourtrotate = 'rotate('+hourDeg+'deg)';
      var hcss = '-moz-transform:' + hourtrotate + ';-o-transform:' + hourtrotate + ';-ms-transform:' + hourtrotate;
      document.getElementById('hour').style.cssText = hcss;
      document.getElementById('hour').style.webkitTransform = hourtrotate; //对?于úwebkit的?浏ˉ览à器÷,要a这a样ù定¨义?

   },360000)
</script>
  </head>
  
  <body>
    <div id="clock">
        <div id="dot"></div>
        <div id="second" class="needle">
            <div id="second_needle">
            </div>
        </div>
        <div id="minute" class="needle">
            <div id="minute_needle">
            </div>
        </div>
        <div id="hour" class="needle">
            <div id="hour_needle">
            </div>
        </div>
    </div>
    <div style="margin-left:0px;margin-top:50px;height:500px;padding:10px 10px 10px 10px">
     
     
     <div style="border:1px;border-style:none solid none none;border-color:#cccccc;float:left">
    		<!-- style="color:#f2f2f2;"设置颜色与背景颜色相同 -->
    		<a href="index.jsp" style="color:#f2f2f2;"><img src="img/sichuanligonglogo.jpg" alt=""   style="width:100px;height:90px;"/></a>
    	</div>
    	<!-- “font-family:幼圆,隶书;”根据提供的字体名字查找本机字体库，将会使用能找到的第一个字体库 -->
    	<div style="position:relative;top:15px;left:5px;margin-left: 120px;"><font size="6" style="font-family:幼圆,楷体;">川理宿舍管理系统</font></div>
     
     
     
     
      <table style="height:450px;margin-top:50px;width:100px;">
        <tbody>
         <tr style="">
           <td style="">
            <div id="RenYuanGuanLi"  style="border-radius:10px;float:left;background:#ddee33;padding:10px 10px 10px 10px;height:130px;width:200px"
            onmouseover="$('#RenYuanGuanLi').addClass('kuangkuangfangda');$('#ChaCha').removeClass('QuChaCha');$('#ChaCha').addClass('ChaCha')" 
            onmouseleave="$('#RenYuanGuanLi').removeClass('kuangkuangfangda');$('#ChaCha').removeClass('ChaCha');$('#ChaCha').addClass('QuChaCha')"
            onclick="renyuanclick()"><font size="5" style="font-family:幼圆,楷体,黑体;" color="#FF00FF" >人员管理</font>
            <div id="ChaCha">+</div>
            </div>
            
           </td>
           <td >
           
            <div id="XiYiKaGuanLi" style="border-radius:10px;float:left;margin-left:90px;background:#ddee33;padding:10px 10px 10px 10px;height:130px;width:200px;left:300px;top:0px"
            onmouseover="$('#XiYiKaGuanLi').addClass('kuangkuangfangda')" onmouseleave="$('#XiYiKaGuanLi').removeClass('kuangkuangfangda')"
            onclick="location.href='XiYiKaManege/XiYiKaGuanLi.jsp'"><font size="5" style="font-family:幼圆,楷体,黑体;" color="#FF00FF">洗衣卡系统</font></div>
           
           </td>
         </tr>
         <tr>
          <td>
         
            <div id="JiFenGuanLi" style="border-radius:10px;float:left;left:0px;top:150px;background:#ddee33;padding:10px 10px 10px 10px;height:130px;width:200px"
            onmouseover="$('#JiFenGuanLi').addClass('kuangkuangfangda')" onmouseleave="$('#JiFenGuanLi').removeClass('kuangkuangfangda')"
            onclick="location.href='JiFenManege/JiFenGuanLi.jsp'"><font size="5" style="font-family:幼圆,楷体,黑体;" color="#FF00FF">计分系统</font></div>
         
          </td>
          <td>
          
           <div id="GongWuGuanLi" style="border-radius:10px;margin-left:90px;float:left;top:150px;left:230px;background:#ddee33;padding:10px 10px 10px 10px;height:130px;width:200px"
           onmouseover="$('#GongWuGuanLi').addClass('kuangkuangfangda')" onmouseleave="$('#GongWuGuanLi').removeClass('kuangkuangfangda')"
           onclick="location.href='GongWuManege/GongWuGuanLi.jsp'"><font size="5" style="font-family:幼圆,楷体,黑体;" color="#FF00FF">寝室公物管理</font></div>
         
          </td>
         </tr>
        </tbody>
      </table>
    </div>
  </body>
</html>



















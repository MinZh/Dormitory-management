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
	<link rel="stylesheet" href="css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="css/common1.css" type="text/css"></link>
    <script type="text/javascript" src="jQuery/jquery.min.js"></script>
    <script type="text/javascript" src="jQuery/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="jQuery/jquery.KinSlideshow-1.2.1.js"></script>
	
 <script type="text/javascript">
       $(document).ready(function(){
               $('#deluming').val('');
               $('#MiMa').val('');
             });
      $(document).ready(function(e) {
		/***不需要自动滚动，去掉即可***/
		//time = window.setInterval(function(){
		//	$('.og_next').click();
		//},5000);
		/***不需要自动滚动，去掉即可***/
		linum = $('.mainlist li').length;//图片数量
		w = linum * 222;//ul宽度
		$('.piclist').css('width', w + 'px');//ul宽度
		$('.swaplist').html($('.mainlist').html());//复制内容
		$('.og_next').click(function() {
			if ($('.swaplist,.mainlist').is(':animated')) {
				$('.swaplist,.mainlist').stop(true, true);
			}
			if ($('.mainlist li').length > 3) {//多于3张图片
				ml = parseInt($('.mainlist').css('left'));//默认图片ul位置
				sl = parseInt($('.swaplist').css('left'));//交换图片ul位置
				if (ml<=0 && ml>w * -1) {//默认图片显示时
					$('.swaplist').css({
						left : '666px'
					});//交换图片放在显示区域右侧
					$('.mainlist').animate({
						left : ml - 666 + 'px'
					}, 'fast');//默认图片滚动
					if (ml == (w - 666) * -1) {//默认图片最后一屏时
						$('.swaplist').animate({
							left : '0px'
						}, 'fast');//交换图片滚动
					}
				} else {//交换图片显示时
					$('.mainlist').css({
						left : '666px'
					});//默认图片放在显示区域右
					$('.swaplist').animate({
						left : sl - 666 + 'px'
					}, 'fast');//交换图片滚动
					if (sl == (w - 666) * -1) {//交换图片最后一屏时
						$('.mainlist').animate({
							left : '0px'
						}, 'fast');//默认图片滚动
					}
				}
			}
		});

		$('.og_prev').click(function() {

			if ($('.swaplist,.mainlist').is(':animated')) {
				$('.swaplist,.mainlist').stop(true, true);
			}
			if ($('.mainlist li').length > 3) {
				ml = parseInt($('.mainlist').css('left'));
				sl = parseInt($('.swaplist').css('left'));
				if (ml<=0 && ml>w * -1) {
					$('.swaplist').css({
						left : w * -1 + 'px'
					});
					$('.mainlist').animate({
						left : ml + 666 + 'px'
					}, 'fast');
					if (ml == 0) {
						$('.swaplist').animate({
							left : (w - 666) * -1 + 'px'
						}, 'fast');
					}
				} else {
					$('.mainlist').css({
						left : (w - 666) * -1 + 'px'
					});
					$('.swaplist').animate({
						left : sl + 666 + 'px'
					}, 'fast');
					if (sl == 0) {
						$('.mainlist').animate({
							left : '0px'
						}, 'fast');
					}
				}
			}
		});
	});
	$(document).ready(function() {
		$('.og_prev,.og_next').hover(function() {
			$(this).fadeTo('fast', 0.1);
		}, function() {
			$(this).fadeTo('fast', 0.1);
		});
	});
	/*initKinSlider,fl1TabsSlider*/
	$(function () {
			$("#silderTop").KinSlideshow({ mouseEvent:"mouseover",isHasTitleBar:false,isHasTitleFont:false,btn:{btn_radius:"50px",btn_bgAlpha:1,btn_bgHoverColor:"#e4393c",}  });
            $("#fl1TabsSlider").KinSlideshow({ mouseEvent:"mouseover",isHasTitleBar:false,isHasTitleFont:false,btnAlign:"center",rootWidth:473,btnID:"fl1tabsksbtn2",btn:{btn_bgAlpha:1,btn_bgHoverColor:"#7ABD54",btn_borderHoverColor:"#7ABD54",btnWidth:"36px",btnHeight:"5px",btnFontSize:0} });
    		$("#fl1laSlider").KinSlideshow({ mouseEvent:"mouseover",isHasTitleBar:false,isHasTitleFont:false,btnAlign:"center",rootWidth:209,btnID:"fl1laksbtn2",btn:{btn_bgAlpha:1,btn_bgHoverColor:"#7ABD54",btn_borderHoverColor:"#7ABD54",btnWidth:"36px",btnHeight:"5px",btnFontSize:0} });
    }) ;  
           
		function Login(){
		     var dengluming=$('#deluming').val();
		     var password=$('#MiMa').val();
		  $.getJSON("Login?dengluming="+dengluming+"&password="+password+"&vCode="+$('#vCode').val(),function(result){
  				if(result == 'OK'){
  					location.href = 'Main.jsp';
  				}
  				else if (result == 'vCodeErr'){
  					$('#vCodeBorder').css('border','1 solid');
  					$('#vCodeBorder').css('border-color','red');
  					alert('验证码错误！');
  				}
  				else{
  					alert('登录失败！用户名或密码错误');
  				}
  		    });  	      
		}
		function onVCodeImgClick(){
  			$('#vCodeImg').attr('src',"getVerificationCode?d="+new Date());
  			$('#vCodeImg1').attr('src',"getVerificationCode?d="+new Date());
  		}
	</script>
  </head>
  
  <body ><!-- 设置背景颜色 -->
  	<!-- logo -->
  	<!-- margin:0 auto--设置外边距：0 auto auto auto,对应顺序：上右下左 -->
  	<!-- padding:10px 0--设置内边距：10px 0 0 0,对应顺序：上右下左 -->
    <div style="margin:0 auto;width:990px;height:80px;padding:10px 0">
    	<!-- border-style:none solid none none;边框样式，对应顺序：上右下左，共有样式 -->
    	<div style="border:1px;border-style:none solid none none;border-color:#cccccc;float:left">
    		<!-- style="color:#f2f2f2;"设置颜色与背景颜色相同 -->
    		<a href="index.jsp" style="color:#f2f2f2;"><img src="img/sichuanligonglogo.jpg" alt=""   style="width:100px;height:90px;"/></a>
    	</div>
    	<!-- “font-family:幼圆,隶书;”根据提供的字体名字查找本机字体库，将会使用能找到的第一个字体库 -->
    	<div style="position:relative;top:15px;left:5px;margin-left: 120px;"><font size="6" style="font-family:幼圆,楷体;">川理宿舍管理系统</font></div>
    </div>
    <!-- context -->
    <div style="margin:50px auto;width:890px;height:320px;padding:10px;background-color:#e8e8e8">
    	<div style="width:890px;height:320px;background-color:#ffffff">
    		<div style="float:left">
  
    		     <!-- 中部滑动广告 -->
		<div id="silder">
			<div id="silderTop" style="width:400px;height:320px;">
				
	 			<a target="_blank" title="" href="#"><img src="img/sichuanligong1.jpg" alt=""   style="width:430px;height:320px;"/></a>
	 			<a target="_blank" title="" href="#"><img src="img/sichuanligong2.jpg" alt=""   style="width:430px;height:320px;"/></a>
	 			<a target="_blank" title="" href="#"><img src="img/sichuanligong3.jpg" alt=""   style="width:430px;height:320px;"/></a>
				<a target="_blank" title="" href="#"><img src="img/sichuanligongxueyuan4.jpg" alt=""   style="width:430px;height:320px;"/></a>
	
			</div>
		</div>
		<!-- 中部滑动广告End -->

    		</div>
    		<!-- 账号框 -->
    		<div style="float:left;margin-left:100px;margin-top:40px;color:#999999">
    			<span><font size="2">邮箱/用户名/已验证手机（默认登录名：admin）</font></span>
    			<br/><!-- 换行  -->
    			<input style="border:1px solid;border-color:#cccccc;height:24px;width:284px;" id="deluming">
    		</div>
    		<!-- 密码框 -->
    		<div style="float:left;margin-left:100px;margin-top:20px;color:#999999">
    			<span><font size="2">密码（默认密码：222）</font></span>
    			<br/><!-- 换行  -->
    			<input type="password" style="border:1px solid;border-color:#cccccc;height:24px;width:284px;" id="MiMa"><br/><br/>
    			<span><font size="2">验证码</font></span>
    			<!-- 验证码 -->
    			<div id="vCodeBorder"><input id="vCode" class="easyui-validatebox" data-options="required:true" style="width:125px;height:30px;" 
						type="text">
				<img id="vCodeImg" alt="" src="getVerificationCode" onclick="onVCodeImgClick()" style="width:65px;height:30px">	</div>	
				
    		</div>
    		<!-- 自动登录&忘记密码 -->
    		<div style="float:left;margin-left:100px;margin-top:20px;">
    			<input type="checkbox" style="vertical-align: middle;"><font size="2">自动登录</font>
    			&nbsp;&nbsp;<!-- “&nbsp;”代表一个空格 -->
    			<a><font size="2">忘记密码？</font></a>
    		</div>
    		<!-- 登录按钮 -->
    		<div style="float:left;margin-left:100px;margin-top:10px;">
    			<a  style="border:0;"><img id="loginBtn" src="img/loginBtn.png" 
    			onmouseover="loginBtnOnMouseOver()" 
    			onmouseleave="loginBtnOnMouseLeave()"
    			style="cursor:pointer" onclick="Login()"></img></a>
    		</div>
    	</div>
    </div>
    </body>
</html>
























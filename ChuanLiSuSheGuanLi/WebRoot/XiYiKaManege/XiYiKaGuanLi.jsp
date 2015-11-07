<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>洗衣卡管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<link rel="stylesheet" href="../jquery-easyui-1.3.3/demo/demo.css" type="text/css"></link>
	<link rel="stylesheet" href="jquery-easyui-1.3.3/themes/default/easyui.css" type="text/css"></link>
	<link rel="stylesheet" href="jquery-easyui-1.3.3/themes/icon.css" type="text/css"></link>
    
    
    <script type="text/javascript" >
          $(document).ready(function(){
               $('#frmAddXiYiKa').window('close');
               $('#frmEditXiYiKa').window('close');
               $('#txtSearch').text('请输入您的姓名！');
          });
     function showAddXiYiKa(){
            $('#frmEditXiYiKa').window('close');
  			$('#frmAddXiYiKa').window('open');
  			
  		}
  		
  		function ChaXun_onblur(){	
  		   if($('#txtSearch').text()==''){
  	            $('#txtSearch').text('请输入您的姓名！');
  		
  		} 	
  		}
  		function ChaXun_onclick(){
  		  
  		     if($('#txtSearch').text()=='请输入您的姓名！'){
  	          $('#txtSearch').text('');
  		}	
  		}
  		function AddXiYiKa(){//洗衣卡补办
  		     
  		    var xingMing=$('#xingMing2').val();
  			var xingBie=$('#xingBie2').val();
  			var xueHao=$('#xueHao2').val();
  			var kaHao=$('#kaHao2').val();
  			var qinShiHao=$('#qinShiHao2').val();
  			var dianHua=$('#dianHua2').val();
  			var shenFenZhengHao=$('#shenFenZhengHao2').val();
  			var yuE=$('#yuE2').val();
  		    var url="addXiYiKa?xingMing="+xingMing
                     +"&xingBie="+xingBie+"&xueHao="+xueHao
  	                 +"&kaHao="+kaHao+"&qinShiHao="+qinShiHao
                     +"&dianHua="+dianHua+"&shenFenZhengHao="+shenFenZhengHao
                     + "&yuE="+yuE;
                     $.getJSON(url,function(result){
                     if(result == 'OK'){
  					alert("补办成功!");
  					$('#frmAddXiYiKa').window('close');
  					location.href='XiYiKaManege/XiYiKaGuanLi.jsp';
  				}
         });	
  		}
  		
  		function editXiYiKa(){//修改洗衣卡资料
  		  
  		    var xingMing=$('#xingMing3').val();
  			var xingBie=$('#xingBie3').val();
  			var xueHao=$('#xueHao3').val();
  			var kaHao=$('#kaHao3').val();
  			var qinShiHao=$('#qinShiHao3').val();
  			var dianHua=$('#dianHua3').val();
  			var shenFenZhengHao=$('#shenFenZhengHao3').val();
  			var yuE=$('#yuE3').val();
  		    var url="editXiYiKa?renyuanId="+renyuanId+"&xingMing="+xingMing
                     +"&xingBie="+xingBie+"&xueHao="+xueHao
  	                 +"&kaHao="+kaHao+"&qinShiHao="+qinShiHao
                     +"&dianHua="+dianHua+"&shenFenZhengHao="+shenFenZhengHao
                     + "&yuE="+yuE+"&xiyikaId="+xiyikaId+"&qingshihaoId="+qingshihaoId+"&renyuanxiangxiId="+renyuanxiangxiId;
                     $.getJSON(url,function(result){
                     if(result == 'OK'){
  					alert("修改成功!");
  					 $('#frmEditXiYiKa').window('close');
  					 location.href='XiYiKaManege/XiYiKaGuanLi.jsp';
  				}
         });
  		}
  		
  		function guaShi(){//挂失
  		  alert("请您在挂失之前查询你的信息！！");
  		   var kaHao=$('#kaHao1').val();
  		   var yuE=$('#yuE1').val();
  		   var url="guaShi?xiyikaId="+xiyikaId+"&renyuanId="+renyuanId+"&kaHao="+kaHao+"&yuE="+yuE;
                     $.getJSON(url,function(result){
                     if(result == 'OK'){
  					alert("该卡成功挂失!");
  					
  					location.href='XiYiKaManege/XiYiKaGuanLi.jsp';
  				}
         });
         
  	}
  		
  		function showEditXiYiKa(){
  		    $('#frmAddXiYiKa').window('close');
  			$('#frmEditXiYiKa').window('open');
  			var xingMing3=$('#xingMing1').val();
  			var xingBie3=$('#xingBie1').val();
  			var xueHao3=$('#xueHao1').val();
  			var kaHao3=$('#kaHao1').val();
  			var qinShiHao3=$('#qinShiHao1').val();
  			var dianHua3=$('#dianHua1').val();
  			var shenFenZhengHao3=$('#shenFenZhengHao1').val();
  			var yuE3=$('#yuE1').val();
  			$('#xingMing3').val(xingMing3);
  			$('#xingBie3').val(xingBie3);
  			$('#xueHao3').val(xueHao3);
  			$('#kaHao3').val(kaHao3);
  			$('#qinShiHao3').val(qinShiHao3);
  			$('#dianHua3').val(dianHua3);
  			$('#shenFenZhengHao3').val(shenFenZhengHao3);
  			$('#yuE3').val(yuE3);
  		}
  		
  		var qingshihaoId;
  		var xiyikaId;
  		var renyuanId;
  		var renyuanxiangxiId;
  		function queryOnClick(){//根据姓名查询洗衣卡资料
  		    var xingMing=$("#txtSearch").val();
  	        var url="queryXiYiKaXinXi?xingMing="+xingMing;
  		      $.getJSON(url,function(data){
  		      if(data[0].qingshihaoId){
                 renyuanxiangxiId=data[0].renyuanxiangxiId;
  		         qingshihaoId=data[0].qingshihaoId;
  		         xiyikaId=data[0].xiyikaId;
  		         renyuanId=data[0].renyuanId;
  		         kahao=data[0].kahao;
  		         yuE=data[0].yuE;
                 $('#renYuanId').val(data[0].renyuanId);
	             $('#xingMing1').val(data[0].xingming);
	             $('#xingBie1').val(data[0].xingbie);
	             $('#xueHao1').val(data[0].xuehao);
	             $('#shenFenZhengHao1').val(data[0].shengfenzheng);
	             $('#kaHao1').val(data[0].kahao);
	             $('#qinShiHao1').val(data[0].qingshihaoname);
	             $('#dianHua1').val(data[0].dianhua);
	             $('#yuE1').val(data[0].yuE);
	             }else{
	                alert("该同学的洗衣卡已挂失或者未办理!!!");
	             }
	             
         });
  		}
    </script>
  </head>   
  <body>
    <div class="easyui-layout" style="width:auto;height:620px;">
    <input type="hidden" id="renYuanId" value="0" />
      <!--   north------> 
          <div data-options="region:'north',border:false" style="width:1000px;height:150px;"> 
           <div  style="margin-left:40px;margin-top:30px;"><font color="gray" size="3" ><strong> 川理宿舍管理>>>>洗衣卡管理</strong></font></div>                 
           <!-- 查询 -->
             <div id="search" style="width:600px;height:60px;float:right;margin-right:70px;margin-top:30px;">
			       <div id="divSearch"
				    style="width:500px;height:30px;border:2px solid #E4393C;overflow:visible;background-color:#07D0D8">
				<textarea  id="txtSearch"
					style="float:left;width:416px;height:30px;padding:4px;line-height:20px;" onblur="ChaXun_onblur()" onclick="ChaXun_onclick()"></textarea>
                    <button style="cursor:pointer;width:72px;height:30px;border:0;background-color:#07D0D8;font-size:14px;color:#ffffff;" onclick="queryOnClick()">
                    <strong style="font-size:15px;color:#ffffff;">查询</strong></button>
				</div>
				  <div class="demo-info">
		               <div class="demo-tip icon-tip"></div>
		             <div>测试数据：周敏，文瑶，杨剑飞！！！</div>
	                 </div>	
				
			</div>  
			<!------------------------- 查询 ------------->
			 
          </div>    
        <!-- -north end -- -->
        <!-- -center- -->    
         <div data-options="region:'center'"  style="width:1300px;height:600px;margin-left:80px;">
          <div class="easyui-layout" style="width:1250px;height:465px;">  
           <div data-options="region:'west'" style="width:250px;height:150px;" >
           <table>
            <tr>
               <td><input type="button" id="btnSearch" onclick="guaShi()"
					style="cursor:pointer;width:80px;height:30px;border:0;background-color:#07D0D8;margin-left:50px;
					margin-top:50px;font-size:14px;color:#ffffff;"value="挂失"></input>
			   </td>
			   <tr><tr><tr><tr></tr>  
	      <tr>
	            <td><input type="button" id="btnAdd" onclick="showAddXiYiKa()"
					style="cursor:pointer;width:80px;height:30px;border:0;background-color:#07D0D8;margin-left:50px;
					margin-top:20px;font-size:14px;color:#ffffff;"value="补办"></input>
			   </td>
			   <tr><tr><tr><tr></tr>
	   	
         <tr>
	            <td><input type="button" onclick="showEditXiYiKa()"
					style="width:80px;height:30px;border:0;background-color:#07D0D8;margin-left:50px;
					margin-top:20px;font-size:14px;color:#ffffff;"value="修改"></input>
			   </td>   
         <tr><tr><tr><tr></tr>
         </table>
         </div>  
       
        <!-- 挂失 补办 修改 -->
         <div data-options="region:'center'" style="width:800px;height:auto;" >
         
           <div style="margin-left:50px;width:300px;height:40px;margin-top:20px;"><font size=3>姓名:</font>
                 <input id="xingMing1" type="text" style="margin-left:20px;" readOnly="true"></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>性别:</font>
                <input id="xingBie1" type="text" style="margin-left:20px;" readOnly="true"></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>身份证号:</font>
                <input id="shenFenZhengHao1" type="text" style="margin-left:20px;" readOnly="true"></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>学号:</font>
                <input id="xueHao1" type="text" style="margin-left:20px;" readOnly="true"></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>卡号:</font>
                <input id="kaHao1" type="text" style="margin-left:20px;" readOnly="true"></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>余额:</font>
                <input id="yuE1" type="text" style="margin-left:20px;" readOnly="true"></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>寝室号:</font>
                <input id="qinShiHao1" type="text" style="margin-left:20px;" readOnly="true"></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>电话:</font>
                <input id="dianHua1" type="text" style="margin-left:20px;" readOnly="true"></input></div>
               
         </div> 
    <!-- --------------------------------------挂失 补办 修改 --------------------------------------->         
          
	 <!-------------------------------------------- 查询信息 -------------------------------------->
	 <!-- 图片 -->
         <div data-options="region:'east'" style="width:500px;height:auto;" >
           <img src="img/imgxiyika.jpg"></img>
         
         </div>
        <!-- 图片 -->
       </div>   
     </div>
     

     <!-- <input type="hidden" id="XiYiKaId" value="0" /> -->
     <div id="frmAddXiYiKa" class="easyui-window" title="补办洗衣卡" style="width:618px;height:300px;" 
        	data-options="resizable:false,collapsible:false,minimizable:false,maximizable:false,modal:true">
       <div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>您还未挂失，请挂失后再补办！</div>
	    </div>	
        	<div style="margin-left:50px;width:300px;height:40px;margin-top:20px;"><font size=3>姓名:</font>
                 <input id="xingMing2" type="text" style="margin-left:20px;"></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>卡号:</font>
                <input id="kaHao2" type="text" style="margin-left:20px;" ></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>余额:</font>
                <input id="yuE2" type="text" style="margin-left:20px;" ></input></div>
                 <input type="button" id="btnAdd" onclick="AddXiYiKa()"
					style="cursor:pointer;width:80px;height:30px;border:0;background-color:#07D0D8;margin-left:50px;
					margin-top:20px;font-size:14px;color:#ffffff;"value="保存">
    	</div>
    	<div id="frmEditXiYiKa" class="easyui-window" title="修改资料" style="width:618px;height:auto;" 
    	data-options="resizable:false,collapsible:false,minimizable:false,maximizable:false,modal:true">
    	 <div style="margin-left:50px;width:300px;height:40px;margin-top:20px;"><font size=3>姓名:</font>
                 <input id="xingMing3" type="text" style="margin-left:20px;"></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>性别:</font>
                <input id="xingBie3" type="text" style="margin-left:20px;" ></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>身份证号:</font>
                <input id="shenFenZhengHao3" type="text" style="margin-left:20px;" ></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>学号:</font>
                <input id="xueHao3" type="text" style="margin-left:20px;" ></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>卡号:</font>
                <input id="kaHao3" type="text" style="margin-left:20px;" ></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>余额:</font>
                <input id="yuE3" type="text" style="margin-left:20px;" ></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>寝室号:</font>
                <input id="qinShiHao3" type="text" style="margin-left:20px;" ></input></div>
           <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>电话:</font>
                <input id="dianHua3" type="text" style="margin-left:20px;" ></input></div>
                 <input type="button" id="btnAdd" onclick="editXiYiKa()"
					style="cursor:pointer;width:80px;height:30px;border:0;background-color:#07D0D8;margin-left:50px;
					margin-top:20px;font-size:14px;color:#ffffff;"value="保存">
    	</div>
     <!-- center end  --> 
   </div>
   
   
    </body>
  </html>
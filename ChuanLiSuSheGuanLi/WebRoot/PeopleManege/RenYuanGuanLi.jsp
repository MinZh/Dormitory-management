<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>人员管理</title>
    
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
	<link rel="stylesheet" href="jquery-easyui-1.3.3/themes/default/easyui.css" type="text/css"></link>
	<link rel="stylesheet" href="jquery-easyui-1.3.3/themes/icon.css" type="text/css"></link>
  	<script>
  	
  	$(document).ready(function(){
  			$('#frmAddXiYiKa').window('close');	
  			$('#frmxiugairenyuan').window('close');
  			
  	});  	
  	
  	var qinshihao;
  	var qinshihaoId;
  	function QinShiHaoOnClick(node){	 //点击树节点滴啊出现右边的数据 	
		    var id= node.id;
		    qinshihao=node.text;
		    qinshihaoId=id;
// 		    alert(qinshihao);	   
		     //alert(id);
  		    var url1="getSuSheXinXi?qingshihaoID="+id;
  		   // alert(url1);
  		    $('#SuSheXinXi').datagrid({
  		      url:url1
  		    });  
		}
		
		function onTreeLoadSuccess(){
		    $('#divTree').css("display","");
		    $('#divLoadingTips').css("display","none");
		}
			
				
		function returnBtnColumn(renyuanId,row,rowIndex){//设置DGV里面的操作
		
  		return "<a href='javascript:XinZeng("+renyuanId+","+rowIndex+")'>新增</a> "+
  		"<a href='javascript:xiuGai("+renyuanId+","+rowIndex+")'>修改</a> "+
  		 "<a href='javascript:shanChu("+renyuanId+","+rowIndex+")'>删除</a> ";  	
  			
  	  	}
  	  function XinZeng(renyuanId,rowIndex){  //新增功能		
		 		 	
  		 		$('#frmAddXiYiKa').window('open');	 
// 			 location.href='PeopleManege/RenYuanXiangXi.jsp';
// 				alert(qinshihao);	       
	       	  $('#qinShiHao').val(qinshihao);//绑定寝室号
	       	  		 	
  		}
  		var renyuanID;
  		function xiuGai(renyuanId,rowIndex){  	//点就修改绑定里面的数据	
 		 	//	alert(renyuanId);
  		 	$('#frmxiugairenyuan').window('open');
  		    var renid=$('#SuSheXinXi').datagrid('getRows')[rowIndex]['renyuanId'];
  		 	renyuanID=renid;
  		 	var xingming=$('#SuSheXinXi').datagrid('getRows')[rowIndex]['xingming'];		 	
  		    var xingbie=$('#SuSheXinXi').datagrid('getRows')[rowIndex]['xingbie'];
  		 	var shengfenzheng=$('#SuSheXinXi').datagrid('getRows')[rowIndex]['shengfenzheng'];
  		 	var xuehao=$('#SuSheXinXi').datagrid('getRows')[rowIndex]['xuehao'];
  		 	var dianhua=$('#SuSheXinXi').datagrid('getRows')[rowIndex]['dianhua'];
  		    $('#QinShi').val(qinshihao);
  			$('#XINgMing').val(xingming);  			
  	  	    $('#XINGBie').val(xingbie);
            $('#ShengFenZHeng').val(shengfenzheng);
            $('#XUEHao').val(xuehao);
            $('#DianHua').val(dianhua);
 	
  		
  		}
  		  function EditRenYuanXinXi(){//保存修改
  		   if(confirm('确定修改？')){
//   		   alert(renyuanID);
 	       var qinShiHaoID=qinshihaoId;
	       var xingming = $('#XINgMing').val();	  
// 	       alert(xingming);     
	       var xingbie = $('#XINGBie').val();
	       var shengfenzhenghao = $('#ShengFenZHeng').val();
	       var xuehao = $('#XUEHao').val();       
	       var dianHua = $('#DianHua').val();
	       var url = "EditRenYuanXinXi?renyuanID=" + renyuanID+"&qingshihaoId="+qinShiHaoID+ "&xingming=" + xingming
               + "&xingbie=" + xingbie + "&shengfenzhenghao=" + shengfenzhenghao + "&xuehao=" + xuehao
                + "&dianHua=" + dianHua;
           $.getJSON(url,function(result){
           			alert("修改成功！");     
                    $('#SuSheXinXi').datagrid('reload');  
                });
            }
           }
                  
  		
  		function shanChu(renyuanId,rowIndex){  	//删除	
  			var renyuanID=$('#SuSheXinXi').datagrid('getRows')[rowIndex]['renyuanId'];
  				alert(renyuanID);
  				
  			$.getJSON("deleteQinShiRenYuan?renyuanId="+renyuanID,function(result){
  				if(result=="OK"){
  					alert("删除成功！");
  					$('#SuSheXinXi').datagrid('reload');//刷新DGV
  				}else{
  					alert("删除失败！");
  				}
  			});  		
  		}  		
  		 
	    function AddRenYuanXinXi(){//保存新增
	    
// 	    		alert(qinshihaoId);	    			     	
	       var qinShiHaoID=qinshihaoId;
	       var xingming = $('#xingMing').val();	       
	       var xingbie = $('#xingBie').val();
	       var shengfenzhenghao = $('#shenFenZhengHao').val();
	       var xuehao = $('#xueHao').val();       
	       var dianHua = $('#dianHua').val();
	       var url = "AddRenYuanXinXi?qinshihaoId=" + qinShiHaoID+ "&xingming=" + xingming
               + "&xingbie=" + xingbie + "&shengfenzhenghao=" + shengfenzhenghao + "&xuehao=" + xuehao
                + "&dianHua=" + dianHua;
           $.getJSON(url,function(result){
           			alert("保存成功！");     
                    $('#SuSheXinXi').datagrid('reload');  
//                   $('#frmAddXiYiKa').dgReflash();	
                });
           }
                       
           function GuanBiChuangTi(){  	//关闭窗体	
  		 		$('#frmAddXiYiKa').window('close');	
  		 		$('#SuSheXinXi').datagrid('reload');
  		   } 
  		   function GuanBixiugai(){  		
  		 		$('#frmxiugairenyuan').window('close');	
  		 		$('#SuSheXinXi').datagrid('reload');
  		   }   
  		
  	</script>
  
  
  <body  background="img/50d67aa68120b.jpg" class="easyui-layout" >
   		
   		
   		<div data-options="region:'west'" style="width:250px;height:auto;background-color:#F5FFFA;" 
   			 title="寝室信息"  split="true"  data-options="border:true,collapsible:false"> <!-- 左边的树节点 -->
    		<div id="divTree" style="display:none">
       		 	<ul id="treeDistrict" class="easyui-tree" data-options="url:'getQuYuAll',animate:true,lines:true,onLoadSuccess:onTreeLoadSuccess,onDblClick:QinShiHaoOnClick"></ul>
     	    </div>
    	</div>
    	
    	<div  data-options="region:'center'" style="width:1000;height:auto"> <!-- 右边的一大块 -->
    		<div style="width:200px;height:20px;">测试数据</div>
    		
    	  <table id="SuSheXinXi" class="easyui-datagrid"  style="width:auto;height:auto;"
			data-options="singleSelect:true,scrolling:true,idField:'renyuanId',fit:true">
		     <thead>
			  <tr>			  
<!-- 			  	 <th data-options="field:'qingshihaoId',width:200,hidden:true">寝室号ID</th> -->
			    <th data-options="field:'qingshihaoname',align:'center',width:200">寝室号</th>
			    <th data-options="field:'xingming',align:'center',width:200">学生姓名</th>
			    <th data-options="field:'qingshihaoId',align:'center',width:200,formatter:returnBtnColumn">操作</th>
			    <th data-options="field:'renyuanId',width:200,hidden:true">人员ID</th>
			    <th data-options="field:'xingbie',width:200,hidden:true">性别</th>
			    <th data-options="field:'shengfenzheng',width:200,hidden:true">身份证</th>
			    <th data-options="field:'xuehao',width:200,hidden:true">学号</th>
			    <th data-options="field:'dianhua',width:200,hidden:true">电话</th>
			 </tr>
		    </thead>
		 </table>
    	
    	
    	
    	
    	
    	<!-- 新增窗体的代码 -->
       <div id="frmAddXiYiKa" class="easyui-window" title="新增人员" style="width:620px;height:500px;"  	data-options="resizable:false,
    	    collapsible:false,minimizable:false,maximizable:false,modal:true">	
        		
        <div class="easyui-layout" data-options="fit:true">
         	<div data-options="region:'west'" style="width:400px;height:auto;"  ><!-- background-color:#F5FFFA; -->
         		<div style="margin-left:50px;width:300px;height:40px;margin-top:20px;"><font size=3>姓名:</font>
                 <input id="xingMing" type="text" style="margin-left:40px;"></input></div>                 
          
          		 <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>性别:</font>
                <input id="xingBie" type="text" style="margin-left:40px;" ></input></div>
                
           		<div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>身份证号:</font>
                <input id="shenFenZhengHao" type="text" style="margin-left:11px;" ></input></div>
                
           		<div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>学号:</font>
                <input id="xueHao" type="text" style="margin-left:40px;" ></input></div>
                
           		<div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>寝室号:</font>
                <input id="qinShiHao" type="text" style="margin-left:23px;"  ></input></div>
                
         	    <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>电话:</font>
                <input id="dianHua" type="text" style="margin-left:40px;" ></input></div>
         
         
     		 	<table style="width:300px;height:20px;margin-top:20px;"data-options="border:false">
     			 <tr>
       		  		<td><input type="button" style="background:#00BFFF;margin-left:80px"  onclick="AddRenYuanXinXi()" value="保存(YES)"/></td>
					<td><input type="button" style="background:#00BFFF;margin-left:120px"  onclick="GuanBiChuangTi()" value="关闭(NO)"/></td>
				 </tr>
		 	    </table>
		   </div>     	
         	
         	
         	
         	<div  data-options="region:'east'" style="width:200px;height:200px"><!-- 第二部分 -->
         		
         			<a><img id="zhaopian" src="img/zhaopian.PNG"></img></a>
         			<table style="width:100px;height:20px;margin-top:20px;"data-options="border:false">
     			 <tr>
       		  		<td><input type="button" style="background:#00BFFF;margin-left:10px"  onclick="" value="上传图片"/></td>
					<td><input type="button" style="background:#00BFFF;margin-left:20px"  onclick="" value="删除图片"/></td>
				 </tr>
		 	    </table>
         	</div>
          </div>     	
     	
    	 </div>
    	 	
    	 	
    	 	
    	 	
    	 	<!-- 修改窗体的代码 -->
       <div id="frmxiugairenyuan" class="easyui-window" title="修改人员" style="width:620px;height:500px;"  	data-options="resizable:false,
    	    collapsible:false,minimizable:false,maximizable:false,modal:true">	
        		
        <div class="easyui-layout" data-options="fit:true">
         	<div data-options="region:'west'" style="width:400px;height:auto;"  ><!-- background-color:#F5FFFA; -->
         		<div style="margin-left:50px;width:300px;height:40px;margin-top:20px;"><font size=3>姓名:</font>
                 <input id="XINgMing" type="text" style="margin-left:40px;"></input></div>                 
          
          		 <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>性别:</font>
                <input id="XINGBie" type="text" style="margin-left:40px;" ></input></div>
                
           		<div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>身份证号:</font>
                <input id="ShengFenZHeng" type="text" style="margin-left:11px;" ></input></div>
                
           		<div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>学号:</font>
                <input id="XUEHao" type="text" style="margin-left:40px;" ></input></div>
                
           		<div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>寝室号:</font>
                <input id="QinShi" type="text" style="margin-left:23px;"  ></input></div>
                
         	    <div style="margin-left:50px;width:300px;height:40px;margin-top:15px;"><font size=3>电话:</font>
                <input id="DianHua" type="text" style="margin-left:40px;" ></input></div>
         
         
     		 	<table style="width:300px;height:20px;margin-top:20px;"data-options="border:false">
     			 <tr>
       		  		<td><input type="button" style="background:#00BFFF;margin-left:80px"  onclick="EditRenYuanXinXi()" value="保存(YES)"/></td>
					<td><input type="button" style="background:#00BFFF;margin-left:120px"  onclick="GuanBixiugai()" value="关闭(NO)"/></td>
				 </tr>
		 	    </table>
		   </div>     	
         	
         	
         	
         	<div  data-options="region:'east'" style="width:200px;height:200px"><!-- 第二部分 -->
         		
         			<a><img id="zhaopian" src="img/zhaopian.PNG"></img></a>
         			<table style="width:100px;height:20px;margin-top:20px;"data-options="border:false">
     			 <tr>
       		  		<td><input type="button" style="background:#00BFFF;margin-left:10px"  onclick="" value="上传图片"/></td>
					<td><input type="button" style="background:#00BFFF;margin-left:20px"  onclick="" value="删除图片"/></td>
				 </tr>
		 	    </table>
         	</div>
          </div>     	
     	
    	 </div>
    	 	
    	 	
    	 	
    	 	
    	 	
    	 	
    	 	
    	</div>
    	
    	
    	
  </body>
</html>

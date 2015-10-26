<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公物管理</title>
    
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
    
    
    <script type="text/javascript" >
          $(document).ready(function(){
               $('#quyu').combobox({url:"getquyu"});
          });
   
  	    function onQuYuSelect(){
 	        $('#louming').combobox({url:"getLouMing?quyuid="+$('#quyu').combobox('getValue')});
 	    }
 	    function onLouMingSelect(){
 	        $('#qinshi').combobox({url:"getQinShi?donglouid="+$('#louming').combobox('getValue')});
 	    }
  		function queryOnClick(){
  		    var qinshiid=$('#qinshi').combobox('getValue');
  		    var urla="getwuping?qinshiid="+qinshiid;
  		    $('#jifentable').datagrid({
            url:urla
           });
           
  		}
  	
    </script>
  </head>   
  <body>
      <div style="width:100%;height:100%;background:url(img/50d67aa68120b.jpg);">
      <div class="easyui-layout" style="margin-left:17.5%;width:65%;height:100%;">
        <div data-options="region:'north'" style="width:800px;height:150px;margin-top:20px;">
           <table style="width:800px,height:300px;margin-top:50px;margin-left:100px">
             <tr>
               <td>  区域  <input class="easyui-combobox" id="quyu" name="quyumingcheng"
			          data-options="valueField:'quyuid',textField:'quyumingcheng',onSelect:onQuYuSelect">
			   </td>
              
             
               <td>  楼名  <input class="easyui-combobox" id="louming" name="dongloumingcheng"
			          data-options="valueField:'donglouid',textField:'dongloumingcheng',onSelect:onLouMingSelect">
			   </td>
             
               <td>  寝室  <input class="easyui-combobox" id="qinshi" name="qingshimingcheng"
			          data-options="valueField:'qinshiid',textField:'qinshimingcheng'">
			   </td>
			   <td>
			     <button style="cursor:pointer;width:72px;height:30px;border:0;background-color:#07D0D8;font-size:14px;color:#ffffff;" onclick="queryOnClick()">
                    <strong style="font-size:15px;color:#ffffff;">查询</strong></button>
			   </td>
             </tr>
            </table>
        </div>
        <div data-options="region:'center'" style="width:800px;height:550px;margin-top:20px;">
           <table id="jifentable" class="easyui-datagrid" style="width:750px;"
                  data-options="singleSelect:true,scrolling:true,idField:''" >
                   <thead>
                      <tr>
                        <th data-options="field:'qinshihao',align:'center',width:110">寝室号</th>
                        <th data-options="field:'wupingmingcheng',align:'center',width:110">物品</th>      
                        <th data-options="field:'baoxiu',align:'center',width:110">报修否</th>      
                        <th data-options="field:'baofei',align:'center',width:110">报废否</th>      
                        <th data-options="field:'yajin',align:'center',width:110">押金</th>      
                        <th data-options="field:'beizhu',align:'center',width:150">备注</th>                        
                      </tr>
                   </thead>
                 </table>
        </div>
      </div>
   </div>
  </body>
  </html>
  
  
  
  
  
  
  
  
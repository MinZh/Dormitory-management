<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>计分管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="jquery-easyui-1.3.3/themes/default/easyui.css" type="text/css"></link>
	<link rel="stylesheet" href="jquery-easyui-1.3.3/themes/icon.css" type="text/css"></link>
    <link rel="stylesheet" href="JiFenManege/css/jifen.css" type="text/css"></link>
    <script type="text/javascript" src="jQuery/jquery.min.js"></script> 
    <script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>  
    <script type="text/javascript" >
 		$(function(){
 			var zhoushu="二";
            var url1="getAllJiFen?donglouID="+2+"&zhoushu="+zhoushu;
            $('#jifentable').datagrid({
            url:url1
           });
           startTime();
           
 		});
 		function startTime(){
  	        var today=new Date();
  	        var x="";
  	        var d=today.getDay();
  	        switch(d){
  	            case 0: x="周日";break;
  	            case 1: x="周一";break;
  	            case 2: x="周二";break;
  	            case 3: x="周三";break;
  	            case 4: x="周四";break;
  	            case 5: x="周五";break;
  	            default: x="周六";break;
  	        }
  	        var y=today.getFullYear();
  	        var m=today.getMonth()+1;
  	        var t=today.getDate();
  	        var timer="";
  	        timer=y+"-"+m+"-"+t;
  	        $('#denglushijian').text(timer);
  	        
  	        
  	    }
 	    function onQuYuSelect(){
 	        $('#louming').combobox({url:"getLouMing?quyuid="+$('#quyu').combobox('getValue')});
 	    }
 	    function onLouMingSelect(){
 	        $('#qinshi').combobox({url:"getQinShi?donglouid="+$('#louming').combobox('getValue')});
 	    }
 	    function xinzeng(){
 	        $('#quyu').combobox({url:"getquyu"});
 	        $('#biaohuaanniu').css('visibility','visible');
 	        
 	        $('#xiugai').css('visibility','hidden');
 	        $('#biaohuaanniu').text('保存新增');
 	    }
 	    function xiugai(){
 	        $('#quyu').combobox({url:"getquyu"});
 	        $('#biaohuaanniu').css('visibility','visible');
 	        $('#xinzeng').css('visibility','hidden');
 	        $('#biaohuaanniu').text('保存修改');
 	    }
 	    function baocun(){
 	        var bianhuaming=$('#biaohuaanniu').text();
 	        var qinshiid=$('#qinshi').combobox('getValue');
 	        var zhoushu=$('#zhoushuxuanzhe').combobox('getValue');
 	        var dengji=$('#dengjiSelect').combobox('getValue');
 	        var beizhu=$('#beizhu').val();
 	        if(qinshiid==null||zhoushu==null||dengji==null){
 	            alert("请填写相关信息完整！");
 	        }
 	        else{
 	        var urldengji="adddengji?qinshiid="+qinshiid+"&zhoushu="+zhoushu+"&dengji="+dengji+"&beizhu="+beizhu;
 	        var xiugai="xiugaidengji?qinshiid="+qinshiid+"&zhoushu="+zhoushu+"&dengji="+dengji+"&beizhu="+beizhu;
 	        if(bianhuaming=="保存新增"){ 	        
 	          $.getJSON(urldengji,function(result){
 	            if(result=="OK"){
 	                alert("新增成功");
//  	                $('#biaohuaanniu').text(' ');
//   	                $('#quyu').combobox({url:"qingkong"});
//   	                $('#louming').combobox({url:"qingkong"});
//   	                $('#qinshi').combobox({url:"qingkong"});
//   	                $('#dengjiSelect').combobox('setValue',' '); 	
//   	                $('#beizhu').val(' ');
//   	                $('#biaohuaanniu').css('visibility','hidden');
                        location.href='JiFenManege/JiFenGuanLi.jsp';
                        $('#xiugai').css('visibility','visible');
 	            } else{
 	                alert("新增失败！请重新新增");
 	            } 
 	          });
 	        }else{
 	            $.getJSON(xiugai,function(result){
 	              if(result=="OK"){
//  	                $('#biaohuaanniu').text(' ');
//   	                $('#quyu').combobox({url:"qingkong"});
//   	                $('#louming').combobox({url:"qingkong"});
//   	                $('#qinshi').combobox({url:"qingkong"});
//   	                $('#dengjiSelect').combobox('setValue',' '); 	
//   	                $('#beizhu').text(' ');
  	                alert("修改成功");
  	                location.href='JiFenManege/JiFenGuanLi.jsp';
  	                $('#xinzeng').css('visibility','visible');
//  	                $('#biaohuaanniu').css('visibility','hidden');
 	            } else{
 	                alert("修改失败!请重新修改");
 	            } 
 	          });
 	        }
  	        
//               location.href='JiFenManege/JiFenGuanLi.jsp';
            }
            
 	    }
 	    function myformatter(){
 	        alert("1");
 	    }
 	    	function check(v)
        {
	        //alert(v);
	        var url1="getAllJiFen?donglouID="+2+"&zhoushu="+v;
            $('#jifentable').datagrid({
            url:url1
           });
        }
  		
 	    
 	</script>
    
  </head>
  
  <body>
       <div class="beijing" style="" >
        <table class="table" style="border-color:#2EADCB;float:left" border=2 >
            <tr style="height:60px"> 
              <th>
               <div>汇北   2栋    第<select id="zhoushuxuanzhe1"  name="dengjiSelect" style="width:50px;"
                              onchange=check(this.value)>
                           
                           <option value=一>一</option>
                           <option value=二>二</option>
                           <option value=三>三</option>
                           <option value=四>四</option>
                         </select>周   <font type="text" title="" id="denglushijian" style="width:150px;"></font></div>
              </th>
            </tr>
            <tr style=""> 
              <td>
                 <table id="jifentable" class="easyui-datagrid" style="width:800px;height:500px"
                  data-options="singleSelect:true,scrolling:true,idField:''" >
                   <thead>
                      <tr>
                        <th data-options="field:'dengji',align:'center',width:200">寝室</th>
                        <th data-options="field:'qinshihao',align:'center',width:200">等级</th>                        
                      </tr>
                   </thead>
                 </table>
              </td>
            </tr>
        </table>
        <div style="float:left;width:320px;height:100%">
          <button id="xinzeng" style="background-color:#EEDCAD;width:80px;height:50px;float:left;" onclick="xinzeng()">新增</button>
          <button id="xiugai" style="background-color:#EEDCAD;width:80px;height:50px;float:right;" onclick="xiugai()">修改</button>
          <table style="width:100%;margin-top:80px;">
             <tr>
               <td>  区域  <input class="easyui-combobox" id="quyu" name="quyumingcheng"
			          data-options="valueField:'quyuid',textField:'quyumingcheng',onSelect:onQuYuSelect">
			   </td>
              
             </tr>
             <tr>
               <td>  楼名  <input class="easyui-combobox" id="louming" name="dongloumingcheng"
			          data-options="valueField:'donglouid',textField:'dongloumingcheng',onSelect:onLouMingSelect">
			   </td>
             </tr>
             <tr>
               <td>  寝室  <input class="easyui-combobox" id="qinshi" name="qingshimingcheng"
			          data-options="valueField:'qinshiid',textField:'qinshimingcheng'">
			   </td>
             </tr>
             <tr>
              <td>
                                                  周数  <select id="zhoushuxuanzhe1" class="easyui-combobox" name="dengjiSelect" style="width:50px;"
                              >
                           <option value=" "> </option>
                           <option value="一">一</option>
                           <option value="二">二</option>
                           <option value="三">三</option>
                           <option value="四">四</option>
                         </select>  
             </td>
              </tr>
             <tr>
               <td>  等级  <select id="dengjiSelect" class="easyui-combobox" name="dengjiSelect" style="width:153px">
                           <option value=" "> </option>
                           <option value="A">A</option>
                           <option value="B">B</option>
                           <option value="C">C</option>
                           <option value="D">D</option>
                         </select>
			   </td>
             </tr>
             <tr>
               <td>  备注  <input class="" id="beizhu" name="beizhu" style="">
			   </td>
             </tr>
             <tr>
               <td>
                <button id="biaohuaanniu" style="visibility:hidden;background-color:#EEDCAD;width:80px;height:50px;" onclick="baocun()"></button>
               </td>
             </tr>
          </table>
        </div> 
       </div>
  </body>
</html>












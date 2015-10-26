package SuShe.Action;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import SuShe.pojo.*;
import SuShe.com.Function.encodingFunction;
import SuShe.IService.IRenYuanService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



@SuppressWarnings("serial")
public class RenYuanAction extends baseAction{
	private JSONObject JSObj;
	private JSONArray JSArr;
	private String MSG;
	public JSONObject getJSObj() {
		return JSObj;
	}
	public void setJSObj(JSONObject jSObj) {
		JSObj = jSObj;
	}
	public JSONArray getJSArr() {
		return JSArr;
	}
	public void setJSArr(JSONArray jSArr) {
		JSArr = jSArr;
	}
	public String getMSG() {
		return MSG;
	}
	public void setMSG(String mSG) {
		MSG = mSG;
	}
	private IRenYuanService renYuanService;
	public IRenYuanService getRenYuanService() {
		return renYuanService;
	}
	public void setRenYuanService(IRenYuanService renYuanService) {
		this.renYuanService = renYuanService;
	}
	public String getQuYuAll(){
		List lstProvince=renYuanService.QueryQuYu();
		JSONArray jsArr=new JSONArray();
		JSONObject jsObj=new JSONObject();
		for(int i=0;i<lstProvince.size();i++){
			Object[] obj=(Object[])lstProvince.get(i);
			jsObj.clear();
			jsObj.put("id", obj[0]);
			jsObj.put("text", obj[1]);
			jsObj.put("attributes", "{'lvl':1}");
			if(getLouDongAll(Integer.parseInt(obj[0].toString()))!=null){
				jsObj.put("state", "closed");
				jsObj.put("children",getLouDongAll(Integer.parseInt(obj[0].toString())));
			}
			jsArr.add(jsObj);
		}
	
		HashMap<String,Object> jsMap=new HashMap<String,Object>();//实例化一个哈希映射对象
		jsMap.put("",jsArr);
		JSArr=jsArr;
		return SUCCESS;//返回	
	}

	public JSONArray getLouDongAll(int quyuId){
		JSONObject jsObj=new JSONObject();
		List lstCity=renYuanService.QueryLouDong(quyuId);
		if(lstCity.size()==0){
			return null;
		}else{
			JSONArray childArr=new JSONArray();
			for(int i=0;i<lstCity.size();i++){
				Object[] obj=(Object[])lstCity.get(i);
				jsObj.clear();
				jsObj.put("id", obj[0]);
				jsObj.put("text", obj[1]);
				jsObj.put("attributes", "{'lvl':2}");
				if(getQinShiHao(Integer.parseInt(obj[0].toString()))!=null){
					jsObj.put("state", "closed");
					jsObj.put("children",getQinShiHao(Integer.parseInt(obj[0].toString())));
				}//if
				childArr.add(jsObj);
			}//for
			return childArr;
		}//else
	}
	public JSONArray getQinShiHao(int loudongId){
		JSONObject jsObj=new JSONObject();
		List lstWangDian=renYuanService.QueryQinShiHao(loudongId);
		if(lstWangDian.size()==0){
			return null;
		}else{
			JSONArray childArr=new JSONArray();
			for(int i=0;i<lstWangDian.size();i++){
				Object[] obj=(Object[])lstWangDian.get(i);
				jsObj.clear();
				jsObj.put("id", obj[0]);
				jsObj.put("text", obj[1]);
				jsObj.put("attributes", "{'lvl':4}");
				childArr.add(jsObj);
			}//for
			return childArr;
		}//else
	}

	public String getSuSheXinXi(){
		int qingshihaoID = Integer.parseInt(this.getRequest().getParameter("qingshihaoID").toString());
//		long wangDianId=()		
		List lstQinShi = renYuanService.QueryQinShi(qingshihaoID);
		
		JSONArray jsArr = new JSONArray();
		JSONObject jsObj = new JSONObject();
        for(int i = 0;i<lstQinShi.size();i++){
			Object[] obj = (Object[])lstQinShi.get(i);
			jsObj.clear();
			jsObj.put("qingshihaoId", obj[0]);
			jsObj.put("qingshihaoname", obj[1]);
			jsObj.put("xingming", obj[2]);
			jsObj.put("renyuanId", obj[4]);
			
			jsObj.put("xingbie", obj[5]);
			jsObj.put("shengfenzheng", obj[6]);
			jsObj.put("xuehao", obj[7]);
			jsObj.put("dianhua", obj[8]);
			
//			jsObj.put("actionColumn","删除");
			jsArr.add(jsObj);
        }
        HashMap<String,Object> jsMap = new HashMap<String,Object>();
		jsMap.put("rows", jsArr);
		JSObj = JSONObject.fromObject(jsMap);		
		return SUCCESS;
	}
	
	
	public String deleteQinShiRenYuan(){
		int renyuanID=Integer.parseInt(this.getRequest().getParameter("renyuanId").toString());
		if (this.renYuanService.deletePd(renyuanID)){
			if(this.renYuanService.deletexiangXi(renyuanID))
			{
			this.MSG="OK";}
			else
			{this.MSG="NO";}
		}else{
			this.MSG="NO";//
		}
		return SUCCESS;
	}


	public String AddRenYuanXinXi(){
		
		RenYuanBiao ren=new RenYuanBiao();		
		int qinshihaoId = Integer.parseInt(this.getRequest().getParameter("qinshihaoId").toString().trim());
		String xingming = SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xingming").toString().trim());		
		ren.setQingshihaoId(qinshihaoId);
		ren.setXingming(xingming);
		int renid= this.renYuanService.addRenYuan(ren);
		MSG=renid+"";		
		RenYuanXiangXiBiao renyuanxiangxi=new RenYuanXiangXiBiao();
		String xingbie = SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xingbie").toString().trim());
		String shengfenzhenghao = SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("shengfenzhenghao").toString().trim());
		String xuehao = SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xuehao").toString().trim());
		String dianhua = SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("dianHua").toString().trim());
		renyuanxiangxi.setXingbie(xingbie);
		renyuanxiangxi.setShengfenzheng(shengfenzhenghao);
		renyuanxiangxi.setXuehao(xuehao);
		renyuanxiangxi.setDianhua(dianhua);
		renyuanxiangxi.setRenyuanId(renid);		
		MSG = this.renYuanService.addRenYuanXiangXi(renyuanxiangxi)+"";
		return SUCCESS;
	}

	
	public String EditRenYuanXinXi(){//修改人员信息

		RenYuanBiao ren=new RenYuanBiao();		
		int renyuanid = Integer.parseInt(this.getRequest().getParameter("renyuanID").toString().trim());
		int qingshihaoId = Integer.parseInt(this.getRequest().getParameter("qingshihaoId").toString().trim());
		
		String xingming = SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xingming").toString().trim());		
		
		ren.setRenyuanId(renyuanid);
		ren.setXingming(xingming);
		ren.setQingshihaoId(qingshihaoId);
		MSG= this.renYuanService.editRenYuan(ren)+"";;
		RenYuanXiangXiBiao renyuanxiangxi=new RenYuanXiangXiBiao();
		String xingbie = SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xingbie").toString().trim());
		String shengfenzhenghao = SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("shengfenzhenghao").toString().trim());
		String xuehao = SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xuehao").toString().trim());
		String dianhua = SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("dianHua").toString().trim());
		renyuanxiangxi.setXingbie(xingbie);
		renyuanxiangxi.setShengfenzheng(shengfenzhenghao);
		renyuanxiangxi.setXuehao(xuehao);
		renyuanxiangxi.setDianhua(dianhua);
		MSG = this.renYuanService.editRenYuanXiangXi(renyuanxiangxi)+"";
		return SUCCESS;
	}
	

	
	
	
}






















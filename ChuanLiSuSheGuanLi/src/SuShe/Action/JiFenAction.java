package SuShe.Action;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;

import SuShe.com.Function.encodingFunction;
import SuShe.IService.IJiFenService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import SuShe.pojo.*;


@SuppressWarnings("serial")
public class JiFenAction extends baseAction{
	private JSONObject JSObj;
	private JSONArray JSArr;
	private String MSG;
	private IJiFenService jiFenService;
	public IJiFenService getJiFenService() {
		return jiFenService;
	}
	public void setJiFenService(IJiFenService jiFenService) {
		this.jiFenService = jiFenService;
	}
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
	
	
	
	
	public String getAllJiFen(){
		int donglouID = Integer.parseInt(this.getRequest().getParameter("donglouID").toString().trim());
		String zhoushu =encodingFunction.getMethodEncoding(this.getRequest().getParameter("zhoushu").toString().trim());
		
		List jifen = this.jiFenService.queryAllJiFen(donglouID,zhoushu);
		JSONArray jsArr = new JSONArray();
		JSONObject jsObj = new JSONObject();
		for(int i = 0;i<jifen.size();i++){
			Object[] obj = (Object[])jifen.get(i);
			jsObj.clear();
			jsObj.put("qinshihao", obj[1].toString().trim());
			jsObj.put("dengji", obj[0].toString().trim());
			jsArr.add(jsObj);
		}
		HashMap<String,Object> jsMap = new HashMap<String,Object>();
		jsMap.put("rows", jsArr);
		JSObj = JSONObject.fromObject(jsMap);
		return SUCCESS;
	}
	public String getquyu(){
		List quyu=this.jiFenService.queryAllQuYu();
		JSONArray jsArr = new JSONArray();
		JSONObject jsObj = new JSONObject();
		for(int i = 0;i<quyu.size();i++){
			Object[] obj = (Object[])quyu.get(i);
			jsObj.clear();
			jsObj.put("quyuid", obj[0]);
			jsObj.put("quyumingcheng", obj[1]);
			jsArr.add(jsObj);
		}
		JSArr = jsArr;
		return SUCCESS;
	}
	public String getLouMing(){
		int quyuid = Integer.parseInt(this.getRequest().getParameter("quyuid").toString().trim());
		List quyu=this.jiFenService.queryLouMingByQuYuId(quyuid);
		JSONArray jsArr = new JSONArray();
		JSONObject jsObj = new JSONObject();
		for(int i = 0;i<quyu.size();i++){
			Object[] obj = (Object[])quyu.get(i);
			jsObj.clear();
			jsObj.put("donglouid", obj[0]);
			jsObj.put("dongloumingcheng", obj[1]);
			jsArr.add(jsObj);
		}
		JSArr = jsArr;
		return SUCCESS;
	}
	public String getQinShi(){
		int donglouid = Integer.parseInt(this.getRequest().getParameter("donglouid").toString().trim());
		List qinshibiao=this.jiFenService.queryQinShiHaoByDongLouId(donglouid);
		JSONArray jsArr = new JSONArray();
		JSONObject jsObj = new JSONObject();
		for(int i = 0;i<qinshibiao.size();i++){
			Object[] obj = (Object[])qinshibiao.get(i);
			jsObj.clear();
			jsObj.put("qinshiid", obj[0]);
			jsObj.put("qinshimingcheng", obj[1]);
			jsArr.add(jsObj);
		}
		JSArr = jsArr;
		return SUCCESS;
	}
	public String qingkong(){
		JSONArray jsArr = new JSONArray();
		JSArr = jsArr;
		return SUCCESS;
	}
	public String adddengji(){
		int qinshiid = Integer.parseInt(this.getRequest().getParameter("qinshiid").toString().trim());
		String zhoushu =encodingFunction.getMethodEncoding(this.getRequest().getParameter("zhoushu").toString().trim());
		String dengji =encodingFunction.getMethodEncoding(this.getRequest().getParameter("dengji").toString().trim());
		String beizhu =encodingFunction.getMethodEncoding(this.getRequest().getParameter("beizhu").toString().trim());
		JiFenBiao jifen=new JiFenBiao();
		jifen.setQingshihaoId(qinshiid);
		jifen.setZhoushu(zhoushu);
		jifen.setDengji(dengji);
		jifen.setBeizhu(beizhu);
		int fanhuizhi=this.jiFenService.addQinShiDengJi(jifen);
		if(fanhuizhi>0){
		   this.MSG="OK";	
		}else{
			this.MSG="NO";
		}
		return SUCCESS;
	}
	public String xiugaidengji(){
		int qinshiid = Integer.parseInt(this.getRequest().getParameter("qinshiid").toString().trim());
		String zhoushu =encodingFunction.getMethodEncoding(this.getRequest().getParameter("zhoushu").toString().trim());
		String dengji =encodingFunction.getMethodEncoding(this.getRequest().getParameter("dengji").toString().trim());
		String beizhu =encodingFunction.getMethodEncoding(this.getRequest().getParameter("beizhu").toString().trim());
		if(this.jiFenService.editJiFenBiao(qinshiid, zhoushu, dengji, beizhu)){
			this.MSG="OK";
		}else{
			this.MSG="NO";
		}
		return SUCCESS;
	}
	
	
	public String getwuping(){
		int qinshiid = Integer.parseInt(this.getRequest().getParameter("qinshiid").toString().trim());
		
		List wupin = this.jiFenService.queryQinShiWuPing(qinshiid);
		JSONArray jsArr = new JSONArray();
		JSONObject jsObj = new JSONObject();
		for(int i = 0;i<wupin.size();i++){
			Object[] obj = (Object[])wupin.get(i);
			jsObj.clear();
			jsObj.put("qinshihao", obj[0].toString().trim());
			jsObj.put("wupingmingcheng", obj[1].toString().trim());
			if(obj[2].toString()=="false"){
				jsObj.put("baoxiu","·ñ");
			}else{
			    jsObj.put("baoxiu","ÊÇ");
			}
			if(obj[3].toString()=="false"){
				jsObj.put("baofei","·ñ");
			}else{
			    jsObj.put("baofei","ÊÇ");
			}
			jsObj.put("yajin", obj[4].toString().trim());
			jsObj.put("beizhu", obj[5].toString().trim());
			jsArr.add(jsObj);
		}
		HashMap<String,Object> jsMap = new HashMap<String,Object>();
		jsMap.put("rows", jsArr);
		JSObj = JSONObject.fromObject(jsMap);
		return SUCCESS;
	}

}
























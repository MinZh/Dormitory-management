package SuShe.Action;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import SuShe.pojo.*;

import SuShe.com.Function.encodingFunction;
import SuShe.pojo.RenYuanBiao;
import SuShe.pojo.RenYuanXiangXiBiao;
import SuShe.IService.IXiYiKaService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class XiYiKaAction extends baseAction {
	private JSONObject JSObj;
	private JSONArray JSArr;
	private String MSG;
	private IXiYiKaService xiYiKaService;
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
	public IXiYiKaService getXiYiKaService() {
		return xiYiKaService;
	}
	public void setXiYiKaService(IXiYiKaService xiYiKaService) {
		this.xiYiKaService = xiYiKaService;
	}
public String queryXiYiKaXinXi(){//获取产品资料
		
		String xingMing=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xingMing").trim());
		
//		int renYuanId=Integer.parseInt(this.getRequest().getParameter("renYuanId").trim());
        List cpzl = xiYiKaService.QueryXiYiKaXinXi(xingMing);
		JSONArray jsArr = new JSONArray();
		JSONObject jsObj = new JSONObject();
		for(int i = 0;i<cpzl.size();i++){
			Object[] obj = (Object[])cpzl.get(i);
			jsObj.clear();
			jsObj.put("renyuanId", obj[0]);
			jsObj.put("xingming", obj[1]);
			jsObj.put("qingshihaoId", obj[2]);
			jsObj.put("qingshihaoname", obj[3]);
			jsObj.put("renyuanxiangxiId", obj[4]);
			jsObj.put("xingbie", obj[5]);
			jsObj.put("shengfenzheng", obj[6]);
			jsObj.put("xuehao", obj[7]);
			jsObj.put("dianhua", obj[8]);
			jsObj.put("yuE", obj[9]);
			jsObj.put("kahao", obj[10]);
			jsObj.put("xiyikaId", obj[11]);
			jsObj.put("zuofeifou", obj[12]);
			jsArr.add(jsObj);
		}
		
		JSArr=jsArr;		
		return SUCCESS;
    }
	
   public String guaShi(){
	   String yuE=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("yuE").trim());
	   String kaHao=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("kaHao").trim());
	   int renyuanId=Integer.parseInt(this.getRequest().getParameter("renyuanId").toString().trim());  
	   int xiyikaId=Integer.parseInt(this.getRequest().getParameter("xiyikaId").toString().trim());
	   List<XiYiKa> xiyikaxinxi=xiYiKaService.Queryxiyikaxinxi(xiyikaId);
	   XiYiKa xiyika=new XiYiKa();
	   xiyika.setZuofeifou(true);
	   xiyika.setKahao(kaHao);
	   xiyika.setYuE(yuE);
	   xiyika.setXiyikaId(xiyikaId);
	   xiyika.setRenyuanId(renyuanId);
	   this.xiYiKaService.modifyXiYiKa(xiyika);
	   
	  MSG="OK";
      return SUCCESS;
   }
	
  public String editXiYiKa(){//xiyikaId
	    int renyuanxiangxiId=Integer.parseInt(this.getRequest().getParameter("renyuanxiangxiId").toString().trim());
	    int qingshihaoId=Integer.parseInt(this.getRequest().getParameter("qingshihaoId").toString().trim());
		int renyuanId=Integer.parseInt(this.getRequest().getParameter("renyuanId").toString().trim());
		int xiyikaId=Integer.parseInt(this.getRequest().getParameter("xiyikaId").toString().trim());
		String xingMing=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xingMing").trim());
		String xingBie=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xingBie").trim());
		String xueHao=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xueHao").trim());
		String kaHao=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("kaHao").trim());
//		String qinShiHao=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("qinShiHao").trim());
		String dianHua=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("dianHua").trim());
		String shenFenZhengHao=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("shenFenZhengHao").trim());
		String yuE=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("yuE").trim());
		 
		RenYuanBiao renyuanbiao=new RenYuanBiao();
		RenYuanXiangXiBiao renyuanxiangxibiao=new RenYuanXiangXiBiao();
		XiYiKa xiyika=new XiYiKa();
		List renyuanbiaoxinxi=xiYiKaService.Queryrenyuan(renyuanId);
		List renyuanxiangxibiaoxinxi=xiYiKaService.Queryrenyuanxiangxi(renyuanId);
		List xiyikaxinxi=xiYiKaService.Queryxiyika(renyuanId);
		
		renyuanbiao.setQingshihaoId(qingshihaoId);
		renyuanbiao.setRenyuanId(renyuanId);
		renyuanbiao.setXingming(xingMing);
		renyuanxiangxibiao.setRenyuanxiangxiId(renyuanxiangxiId);
		renyuanxiangxibiao.setDianhua(dianHua);
		renyuanxiangxibiao.setRenyuanId(renyuanId);
		renyuanxiangxibiao.setShengfenzheng(shenFenZhengHao);
		renyuanxiangxibiao.setXingbie(xingBie);
		renyuanxiangxibiao.setXuehao(xueHao);
		xiyika.setYuE(yuE);
		xiyika.setKahao(kaHao);
		xiyika.setRenyuanId(renyuanId);
		xiyika.setXiyikaId(xiyikaId);
		xiyika.setZuofeifou(false);
		this.xiYiKaService.modifyRenYuanXiangXi(renyuanxiangxibiao);
		this.xiYiKaService.modifyRenYuan(renyuanbiao);
		this.xiYiKaService.modifyXiYiKa(xiyika);

        MSG="OK";
        return SUCCESS;

	}
	
  public String addXiYiKa(){
	   
	    String xingMing=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xingMing").trim());
		String xingBie=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xingBie").trim());
		String xueHao=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("xueHao").trim());
		String kaHao=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("kaHao").trim());
//		String qinShiHao=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("qinShiHao").trim());
		String dianHua=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("dianHua").trim());
		String shenFenZhengHao=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("shenFenZhengHao").trim());
		String yuE=SuShe.com.Function.encodingFunction.getMethodEncoding(this.getRequest().getParameter("yuE").trim());
		List xinxi = xiYiKaService.QueryaddXinXi(xingMing);
		JSONArray jsArr = new JSONArray();
		JSONObject jsObj = new JSONObject();
		int renyuanId = 0;
		for(int i = 0;i<xinxi.size();i++){
			Object[] obj = (Object[])xinxi.get(i);
			jsObj.clear();
			 renyuanId=(Integer) obj[0];
		}
		    XiYiKa xiyika=new XiYiKa();
			xiyika.setRenyuanId(renyuanId);
			xiyika.setKahao(kaHao);
			xiyika.setYuE(yuE);
			xiyika.setZuofeifou(false);
			this.xiYiKaService.addXiYiKa(xiyika);
	       MSG="OK";
		   return SUCCESS;
		
  }
	
	
}

package SuShe.Action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import SuShe.IService.ILoginService;
import SuShe.pojo.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class LoginAction extends baseAction {
	private JSONObject JSObj;
	private JSONArray JSArr;
	private String MSG;
	private ILoginService loginService;
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
	public ILoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
  public String Login(){
		
		String dengluming=SuShe.com.Function.encodingFunction.getMethodEncoding( this.getRequest().getParameter("dengluming"));
		String password=SuShe.com.Function.encodingFunction.getMethodEncoding( this.getRequest().getParameter("password"));
		List loginxinxi=this.loginService.Login(dengluming, password);
		String vCode=this.getRequest().getParameter("vCode").toLowerCase();
		if(ActionContext.getContext().getSession().get("randomImg").toString().toLowerCase().equals(vCode)){
		if(loginxinxi.size()>0){
//			this.getSession().setAttribute("dengluming", dengluming);
//			this.getSession().setAttribute("password", password);
			this.MSG="OK";
		}else{
			this.MSG="NO";	
		}
	}
	else{
		 if(!dengluming.equals("")&& !password.equals("")){
			this.MSG="vCodeErr"; 
		 }

	}
        return SUCCESS;  
	}
}

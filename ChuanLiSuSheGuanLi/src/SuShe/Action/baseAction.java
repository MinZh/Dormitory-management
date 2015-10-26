package SuShe.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;


import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public abstract class baseAction extends ActionSupport implements ServletRequestAware {
    private HttpServletRequest request;
    private HttpSession session;
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
		this.session=this.request.getSession();                        //get session for client
		/* ApplicationContext context = new ClassPathXmlApplicationContext(
	                "applicationContext.xml");
		 serviceClientInfo = (IClientInfoService) context
	                .getBean("ClientInfoTran");
		 serviceLogin=(ILoginService) context.getBean("LoginServiceTran");
		 serviceWuLiu=(IWuLiuService) context.getBean("WuLiuTran");*/
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
}

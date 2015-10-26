package SuShe.Filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
public class Encoding extends HttpServlet implements Filter {

	private FilterConfig config=null;
	private String encoding="";
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)arg0;
		HttpServletResponse res=(HttpServletResponse)arg1;
		arg0.setCharacterEncoding(this.encoding);
		arg1.setCharacterEncoding(this.encoding);
		//java.io.PrintWriter out=res.getWriter();
		//out.print("过滤器编码为"+this.encoding+"过滤器名称为："+this.config.getFilterName());
		arg2.doFilter(req, res);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.config=arg0;
		this.encoding=config.getInitParameter("encoding");
	}

}

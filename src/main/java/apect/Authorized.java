package apect;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import security.User;
import freemarker.log.Logger;

 
public class Authorized implements Filter {
	
	Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	 

	public void destroy() { 
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
		FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)req).getSession();
		String url = ((HttpServletRequest)req).getRequestURI(); 
	//	if(User.isLogged) {
			//(url.equals("/") || url.contains("/login")		
			HttpServletResponse response = (HttpServletResponse) resp;
			response.getWriter().write("Not logged");
			response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
			response.sendRedirect("http://localhost:8081/login");		
	//	}
		if(!session.isNew())
			chain.doFilter(req, resp);
		else {
			log.info("-------------LOG AUTHORIZED: else option accure---------------"); 
			chain.doFilter(req, resp);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}

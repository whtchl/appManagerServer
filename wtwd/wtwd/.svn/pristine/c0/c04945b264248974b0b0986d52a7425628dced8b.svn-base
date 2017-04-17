package com.cncoman.product.filter;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cncoman.product.bean.UserInfo;
import com.cncoman.product.bean.ResourceInfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SecurityInterceptor extends AbstractInterceptor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		UserInfo user = (UserInfo) session.get("SESSION_USER");
		HttpServletRequest req = ServletActionContext.getRequest();
		String url = req.getRequestURI();
		url = url.indexOf(".") != -1 ? url.substring(0, url.indexOf(".")) : url;
		HttpServletResponse response = ServletActionContext.getResponse();
		if(user == null){			
			response.setHeader("Pragma","No-cache"); 
		    response.setHeader("Cache-Control","no-cache");
		    response.setHeader("Cache-Control", "no-store");
		    response.setDateHeader("Expires", 0);
			return Action.LOGIN;
		}
		
		if(user.getRole().getIntId() == 1)
			return invocation.invoke();
		List<ResourceInfo> resourceList = user.getRole().getResourceList();
		ResourceInfo resource = new ResourceInfo();
		resource.setUrl(url);
		if(!resourceList.contains(resource)){
			response.setHeader("Pragma","No-cache"); 
		    response.setHeader("Cache-Control","no-cache");
		    response.setHeader("Cache-Control", "no-store");
		    response.setDateHeader("Expires", 0);
			return Action.ERROR;
		}
		return invocation.invoke();
	}

}

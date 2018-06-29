package com.help.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.help.Iservice.IActivityService;
import com.help.Iservice.IUserService;
import com.opensymphony.xwork2.ActionSupport;


public class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{

	// map
	protected Map<String, Object> request;	// 保存struts在运行时期注入的表示request的map
	protected Map<String, Object> session;	// 保存struts在运行时期注入的表示session的map
	protected Map<String, Object> application;	// 保存struts在运行时期注入的表示application的map
	
	// Service
	// 注入Service对象
	
	protected IActivityService activityservice;
	protected IUserService userService;
	

	public IActivityService getActivityservice() {
		return activityservice;
	}
	public void setActivityservice(IActivityService activityservice) {
		this.activityservice = activityservice;
	}
	
	
	
	
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

}
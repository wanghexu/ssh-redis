package com.help.action;


import org.apache.struts2.ServletActionContext;

import com.help.information.User;

import com.opensymphony.xwork2.ModelDriven;



public class UserAction extends BaseAction implements ModelDriven<User>{
	User user =new User();

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	public String registuser(){
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
          
		return null;
	}
	

	


}

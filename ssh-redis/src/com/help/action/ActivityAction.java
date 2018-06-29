package com.help.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.help.information.Activity;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;

public class ActivityAction extends BaseAction implements ModelDriven<Activity>{
	
	private Activity activity =new Activity();
		
	public Activity getModel() {
		// TODO Auto-generated method stub
		return activity;
	}
	
	//获取所有活动
	public String getAllactivity(){
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");		
		List<Activity> activity = activityservice.getAll();
		 String json = JSONArray.fromObject(activity).toString();
		 try {
				ServletActionContext.getResponse().getWriter().println(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "success";
		
	}
   
	//获取活动根据类型
	public String getactbytypeid(){
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");		
        
		System.out.println("id是"+this.getModel().getTypeid());
		List<Activity> activity = activityservice.findbytypeid(this.getModel().getTypeid());
	    String json = JSONArray.fromObject(activity).toString();
		//JSONArray json = JSONArray.fromObject(activity);
		System.out.println(json);
		
		try {
			ServletActionContext.getResponse().getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;	
	}
	
	//获取活动根据id
	public String getactbyid(){
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");		
        
		System.out.println("id是"+this.getModel().getActivityid());
		Activity activity = activityservice.findById(this.getModel().getActivityid());
	    String json = JSONArray.fromObject(activity).toString();
		//JSONArray json = JSONArray.fromObject(activity);
		System.out.println(json);
		
		try {
			ServletActionContext.getResponse().getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;	
	}

	
	
	
}

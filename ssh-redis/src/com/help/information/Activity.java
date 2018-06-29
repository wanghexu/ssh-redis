package com.help.information;

import java.sql.Timestamp;

public class Activity {
	
	//��������
	
	
	private int activityid;
	private int typeid;
	private String title;
	private String content;
	private String price;
	private String photourl;
	private String intime;
	private String starttime;
	private int state;
	
	private String hot;
	private String scenery;
	private String trip;
	private String pricedetail;
	private String pricedetail2;
	
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	//�״̬
	
	
	public int getActivityid() {
		return activityid;
	}
	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPhotourl() {
		return photourl;
	}
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getHot() {
		return hot;
	}
	public void setHot(String hot) {
		this.hot = hot;
	}
	public String getScenery() {
		return scenery;
	}
	public void setScenery(String scenery) {
		this.scenery = scenery;
	}
	public String getTrip() {
		return trip;
	}
	public void setTrip(String trip) {
		this.trip = trip;
	}
	public String getPricedetail() {
		return pricedetail;
	}
	public void setPricedetail(String pricedetail) {
		this.pricedetail = pricedetail;
	}
	
	public String getPricedetail2() {
		return pricedetail2;
	}
	public void setPricedetail2(String pricedetail2) {
		this.pricedetail2 = pricedetail2;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	
}

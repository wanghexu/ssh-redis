package com.help.information;

public class User {
    private int userid;
    private String username;
    private String userkey;
    private String imgurl;
    private String con;   //其他内容
    private int prizenum;//用户的金额
    private int prizescore;//用户积分
    
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserkey() {
		return userkey;
	}
	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public int getPrizenum() {
		return prizenum;
	}
	public void setPrizenum(int prizenum) {
		this.prizenum = prizenum;
	}
	public int getPrizescore() {
		return prizescore;
	}
	public void setPrizescore(int prizescore) {
		this.prizescore = prizescore;
	}



	
    
}

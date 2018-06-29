package com.help.Idao;

import java.util.List;

import com.help.information.User;

public interface UserIdao {
		//添加用户信息
		public void adduser(User user) throws Exception;
		//判断是否存在该账号
		public User registuser(String userkey);
		//判断是否存在该账号
		public boolean updateusername(String userkey,String username) throws Exception;
		//返回用户id
		public int getbackid(String userkey) throws Exception;
}
package com.help.Idao;

import java.util.List;

import com.help.information.User;

public interface UserIdao {
		//����û���Ϣ
		public void adduser(User user) throws Exception;
		//�ж��Ƿ���ڸ��˺�
		public User registuser(String userkey);
		//�ж��Ƿ���ڸ��˺�
		public boolean updateusername(String userkey,String username) throws Exception;
		//�����û�id
		public int getbackid(String userkey) throws Exception;
}
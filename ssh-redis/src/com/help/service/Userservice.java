package com.help.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.help.Idao.UserIdao;
import com.help.Iservice.IActivityService;
import com.help.Iservice.IUserService;
import com.help.information.User;



@Transactional
public class Userservice implements IUserService{
    private UserIdao userdao;


	public UserIdao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserIdao userdao) {
		this.userdao = userdao;
	}

	/**
	 * �����û�
	 * @return
	 * @throws Exception 
	 */
     public boolean adduser(User user) throws Exception{
		
		try{
			
			this.userdao.adduser(user);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
     /**
 	 * ͨ����openid�ǳ����ж��Ƿ���ڸ��û��������ڷ���true����֮���򷵻�false
 	 * @param stuNick
 	 * @return
 	 */
 	public boolean registuser(String userkey){
 		if(userdao.registuser(userkey)!=null)
 				return false;
 		return true;
 	}
 	/**
	 * �û�����΢�����ֵķ���
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public boolean updateusername(String userkey,String username) throws Exception{
		
		try{
			
			if(this.userdao.updateusername(userkey, username));
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	//��ȡ�û�id
	public int getbackid(String userkey) throws Exception{
		return this.userdao.getbackid(userkey);
	}
	@Override
	public void save(User t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

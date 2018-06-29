package com.help.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.help.Idao.UserIdao;
import com.help.information.User;


public class Userdao extends HibernateDaoSupport implements UserIdao{

	
	public void adduser(User user) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

	public User registuser(String userkey) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		//��map��name value����Ҫʵ�ã����߼����������Ҫ��̬��ѯ�ֶε������ֵ�Ĳ����������ѯ�б�ȥ��ѯ
		criteria.add(Restrictions.eq("userkey", userkey));
		List<User> userList=(List<User>)this.getHibernateTemplate().findByCriteria(criteria);
		if(userList.size()>0)
			return userList.get(0);
		else 
			return null;
	}

	public boolean updateusername(String userkey, String username) throws Exception {
		// TODO Auto-generated method stub
		List<User> userlist= (List<User>) this.getHibernateTemplate().find("from User user where userkey='"+userkey+"'");
		int id=userlist.get(0).getUserid();
		System.out.println("id��"+id);
		//�ж������Ƿ���ͬ����ͬ�����޸�,��ͬ�޸�
		if(userlist.get(0).getUsername()!=username)
		{
		  User user = this.getHibernateTemplate().get(User.class, id);
		  //�޸�username
		  user.setUsername(username);
		  this.getHibernateTemplate().update(user);
		}
		
		return true;
	}

	@Override
	public int getbackid(String userkey) throws Exception {
		// TODO Auto-generated method stub
		List<User> userlist= (List<User>) this.getHibernateTemplate().find("from User user where userkey='"+userkey+"'");
		int id=userlist.get(0).getUserid();
		return id;
	}

	
	
	
}




package com.help.service;

import java.io.Serializable;
import java.util.List;

import com.help.Idao.IActivityDao;
import com.help.Iservice.IActivityService;
import com.help.information.Activity;

public class ActivityService implements IActivityService{
	
	private IActivityDao activityDao;
	
	
	public IActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(IActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	
	public void save(Activity t) {
		// TODO Auto-generated method stub
		activityDao.save(t);
		
		
	}

	public void update(Activity t) {
		// TODO Auto-generated method stub
		activityDao.update(t);
		
	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		activityDao.delete(id);
		
	}

	public Activity findById(Serializable id) {
		// TODO Auto-generated method stub
		return activityDao.findById(id);
	}

	public List<Activity> getAll() {
		// TODO Auto-generated method stub
		
		return activityDao.getAll();
	}

	public List<Activity> findbytypeid(int typeid) {
		
		String hql = "from Activity where typeid=?";
//		System.out.println(typeid);
		List<Activity> list =activityDao.getByCondition(hql,typeid);
		return list;
	
	}

	
	
	
	
}

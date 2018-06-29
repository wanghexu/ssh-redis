package com.help.Iservice;

import java.util.List;
import java.util.Set;

import com.help.information.Activity;

public interface IActivityService extends IBaseService<Activity> {
	public List<Activity> findbytypeid(int typeid);
	
}

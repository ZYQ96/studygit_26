package com.yc.dao;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LoginDAO {
	/**
	 * 教师登录
	 * @param name：教师名称
	 * @param pwd：登录密码
	 * @return
	 * @throws SQLException
	 * @throws FileNotFoundException 
	 */
	public Map<String, Object> login(String name,String pwd) throws SQLException, FileNotFoundException{
		DbHelper db=new DbHelper();
		Map<String, Object> map=new HashMap<String,Object>();
		String sql="select * from Logins where Lo_id=? and Lo_name=?";
		List<Object> params=new ArrayList<Object>();
		params.add(name);
		params.add(pwd);
		map=db.findSingleObject(sql, params);
		return map;
	}
}

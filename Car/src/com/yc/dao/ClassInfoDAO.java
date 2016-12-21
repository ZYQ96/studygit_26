package com.yc.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ClassInfoDAO {
	public List<Map<String,Object>> findAllClassInfo() throws IOException, SQLException{
		String sql="select * from classInfo";
		DbHelper db=new DbHelper();
		List<Map<String,Object>> list=db.findMultiObject(sql, null);
		return list;
		
	}
}

package com.yc.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Composite;


public class StudentDAO {
	DbHelper db=new DbHelper();
	public Map<String, Object> login(int stuName,String pwd) throws SQLException, FileNotFoundException{
		
		Map<String, Object> map=new HashMap<String,Object>();
		String sql="select * from student where stu_id=? and stu_pwd=?";
		List<Object> params=new ArrayList<Object>();
		params.add(stuName);
		params.add(pwd);
		map= db.findSingleObject(sql, params);
		return map;
		
	}
	
	/**
	 * 学生信息注册
	 * @param params
	 * @param file
	 * @return
	 * @throws FileNotFoundException 
	 */
	public boolean registerStudent(List<Object> params) throws FileNotFoundException{
		String sql="insert into student values(seq_stu_id.nextval,?,?,default,?,?,?,sysdate)";
		//String sql2="update tabel_name set stu_image=? where stu_id=?";
		//插入基本信息
		int i = 0;
		try {
			i = db.doUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(i>0){//插入成功修改图片信息
			//获取到最大ID  查询操作
			return true;
		}else{
			//删除当前数据
			return false;
		}
		
	}
	
	/**
	 * 查看所有
	 * @return
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	public  List<Map<String,Object>> findAllStudent() throws IOException, SQLException{
		String sql="select stu_id,stu_name,stu_sex,stu_pwd,stu_addr,stu_img,to_char(school_date,'yyyy-MM-dd') school_date,"+
				"class_name,c.class_id from student s inner join classinfo c on s.class_id=c.class_id ";
		return db.findMultiObject(sql, null);
	}
	
	/**
	 * 根据学号查询
	 * @param stu_id
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public List<Map<String, Object>> findStudentByID(int stu_id) throws IOException, SQLException{
		String sql="select stu_id,stu_name,stu_sex,stu_pwd,stu_addr,stu_img,to_char(school_date,'yyyy-MM-dd') school_date,"+
				"class_name,c.class_id from student s inner join classinfo c on s.class_id=c.class_id and s.stu_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(stu_id);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 根据班级信息查看学生
	 * @param className
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findStudentByClassName(String className) throws IOException, SQLException{
		String sql="select stu_id,stu_name,stu_sex,stu_pwd,stu_addr,stu_img,to_char(school_date,'yyyy-MM-dd') school_date,"+
				"class_name,c.class_id from student s inner join classinfo c on s.class_id=c.class_id and c.class_name=?";
				
		List<Object> params=new ArrayList<Object>();
		params.add(className);
		return db.findMultiObject(sql, params);
	}
	
	
	
	
	
	
	
}

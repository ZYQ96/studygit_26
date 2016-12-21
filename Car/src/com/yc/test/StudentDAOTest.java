package com.yc.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yc.dao.StudentDAO;

public class StudentDAOTest {

	StudentDAO dao;

	@Before
	public void setUp() throws Exception {
		dao=new StudentDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws SQLException, IOException {
		dao.login(1000, "aaaaa");
	}

	@Test
	public void testResgisterStudent() throws IOException{
		List<Object> params=new ArrayList<Object>();
		params.add("lisi");
		params.add("男");
		params.add("湖南长沙");
		params.add(new File("D:\\backImg.png"));
		dao.registerStudent(params);
	}
	
	
	
	
	
}

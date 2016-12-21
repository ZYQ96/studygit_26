package com.yc.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yc.dao.ClassInfoDAO;

public class ClassInfoDAOTest {

	

	@Test
	public void test() throws IOException, SQLException {
		ClassInfoDAO dao=new ClassInfoDAO();
		System.out.println(dao.findAllClassInfo().size());
	}

}

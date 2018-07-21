package com.vitamin.ex_pcweb;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBConnTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL    = "jdbc:mysql://localhost:3306/dev_newbrandhtl_db?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=utf8";
	
	private static final String USER = "devnewhtl";
	private static final String PW   = "devnewhtl0!";

	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			System.out.println(conn);
			Thread.sleep(10000);
		} catch(Exception e) {
			e.getStackTrace();
		}
	}

}

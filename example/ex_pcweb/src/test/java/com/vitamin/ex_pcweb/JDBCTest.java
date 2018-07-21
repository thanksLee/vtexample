package com.vitamin.ex_pcweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class JDBCTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL    = "jdbc:mysql://localhost:3306/dev_newbrandhtl_db?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=utf8";
	
	private static final String USER = "devnewhtl";
	private static final String PW   = "devnewhtl0!";
	
	@Test
	public void getTest() throws Exception {
		Class.forName(DRIVER);
		
		String lv_Query = "select count(1) from htl_mast";
		int lv_Cnt = 0;
		
		Connection conn         = null;
		PreparedStatement pstmt = null;
		ResultSet rs            = null;
		
		try {
			
			conn = DriverManager.getConnection(URL, USER, PW);
			
			pstmt = conn.prepareStatement(lv_Query);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				lv_Cnt = rs.getInt(1);
				
				System.out.println("jjjj : " + lv_Cnt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.fillInStackTrace());			
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
	}
}

package com.vitamin.ex_pcweb;

import java.sql.Connection;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/test-root-context.xml"})
public class DataSourceTest {
	@Inject
	@Autowired
	@Qualifier("dataSourceMySQL")
	private DataSource ds;
	
	@Test
	public void testConnection() throws Exception {
		try(Connection conn = ds.getConnection()) {
			System.out.println(conn);
			Thread.sleep(10000);
		} catch(Exception e) {
			e.fillInStackTrace();
		}
	}
}

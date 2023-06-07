package com.rio.base;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rio.base.sample.SampleService;

import lombok.extern.log4j.Log4j2;

import static org.junit.Assert.*;

import java.sql.Connection;


@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTests {
	
	@Autowired
	private SampleService sampleService;
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testService1() {
		log.info(sampleService);
	}
	
	@Test
	public void testConnection() throws Exception {
		
		Connection connection = dataSource.getConnection();
		log.info(connection);
		assertNotNull(connection);
		
		connection.close();
		
	}

}

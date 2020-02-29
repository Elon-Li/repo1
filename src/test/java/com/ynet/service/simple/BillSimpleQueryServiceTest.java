package com.ynet.service.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ynet.TestMain;
import com.ynet.service.simple.BillSimpleQueryService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestMain.class)
public class BillSimpleQueryServiceTest {

	@Autowired
	private BillSimpleQueryService billService;

	@Test
	public void findByid() throws Exception {
		billService.findByid();
	}
	
	@Test
	public void findPOJOByid() throws Exception {
		billService.findPOJOByid();
	}
	
	@Test
	public void findField() throws Exception {
		billService.findField();
	}
	
	@Test
	public void findFields() throws Exception {
		billService.findFields();
	}
	
	@Test
	public void findPOJOs() throws Exception {
		billService.findPOJOs();
	}
	
	@Test
	public void findPages() throws Exception {
		billService.findPages();
	}

}

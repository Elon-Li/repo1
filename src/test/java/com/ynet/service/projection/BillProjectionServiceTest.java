package com.ynet.service.projection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ynet.TestMain;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestMain.class)
public class BillProjectionServiceTest {

	@Autowired
	private BillProjectionService billProjectionService;

	@Test
	public void newConstructorTest() throws Exception {

		billProjectionService.newConstructor(1L);

	}
	
	@Test
	public void nameQueryTest() throws Exception {

		billProjectionService.nameQuery(1L);
	}
	
	@Test
	public void interfaceMapper() throws Exception {

		billProjectionService.interfaceMapper(30L, 100L);
	}
	
	@Test
	public void dynamicMapper() throws Exception {

		billProjectionService.dynamicMapper("1");
	}

}

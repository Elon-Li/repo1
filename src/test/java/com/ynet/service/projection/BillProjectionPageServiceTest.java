package com.ynet.service.projection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ynet.TestMain;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestMain.class)
public class BillProjectionPageServiceTest {

	@Autowired
	private BillProjectionPageService billProjectionService;

	@Test
	public void newConstructorTest() throws Exception {

		billProjectionService.newConstructorPage(1L);

	}
	
	@Test
	public void nameQueryTest() throws Exception {

		billProjectionService.nameQueryPage("1");
	}
	
	@Test
	public void interfaceMapper() throws Exception {

		billProjectionService.interfaceMapperPage(30L, 100L);
	}
	
	@Test
	public void dynamicMapper() throws Exception {

		billProjectionService.dynamicMapperPage("1");
	}

}

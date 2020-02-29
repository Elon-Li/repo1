package com.ynet.service.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ynet.TestMain;
import com.ynet.service.simple.BillSimpleDeleteService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestMain.class)
public class BillSimpleDeleteServiceTest {
	
	@Autowired
	private BillSimpleDeleteService billdelService;
	
	@Test
	public void delete(){
		billdelService.delete();
	}

}

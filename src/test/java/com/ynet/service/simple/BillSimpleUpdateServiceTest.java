package com.ynet.service.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ynet.TestMain;
import com.ynet.service.simple.BillSimpleUpdateService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestMain.class)
public class BillSimpleUpdateServiceTest {
	
	@Autowired
	private BillSimpleUpdateService billUpdateService;
	
	@Test
	public void update(){
		billUpdateService.update();
	}

}

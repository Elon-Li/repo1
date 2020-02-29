package com.ynet.service.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ynet.TestMain;
import com.ynet.service.simple.BillSimpleSaveService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestMain.class)
public class BillSimpleSaveServiceTest {
	
	@Autowired
	private BillSimpleSaveService billSimpleSaveService;
	
	@Test
	public void save() throws Exception {
		billSimpleSaveService.save();
	}
	
	@Test
	public void saveAll() throws Exception {
		billSimpleSaveService.saveAll();
	}

}

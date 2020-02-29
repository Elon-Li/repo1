package com.ynet.service.querynative;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ynet.TestMain;
import com.ynet.service.querynative.BillQueryNativeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestMain.class)
public class BillQueryNativeTest {

	@Autowired
	private BillQueryNativeService billService;
	
	@Test
	public void getBillStatistics() throws Exception {
		billService.getBillStatistics(4L,1L,0);
	}
	
	@Test
	public void getBillStatisticsPage() throws Exception {
		billService.getBillStatisticsPage(4L,1L,0,0,2);
	}
}

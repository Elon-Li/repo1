package com.ynet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ynet.bean.SimpleBillInfo;
import com.ynet.pojo.Bill;
import com.ynet.pojo.BillInterfaceProjection;


public interface BillProjectionRepository extends JpaRepository<Bill, Long>, JpaSpecificationExecutor<Bill> {
	
	/**
	 * 按缴费时间降序排列，查询账单
	 * @param actId
	 * @return
	 */
	@Query("SELECT new com.ynet.bean.SimpleBillInfo(b.id,b.verifyId,sum(b.realPayAmount-b.fee),b.paymentDate,b.verifyName,b.payWay,b.openid,b.termType,sum(b.fee)) FROM Bill b WHERE  b.activityId = ?1 group by b.billNumber")
	List<SimpleBillInfo> findHaspaySimpleBills(Long actId);
	
	@Query("SELECT new Bill(b.id,b.verifyId) FROM Bill b WHERE  b.id = ?1")
	Bill nameQueryById(Long id);
	
	List<BillInterfaceProjection> findByIdGreaterThanAndIdLessThanEqual(Long idBegin,Long idEnd);
	
}

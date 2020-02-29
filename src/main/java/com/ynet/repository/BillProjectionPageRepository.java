package com.ynet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ynet.bean.SimpleBillInfo;
import com.ynet.pojo.Bill;
import com.ynet.pojo.BillInterfaceProjection;


public interface BillProjectionPageRepository extends JpaRepository<Bill, Long>, JpaSpecificationExecutor<Bill> {
	
	/**
	 * 按缴费时间降序排列，查询账单
	 * @param actId
	 * @return
	 */
	@Query("SELECT new com.ynet.bean.SimpleBillInfo(b.id,b.verifyId,sum(b.realPayAmount-b.fee),b.paymentDate,b.verifyName,b.payWay,b.openid,b.termType,sum(b.fee)) FROM Bill b WHERE  b.activityId = ?1 group by b.billNumber")
	Page<SimpleBillInfo> findHaspaySimpleBills(Long actId,Pageable pageable);
	
	@Query("SELECT new Bill(b.id,b.verifyId) FROM Bill b WHERE  b.verifyId = ?1")
	Page<Bill> nameQueryByVerifyId(String verifyId,Pageable pageable);
	
	Page<BillInterfaceProjection> findByIdGreaterThanAndIdLessThanEqual(Long idBegin,Long idEnd,Pageable pageable);
	
	<T> Page<T> findByVerifyId(String verifyId, Class<T> type,Pageable pageable);
}

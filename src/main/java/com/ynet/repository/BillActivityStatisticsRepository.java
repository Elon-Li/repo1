package com.ynet.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.transaction.Transactional;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ynet.bean.BillStatisticInfoObject;
import com.ynet.bean.BillStatisticInfoPro;
import com.ynet.pojo.BillActivityStatistics;



/**
 * 
 * <pre>
 * 缴费活动的统计信息仓库
 * </pre>
 *
 * @author zhoujiagen
 *
 */
//@Component("billActivityStatisticsRepository")
@Repository
public interface BillActivityStatisticsRepository extends JpaRepository<BillActivityStatistics, Long>,
		JpaSpecificationExecutor<BillActivityStatistics>,BillEntityManagerRepository {
	
	@Query(value ="SELECT min(b.activity_id) AS activityId,min(b.org_id) AS orgId,min(b.org_fullname) AS orgFullname" +
			",min(b.bill_count) as billCount FROM bill_activity_statistics b "
			+" WHERE  b.activity_id = ? AND b.pay_state_type = ? AND b.mch_id = ? " +
			"GROUP BY b.org_id, b.org_seqnum ORDER BY b.org_seqnum limit ?,?",nativeQuery = true)
	List<BillStatisticInfoObject> getPro(Long actId, Integer payStateType, Long mchId,int pageSize,int pageNumber);
//	List<BillStatisticInfoPro> getPro(Long actId, Integer payStateType, Long mchId);
	
	@Query(value ="SELECT min(b.activity_id) AS activityId,min(b.org_id) AS orgId,min(b.org_fullname) AS orgFullname" +
			",sum(b.bill_count) as billCount,min(a.act_name) as actName " +
			"FROM bill_activity_statistics b left join bill_activity a on b.activity_id = a.id "
			+" WHERE  b.activity_id = ? AND b.pay_state_type = ? AND b.mch_id = ? " +
			"GROUP BY b.org_id, b.org_seqnum ORDER BY b.org_seqnum ",nativeQuery = true)
	List<BillStatisticInfoPro> getActPro(Long actId, Integer payStateType, Long mchId);
	
	@Query(value ="SELECT min(b.activity_id) AS activityId,min(b.org_id) AS orgId,min(b.org_fullname) AS orgFullname" +
			",sum(b.bill_count) as billCount,min(a.act_name) as actName " +
			"FROM bill_activity_statistics b left join bill_activity a on b.activity_id = a.id "
			+" WHERE  b.activity_id = ? AND b.pay_state_type = ? AND b.mch_id = ? " +
			"GROUP BY b.org_id, b.org_seqnum ORDER BY b.org_seqnum limit ?,? ",nativeQuery = true)
	List<BillStatisticInfoPro> getActProByPage(Long actId, Integer payStateType, Long mchId,int pageSize,int pageNumber);

}

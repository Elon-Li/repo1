package com.ynet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ynet.pojo.ReconcilationError;

public interface ReconcilationErrorRepository extends  JpaRepository<ReconcilationError, Long>,
JpaSpecificationExecutor<ReconcilationError>{
	
	/**
	 * <p>Title: findSpecErrorByTradeTime</p>
	 * <p>Description: 查询定位不到商户的差错</p>
	 * @param tradeTime
	 * @param pageable
	 * @return
	 */
	@Query("select r from ReconcilationError r where r.verifyDate=?1 "
			+ "and (r.errorType in (2,3) or r.mchNum is null)")
	Page<ReconcilationError> findSpecErrorByTradeTime(String tradeTime,Pageable pageable);

}

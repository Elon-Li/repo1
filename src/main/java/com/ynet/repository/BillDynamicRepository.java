package com.ynet.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.ynet.pojo.Bill;

public interface BillDynamicRepository extends CrudRepository<Bill, Long> {
	
	<T> List<T> findByVerifyId(String verifyId, Class<T> type);
	
	<T> Page<T> findByVerifyId(String verifyId, Class<T> type,Pageable pageable);

}

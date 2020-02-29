package com.ynet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ynet.bean.BillPam;
import com.ynet.pojo.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>, JpaSpecificationExecutor<Bill> {

	public Bill findByid(Long Id);

	@Query("SELECT b FROM Bill b where b.id = ?1")
	public Bill findByBillId(Long id);

	@Query("SELECT b.mchId FROM Bill b where b.id = ?1")
	public Long findidsByMchId(Long id);

	@Query("SELECT new com.ynet.bean.BillPam(b.id,b.mchId) FROM Bill b where b.id = ?1")
	public BillPam findPamById(Long id);

	@Query("SELECT b FROM Bill b where b.mchId = ?1")
	public List<Bill> findByMchId(Long mchId);

}

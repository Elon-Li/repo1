package com.ynet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ynet.pojo.MerchantType;

public interface MerchantTypeRepository
		extends JpaRepository<MerchantType, Long>, JpaSpecificationExecutor<MerchantType> {
	
	@Modifying
	@Query("delete from MerchantType m where m.id=?1")
	void deleteByid(Long id);
	
	@Modifying
	@Query("update MerchantType m set m.comment=?1 where m.id=?2")
	void updateByid(String comment,Long id);

}

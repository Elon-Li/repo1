package com.ynet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.ynet.bean.BillStatisticInfoObject;

public class BillEntityManagerRepositoryImpl implements BillEntityManagerRepository{

	@Autowired
	private EntityManager entityManager;
	@Override
	public List<Tuple> getBillInfoTuple(Long actId, Long mchId,
			Integer payType, Integer pageNumber, Integer pageSize)
			throws Exception {
		 String sql = "";
			sql = "SELECT min(b.activity_id) AS activityId,min(b.org_id) AS orgId,min(b.org_fullname) AS orgFullname,min(b.bill_count) AS billCount ,a.act_name as actName " +
					"FROM bill_activity_statistics b left join bill_activity a on b.activity_id = a.id WHERE  b.activity_id = ? AND b.pay_state_type = ? " +
					"AND b.mch_id = ? GROUP BY b.org_id, b.org_seqnum ORDER BY b.org_seqnum limit ?,? ";
			int m = 1;

			Query query = null;
			query = entityManager.createNativeQuery(sql, Tuple.class);// 得到分页结果
			query.setParameter(m++, actId);
			query.setParameter(m++, payType);

			query.setParameter(m++, mchId);
			query.setParameter(m++, pageNumber);
			query.setParameter(m++, pageSize);
			List<Tuple> postDTOs = query.getResultList();
//			System.out.println(mapper.writeValueAsString(postDTOs));
			return postDTOs;
	}
	@Override
	public List<BillStatisticInfoObject> getBillInfoBean(Long actId,
			Long mchId, Integer payType, Integer pageNumber, Integer pageSize)
			throws Exception {
		String sql = "";
		sql = "SELECT min(b.activity_id) AS activityId,min(b.org_id) AS orgId,min(b.org_fullname) AS orgFullname,min(b.bill_count) AS billCount ,a.act_name as actName " +
				"FROM bill_activity_statistics b left join bill_activity a on b.activity_id = a.id WHERE  b.activity_id = ? AND b.pay_state_type = ? " +
				"AND b.mch_id = ? GROUP BY b.org_id, b.org_seqnum ORDER BY b.org_seqnum limit ?,?";
		int m = 1;

		Query query = null;
		query = entityManager.createNativeQuery(sql).unwrap( org.hibernate.query.NativeQuery.class )
				.setResultTransformer( Transformers.aliasToBean( BillStatisticInfoObject.class ) );// 得到分页结果
		query.setParameter(m++, actId);
		query.setParameter(m++, payType);

		query.setParameter(m++, mchId);
		query.setParameter(m++, pageNumber);
		query.setParameter(m++, pageSize);
		
		List<BillStatisticInfoObject> postDTOs = query.getResultList();
		return postDTOs;
	}
	@Override
	public List getBillInfoMap(Long actId, Long mchId, Integer payType,
			Integer pageNumber, Integer pageSize) throws Exception {
		String sql = "";
		sql = "SELECT min(b.activity_id) AS activityId,min(b.org_id) AS orgId,min(b.org_fullname) AS orgFullname,min(b.bill_count) AS billCount ,a.act_name as actName " +
				"FROM bill_activity_statistics b left join bill_activity a on b.activity_id = a.id WHERE  b.activity_id = ? AND b.pay_state_type = ? " +
				"AND b.mch_id = ? GROUP BY b.org_id, b.org_seqnum ORDER BY b.org_seqnum limit ?,?";
		int m = 1;

		Query query = null;
		query = entityManager.createNativeQuery(sql);// 得到分页结果
		query.setParameter(m++, actId);
		query.setParameter(m++, payType);

		query.setParameter(m++, mchId);
		query.setParameter(m++, pageNumber);
		query.setParameter(m++, pageSize);
		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List list = query.getResultList();
		return list;
	}

}

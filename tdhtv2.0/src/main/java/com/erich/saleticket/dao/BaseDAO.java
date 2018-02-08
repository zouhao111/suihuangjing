package com.erich.saleticket.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO {
	@Resource
	protected JdbcTemplate jdbcTemplate;

	/**
	 * 查询该表ID值
	 * @param nextIDName
	 * @return
	 */
	public int queryNextId(String nextIDName) {
		return jdbcTemplate.queryForInt("select NextId from NextID where NextIDName = '" + nextIDName + "'");
	}

	/**
	 * 将该表的ID加1
	 * @param nextIDName
	 */
	public void updateNextId(String nextIDName) {
		jdbcTemplate.update("update NextID set NextId = NextId +1, UpDateTime = getdate() where NextIDName = '"
				+ nextIDName + "'");
	}

	/**
	 * 将该表的id修改为nextId
	 * @param nextIDName
	 * @param nextId
	 */
	public void updateId(String nextIDName, int nextId) {
		jdbcTemplate.update("update NextID set NextId = " + nextId + ", UpDateTime = getdate() where NextIDName = '"
				+ nextIDName + "'");
	}
}

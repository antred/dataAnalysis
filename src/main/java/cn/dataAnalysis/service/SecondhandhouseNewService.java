package cn.dataAnalysis.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.dataAnalysis.model.SecondhandhouseNew;

public interface SecondhandhouseNewService {
	
	void insert(SecondhandhouseNew sn);

	/**
	 * 根据时间查询数据量
	 * @param begainDate
	 * @param endDate
	 * @return
     */
	List<SecondhandhouseNew> getByDate(Date begainDate, Date endDate);
	
	int countAllData(Map<String,Object> params);

	/**
	 * 通过map条件集合查找
	 *
     * @return
     */
	List<SecondhandhouseNew> getByParams(Map<String,Object> params);

	int getCountByParams(Map<String,Object> map);

	/**
	 *
	 * 获取所有小区名(去重)
	 *
	 * @return
	 */
	List<String> getAllCommunityName();

}

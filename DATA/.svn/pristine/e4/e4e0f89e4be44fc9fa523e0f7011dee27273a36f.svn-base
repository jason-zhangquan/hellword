package com.qizhu.service.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qizhu.dao.base.IBaseDao;
import com.qizhu.dao.statistics.IStatisticsDao;
import com.qizhu.model.statistics.Statistics;
import com.qizhu.service.base.BaseServiceImpl;

@Service("statisticsService")
public class StatisticsServiceImpl extends BaseServiceImpl<Statistics, String> implements
		IStatisticsService {

	/**
	 * 注入statisticsDao
	 */
	@Autowired
	private IStatisticsDao statisticsDao ;

	@Autowired
	public void setBaseDao(IBaseDao<Statistics, String> baseDao) {
		super.setBaseDao(baseDao);
	}

}

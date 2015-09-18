package com.qizhu.service.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.qizhu.dao.base.IBaseDao;
import com.qizhu.dao.base.PageResults;
import com.qizhu.dao.base.RowMapper;



/**
 * 抽取的公共的Service层
 * @author Administrator
 *
 * @param <T>由子类确定注入的类型
 */
public  class BaseServiceImpl<T, ID extends Serializable> implements IBaseService<T, ID> {
protected org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());
	
	protected IBaseDao<T, ID> baseDao;
	/**
	 * 注入dao，由子类确定注入的类型
	 * @param baseDao
	 */
	public IBaseDao<T, ID> getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(IBaseDao<T, ID> baseDao) {
		this.baseDao = baseDao;
	}
	/**
     * <保存实体>
     * <完整保存实体>
     * @param t 实体参数
     */
	public void save(T t) {

		baseDao.save(t);
	}
	/**
     * <保存或者更新实体>
     * @param t 实体
     */
	public void saveOrUpdate(T t) {
		baseDao.saveOrUpdate(t);
	}
	 /**
     * <load>
     * <加载实体的load方法>
     * @param id 实体的id
     * @return 查询出来的实体
     */
	public T load(ID id) {
		return baseDao.load(id);
	}
	 /**
     * <get>
     * <查找的get方法>
     * @param id 实体的id
     * @return 查询出来的实体
     */
	public T get(ID id) {
		return baseDao.get(id);
	}
	/**
     * <contains>
     * @param t 实体
     * @return 是否包含
     */
	public boolean contains(T t) {
		return baseDao.contains(t);
	}
	@Override
	public void delete(T t) {
		baseDao.delete(t);
		
	}
	@Override
	public boolean deleteById(ID Id) {
		return baseDao.deleteById(Id);
	}
	@Override
	public void deleteAll(Collection<T> entities) {
		baseDao.deleteAll(entities);
		
	}
	@Override
	public void queryHql(String hqlString, Object... values) {
		baseDao.queryHql(hqlString, values);
		
	}
	@Override
	public void querySql(String sqlString, Object... values) {
		baseDao.querySql(sqlString, values);
		
	}
	@Override
	public T getByHQL(String hqlString, Object... values) {
		return baseDao.getByHQL(hqlString, values);
	}
	@Override
	public T getBySQL(String sqlString, Object... values) {
		return baseDao.getBySQL(sqlString, values);
	}
	@Override
	public List<T> getListByHQL(String hqlString, Object... values) {
		return baseDao.getListByHQL(hqlString, values);
	}
	@Override
	public List<T> getListBySQL(String sqlString, Object... values) {
		return baseDao.getListBySQL(sqlString, values);
	}
	@Override
	public List findListBySql(String sql, RowMapper map, Object... values) {
		return baseDao.findListBySql(sql, map, values);
	}
	@Override
	public void refresh(T t) {
		baseDao.refresh(t);
		
	}
	@Override
	public void update(T t) {
		baseDao.update(t);
		
	}
	@Override
	public Long countByHql(String hql, Object... values) {
		return baseDao.countByHql(hql, values);
	}
	@Override
	public PageResults<T> findPageByFetchedHql(String hql, String countHql,
			int pageNo, int pageSize, Object... values) {
		return baseDao.findPageByFetchedHql(hql, countHql, pageNo, pageSize, values);
	}
	@Override
	public PageResults<T> findEntityByCriteria(Integer page, Integer rows,
			String sord, String sidx, Map<String, Object> paramMap, String filters) {
		return baseDao.findEntityByCriteria(page, rows, sord, sidx, paramMap, filters);
	}
	@Override
	public void updateByProperties(String[] conditionName,
			Object[] conditionValue, String[] propertyName,
			Object[] propertyValue) {
		baseDao.updateByProperties(conditionName, conditionValue, propertyName, propertyValue);
	}
	@Override
	public boolean deleteByIds(Serializable... id) {
		return baseDao.deleteByIds(id);
	}
	@Override
	public void deleteByProperties(String propName, Object propValue) {
		baseDao.deleteByProperties(propName, propValue);
		
	}
	@Override
	public void deleteByProperties(String[] propName, Object[] propValue) {
		baseDao.deleteByProperties(propName, propValue);
		
	}
	@Override
	public void updateByProperties(String[] conditionName,
			Object[] conditionValue, String propertyName, Object propertyValue) {
		baseDao.updateByProperties(conditionName, conditionValue, propertyName, propertyValue);
		
	}
	@Override
	public void updateByProperties(String conditionName, Object conditionValue,
			String[] propertyName, Object[] propertyValue) {
		baseDao.updateByProperties(conditionName, conditionValue, propertyName, propertyValue);
		
	}
	@Override
	public void updateByProperties(String conditionName, Object conditionValue,
			String propertyName, Object propertyValue) {
		baseDao.updateByProperties(conditionName, conditionValue, propertyName, propertyValue);
		
	}
	@Override
	public void update(T entity, Serializable oldId) {
		baseDao.update(entity, oldId);
		
	}
	@Override
	public T getByProerties(String[] propName, Object[] propValue) {
		return baseDao.getByProerties(propName, propValue);
	}
	@Override
	public T getByProerties(String[] propName, Object[] propValue,
			Map<String, String> sortedCondition) {
		return baseDao.getByProerties(propName, propValue, sortedCondition);
	}
	@Override
	public T getByProerties(String propName, Object propValue) {
		return baseDao.getByProerties(propName, propValue);
	}
	@Override
	public T getByProerties(String propName, Object propValue,
			Map<String, String> sortedCondition) {
		return baseDao.getByProerties(propName, propValue, sortedCondition);
	}
	@Override
	public List<T> queryByProerties(String[] propName, Object[] propValue) {
		return baseDao.queryByProerties(propName, propValue);
	}
	@Override
	public List<T> queryByProerties(String[] propName, Object[] propValue,
			Map<String, String> sortedCondition, Integer top) {
		return baseDao.queryByProerties(propName, propValue, sortedCondition, top);
	}
	@Override
	public List<T> queryByProerties(String[] propName, Object[] propValue,
			Map<String, String> sortedCondition) {
		return baseDao.queryByProerties(propName, propValue, sortedCondition);
	}
	@Override
	public List<T> queryByProerties(String[] propName, Object[] propValue,
			Integer top) {
		return baseDao.queryByProerties(propName, propValue, top);
	}
	@Override
	public List<T> queryByProerties(String propName, Object propValue,
			Map<String, String> sortedCondition, Integer top) {
		return baseDao.queryByProerties(propName, propValue, sortedCondition, top);
	}
	@Override
	public List<T> queryByProerties(String propName, Object propValue,
			Map<String, String> sortedCondition) {
		return baseDao.queryByProerties(propName, propValue, sortedCondition);
	}
	@Override
	public List<T> queryByProerties(String propName, Object propValue,
			Integer top) {
		return baseDao.queryByProerties(propName, propValue, top);
	}
	@Override
	public List<T> queryByProerties(String propName, Object propValue) {
		return baseDao.queryByProerties(propName, propValue);
	}
	
	

}

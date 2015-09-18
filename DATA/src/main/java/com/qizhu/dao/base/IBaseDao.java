package com.qizhu.dao.base;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
 
 
/**
 * @ClassName: IBaseDao
 * @Description: Dao封装接口
 * @author 张权
 * @date 2015年6月25日17:05:17
 */
public interface IBaseDao<T, ID extends Serializable> {
     
    /**
     * <保存实体>
     * <完整保存实体>
     * @param t 实体参数
     */
    public abstract void save(T t);
 
    /**
     * <保存或者更新实体>
     * @param t 实体
     */
    public abstract void saveOrUpdate(T t);
 
    /**
     * <load>
     * <加载实体的load方法>
     * @param id 实体的id
     * @return 查询出来的实体
     */
    public abstract T load(ID id);
 
    /**
     * <get>
     * <查找的get方法>
     * @param id 实体的id
     * @return 查询出来的实体
     */
    public abstract T get(ID id);
 
    /**
     * <contains>
     * @param t 实体
     * @return 是否包含
     */
    public abstract boolean contains(T t);
 
    /**
     * <delete>
     * <删除表中的t数据>
     * @param t 实体
     */
    public abstract void delete(T t);
 
    /**
     * <根据ID删除数据>
     * @param Id 实体id
     * @return 是否删除成功
     */
    public abstract boolean deleteById(ID Id);
 
    /**
     * <删除所有>
     * @param entities 实体的Collection集合
     */
    public abstract void deleteAll(Collection<T> entities);
     
    /**
     * <执行Hql语句>
     * @param hqlString hql
     * @param values 不定参数数组
     */
    public abstract void queryHql(String hqlString, Object... values); 
     
    /**
     * <执行Sql语句>
     * @param sqlString sql
     * @param values 不定参数数组
     */
    public abstract void querySql(String sqlString, Object... values); 
 
    /**
     * <根据HQL语句查找唯一实体>
     * @param hqlString HQL语句
     * @param values 不定参数的Object数组
     * @return 查询实体
     */
    public abstract T getByHQL(String hqlString, Object... values);
 
    /**
     * <根据SQL语句查找唯一实体>
     * @param sqlString SQL语句
     * @param values 不定参数的Object数组
     * @return 查询实体
     */
    public abstract T getBySQL(String sqlString, Object... values);
 
    /**
     * <根据HQL语句，得到对应的list>
     * @param hqlString HQL语句
     * @param values 不定参数的Object数组
     * @return 查询多个实体的List集合
     */
    public abstract List<T> getListByHQL(String hqlString, Object... values);
 
    /**
     * <根据SQL语句，得到对应的list>
     * @param sqlString HQL语句
     * @param values 不定参数的Object数组
     * @return 查询多个实体的List集合
     */
    public abstract List<T> getListBySQL(String sqlString, Object... values);
     
    /**
     * 由sql语句得到List
     * @param sql
     * @param map
     * @param values
     * @return List
     */
    public List findListBySql(final String sql, final RowMapper map, final Object... values);
 
    /**
     * <refresh>
     * @param t 实体
     */
    public abstract void refresh(T t);
 
    /**
     * <update>
     * @param t 实体
     */
    public abstract void update(T t);
 
    /**
     * <根据HQL得到记录数>
     * @param hql HQL语句
     * @param values 不定参数的Object数组
     * @return 记录总数
     */
    public abstract Long countByHql(String hql, Object... values);
     
    /**
     * <HQL分页查询>
     * @param hql HQL语句
     * @param countHql 查询记录条数的HQL语句
     * @param pageNo 下一页
     * @param pageSize 一页总条数
     * @param values 不定Object数组参数
     * @return PageResults的封装类，里面包含了页码的信息以及查询的数据List集合
     */
    public abstract PageResults<T> findPageByFetchedHql(String hql, String countHql, int pageNo, int pageSize, Object... values);
 
    /**
	 * 分页查询
	 * 
	 * @param page 当前页
	 * @param rows 页容量
	 * @param paramMap 查询参数
	 * @return 返回结果集以及查询的总记录数
	 */
	public abstract PageResults<T> findEntityByCriteria(Integer page, Integer rows,
			String sord, String sidx, Map<String, Object> paramMap, String filters);
	
	/**
	 * 
	 * 根据单个或指定个数属性条件更新对象实体单个属性
	 * 
	 * Parameters: 
	 * conditionName WHERE子句条件的属性名称 
	 * conditionValue WHERE子句条件的属性值
	 * propertyName UPDATE子句属性名称 
	 * propertyValue UPDATE子句属性值
	 */
	public abstract void updateByProperties(String[] conditionName,
			Object[] conditionValue, String[] propertyName,
			Object[] propertyValue);
	
	/**
	 * 根据多个id参数删除对象
	 * 
	 * @param id 多个id，以英文逗号隔开
	 * @return 返回true或者false
	 */
	public boolean deleteByIds(Serializable... id);
	
	/**
	 * 以HQL的方式，根据单个属性删除对象实体
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 */
	public void deleteByProperties(String propName, Object propValue);

	/**
	 * 以HQL的方式，根据多个属性删除对象实体
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 */
	public void deleteByProperties(String[] propName, Object[] propValue);
	
	/**
	 * 根据单个属性条件更新对象实体多个属性
	 * 
	 * @param conditionName WHERE子句条件的属性数组名称
	 * @param conditionValue WHERE子句条件的属性数组值
	 * @param propertyName UPDATE子句属性名称
	 * @param propertyValue UPDATE子句属性值
	 */
	public void updateByProperties(String[] conditionName, Object[] conditionValue, String propertyName, Object propertyValue);

	/**
	 * 根据多个属性条件更新对象实体单个属性
	 * 
	 * @param conditionName WHERE子句条件的属性名称
	 * @param conditionValue WHERE子句条件的属性值
	 * @param propertyName UPDATE子句属性数组名称
	 * @param propertyValue UPDATE子句属性数组值
	 */
	public void updateByProperties(String conditionName, Object conditionValue, String[] propertyName, Object[] propertyValue);

	/**
	 * 根据单个属性条件更新对象实体单个属性
	 * 
	 * @param conditionName WHERE子句条件的属性名称
	 * @param conditionValue WHERE子句条件的属性值
	 * @param propertyName UPDATE子句属性名称
	 * @param propertyValue UPDATE子句属性值
	 */
	public void updateByProperties(String conditionName, Object conditionValue, String propertyName, Object propertyValue);

	/**
	 * 先删除再插入去更新对象实体
	 * 
	 * @param entity 待更新的对象实体
	 * @param oldId 已存在的对象实体主键
	 */
	public void update(T entity, Serializable oldId);
	
	/**
	 * 根据属性数组获取单个对象实体
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @return 返回对象实体
	 */
	public T getByProerties(String[] propName, Object[] propValue);

	/**
	 * 根据属性数组和排序条件获取单个对象实体
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体
	 */
	public T getByProerties(String[] propName, Object[] propValue, Map<String, String> sortedCondition);

	/**
	 * 根据属性获取单个对象实体
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @return 返回对象实体
	 */
	public T getByProerties(String propName, Object propValue);

	/**
	 * 根据属性和排序条件获取单个对象实体
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体
	 */
	public T getByProerties(String propName, Object propValue, Map<String, String> sortedCondition);
	
	/**
	 * 根据属性获取对象实体列表
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @return
	 */
	public List<T> queryByProerties(String[] propName, Object[] propValue);
	
	
	/**
	 * 根据属性、排序条件和要返回的记录数目获取对象实体列表
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param sortedCondition 排序条件
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String[] propName, Object[] propValue, Map<String, String> sortedCondition, Integer top);

	/**
	 * 根据属性和排序条件获取对象实体列表
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String[] propName, Object[] propValue, Map<String, String> sortedCondition);

	/**
	 * 根据属性和要返回的记录数目获取对象实体列表
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String[] propName, Object[] propValue, Integer top);


	/**
	 * 根据属性、排序条件和要返回的记录数目获取对象实体列表
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param sortedCondition 排序条件
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String propName, Object propValue, Map<String, String> sortedCondition, Integer top);

	/**
	 * 根据属性和排序条件获取对象实体列表
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String propName, Object propValue, Map<String, String> sortedCondition);

	/**
	 * 根据属性和要返回的记录数目获取对象实体列表
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String propName, Object propValue, Integer top);

	/**
	 * 根据属性获取对象实体列表
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String propName, Object propValue);
}
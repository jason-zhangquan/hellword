package com.qizhu.dao.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;

import com.qizhu.model.base.FilterList;
import com.qizhu.model.base.Rule;
import com.qizhu.model.user.User;
import com.qizhu.util.JSONUtil;

/**
 * @ClassName: BaseDao
 * @Description: baseDao实现
 * @author 张权
 * @date 2015年6月25日17:09:52
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BaseDaoImpl<T, ID extends Serializable> extends BaseDaoExt implements IBaseDao<T, ID> {
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<T> entityClass;

	public BaseDaoImpl() {

	}

	protected Class getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return entityClass;
	}

	

	/**
	 * 
	 * @return session
	 */
	public Session getSession() {
		// 需要开启事物，才能得到CurrentSession
		return sessionFactory.getCurrentSession();
	}
	/**
	 * <保存实体> <完整保存实体>
	 * 
	 * @param t
	 *            实体参数
	 * @see com.itv.launcher.util.IBaseDao#save(java.lang.Object)
	 */
	@Override
	public void save(T t) {
		this.getSession().save(t);
	}

	/**
	 * <保存或者更新实体>
	 * 
	 * @param t
	 *            实体
	 * @see com.itv.launcher.util.IBaseDao#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(T t) {
		this.getSession().saveOrUpdate(t);
	}

	/**
	 * <load> <加载实体的load方法>
	 * 
	 * @param id
	 *            实体的id
	 * @return 查询出来的实体
	 * @see com.itv.launcher.util.IBaseDao#load(java.io.Serializable)
	 */
	@Override
	public T load(ID id) {
		T load = (T) this.getSession().load(getEntityClass(), id);
		return load;
	}

	/**
	 * <get> <查找的get方法>
	 * 
	 * @param id
	 *            实体的id
	 * @return 查询出来的实体
	 * @see com.itv.launcher.util.IBaseDao#get(java.io.Serializable)
	 */
	@Override
	public T get(ID id) {
		T load = (T) this.getSession().get(getEntityClass(), id);
		return load;
	}

	/**
	 * <contains>
	 * 
	 * @param t
	 *            实体
	 * @return 是否包含
	 * @see com.itv.launcher.util.IBaseDao#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(T t) {
		return this.getSession().contains(t);
	}

	/**
	 * <delete> <删除表中的t数据>
	 * 
	 * @param t
	 *            实体
	 * @see com.itv.launcher.util.IBaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(T t) {
		this.getSession().delete(t);
	}

	/**
	 * <根据ID删除数据>
	 * 
	 * @param Id
	 *            实体id
	 * @return 是否删除成功
	 * @see com.itv.launcher.util.IBaseDao#deleteById(java.io.Serializable)
	 */
	@Override
	public boolean deleteById(ID Id) {
		T t = get(Id);
		if (t == null) {
			return false;
		}
		delete(t);
		return true;
	}

	/**
	 * <删除所有>
	 * 
	 * @param entities
	 *            实体的Collection集合
	 * @see com.itv.launcher.util.IBaseDao#deleteAll(java.util.Collection)
	 */
	@Override
	public void deleteAll(Collection<T> entities) {
		for (Object entity : entities) {
			this.getSession().delete(entity);
		}
	}

	/**
	 * <执行Hql语句>
	 * 
	 * @param hqlString
	 *            hql
	 * @param values
	 *            不定参数数组
	 * @see com.itv.launcher.util.IBaseDao#queryHql(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public void queryHql(String hqlString, Object... values) {
		Query query = this.getSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.executeUpdate();
	}

	/**
	 * <执行Sql语句>
	 * 
	 * @param sqlString
	 *            sql
	 * @param values
	 *            不定参数数组
	 * @see com.itv.launcher.util.IBaseDao#querySql(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public void querySql(String sqlString, Object... values) {
		Query query = this.getSession().createSQLQuery(sqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.executeUpdate();
	}

	/**
	 * <根据HQL语句查找唯一实体>
	 * 
	 * @param hqlString
	 *            HQL语句
	 * @param values
	 *            不定参数的Object数组
	 * @return 查询实体
	 * @see com.itv.launcher.util.IBaseDao#getByHQL(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public T getByHQL(String hqlString, Object... values) {
		Query query = this.getSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return (T) query.uniqueResult();
	}

	/**
	 * <根据SQL语句查找唯一实体>
	 * 
	 * @param sqlString
	 *            SQL语句
	 * @param values
	 *            不定参数的Object数组
	 * @return 查询实体
	 * @see com.itv.launcher.util.IBaseDao#getBySQL(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public T getBySQL(String sqlString, Object... values) {
		Query query = this.getSession().createSQLQuery(sqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return (T) query.uniqueResult();
	}

	/**
	 * <根据HQL语句，得到对应的list>
	 * 
	 * @param hqlString
	 *            HQL语句
	 * @param values
	 *            不定参数的Object数组
	 * @return 查询多个实体的List集合
	 * @see com.itv.launcher.util.IBaseDao#getListByHQL(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public List<T> getListByHQL(String hqlString, Object... values) {
		Query query = this.getSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	/**
	 * <根据SQL语句，得到对应的list>
	 * 
	 * @param sqlString
	 *            HQL语句
	 * @param values
	 *            不定参数的Object数组
	 * @return 查询多个实体的List集合
	 * @see com.itv.launcher.util.IBaseDao#getListBySQL(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public List<T> getListBySQL(String sqlString, Object... values) {
		Query query = this.getSession().createSQLQuery(sqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	/**
	 * 由sql语句得到List
	 * 
	 * @param sql
	 * @param map
	 * @param values
	 * @return List
	 * @see com.itv.launcher.util.IBaseDao#findListBySql(java.lang.String,
	 *      com.itv.launcher.util.RowMapper, java.lang.Object[])
	 */
	@Override
	public List findListBySql(final String sql, final RowMapper map,
			final Object... values) {
		final List list = new ArrayList();
		// 执行JDBC的数据批量保存
		Work jdbcWork = new Work() {
			public void execute(Connection connection) throws SQLException {

				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					ps = connection.prepareStatement(sql);
					for (int i = 0; i < values.length; i++) {
						setParameter(ps, i, values[i]);

					}

					rs = ps.executeQuery();
					int index = 0;
					while (rs.next()) {
						Object obj = map.mapRow(rs, index++);
						list.add(obj);

					}
				} finally {
					if (rs != null) {
						rs.close();

					}
					if (ps != null) {
						ps.close();
					}
				}
			}
		};
		this.getSession().doWork(jdbcWork);
		return list;
	}

	/**
	 * <refresh>
	 * 
	 * @param t
	 *            实体
	 * @see com.itv.launcher.util.IBaseDao#refresh(java.lang.Object)
	 */
	@Override
	public void refresh(T t) {
		this.getSession().refresh(t);
	}

	/**
	 * <update>
	 * 
	 * @param t
	 *            实体
	 * @see com.itv.launcher.util.IBaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(T t) {
		log.debug("修改");
		this.getSession().update(t);
	}

	/**
	 * <根据HQL得到记录数>
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            不定参数的Object数组
	 * @return 记录总数
	 * @see com.itv.launcher.util.IBaseDao#countByHql(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public Long countByHql(String hql, Object... values) {
		Query query = this.getSession().createQuery(hql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return (Long) query.uniqueResult();
	}

	/**
	 * <HQL分页查询>
	 * 
	 * @param hql
	 *            HQL语句
	 * @param countHql
	 *            查询记录条数的HQL语句
	 * @param nextPage
	 *            下一页
	 * @param pageSize
	 *            一页总条数
	 * @param values
	 *            不定Object数组参数
	 * @return PageResults的封装类，里面包含了页码的信息以及查询的数据List集合
	 * @see com.itv.launcher.util.IBaseDao#findPageByFetchedHql(java.lang.String,
	 *      java.lang.String, int, int, java.lang.Object[])
	 */
	@Override
	public PageResults<T> findPageByFetchedHql(String hql, String countHql,
			int nextPage, int pageSize, Object... values) {
		PageResults<T> retValue = new PageResults<T>();
		Query query = this.getSession().createQuery(hql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		int page = nextPage > 1 ? nextPage : 1;
		retValue.setPage(page);
		retValue.setRows(pageSize);
		if (countHql == null) {// 不加查询总记录的hql，默认就是查询全部，不加参数
			ScrollableResults results = query.scroll();
			results.last();
			retValue.setRecords(results.getRowNumber() + 1);// 设置总记录数
		} else {
			Long count = countByHql(countHql, values);
			retValue.setRecords(count.intValue());
		}
		retValue.resetNextPage();
		List<T> itemList = query.setFirstResult((page - 1) * pageSize)
				.setMaxResults(pageSize).list();
		if (itemList == null) {
			itemList = new ArrayList<T>();
		}
		retValue.setResults(itemList);

		return retValue;
	}

	

	

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            当前页
	 * @param rows
	 *            页容量
	 * @param paramMap
	 *            查询参数
	 * @return 返回结果集以及查询的总记录数
	 */
	/**
	 * 
	 * @param page
	 *            当前页
	 * @param rows
	 *            页容量
	 * @param sord
	 *            排序值 asc/desc
	 * @param sidx
	 *            排序字段
	 * @param filters
	 *            jqgrid多条件查询的字符串
	 * @param otherParamMap
	 *            其他查询参数
	 * @return 返回结果集以及查询的总记录数
	 */
	public PageResults<T> findEntityByCriteria(Integer page, Integer rows,
			String sord, String sidx, Map<String, Object> otherParamMap,
			String filters) {
		FilterList filter = null;
		if (StringUtils.isNotEmpty(filters)) {

			filter = (FilterList) JSONUtil.getObject(filters, FilterList.class);
		}
		log.debug(filter);
		PageResults<T> retValue = new PageResults<T>();
		List<T> list = null;
		try {

			Criteria criteria = DetachedCriteria.forClass(getEntityClass())
					.getExecutableCriteria(this.getSession());
			// Criteria criteria =this.getSession().createCriteria(entityClass);
			// 处理排序
			if (StringUtils.endsWithIgnoreCase(sord, "asc")) {
				criteria.addOrder(Order.asc(sidx));
			} else {
				criteria.addOrder(Order.desc(sidx));
			}

			// if (otherParamMap != null) {// 处理其他条件
			// Criterion criterion = null ;
			// for()
			// }
			// 添加搜索条件
			if (filter != null) {
				/*
				 * if(filter.getGroups()!=null){ for(Filter
				 * filterGroups:filter.getGroups()){ if
				 * (StringUtils.endsWithIgnoreCase(filterGroups.getGroupOp(),
				 * "AND")) {// 如果关系是并列 log.debug("这是并列关系是处理组的"); Conjunction
				 * conjunction = new Conjunction(); for (Rule rule :
				 * filterGroups.getRules()) { log.debug("搜索的关键字" +
				 * rule.getData()); log.debug("搜索的字段" + rule.getField());
				 * conjunction.add(Restrictions.like(rule.getField(), rule
				 * .getData(), MatchMode.ANYWHERE));//
				 * MatchMode.ANYWHERE相当于关键字前后都加%模糊查询 criteria.add(conjunction);
				 * } } else if
				 * (StringUtils.endsWithIgnoreCase(filterGroups.getGroupOp(),
				 * "OR")) {// 如果关系是或者 log.debug("这是或者关系是处理组的"); Disjunction
				 * disjunction = Restrictions.disjunction(); for (Rule rule :
				 * filterGroups.getRules()) {
				 * disjunction.add(Restrictions.like(rule.getField(), rule
				 * .getData(), MatchMode.ANYWHERE)); criteria.add(disjunction);
				 * } } }
				 * 
				 * }
				 */
				if (StringUtils.endsWithIgnoreCase(filter.getGroupOp(), "AND")) {// 如果关系是并列
					Conjunction conjunction = new Conjunction();
					for (Rule rule : filter.getRules()) {
						log.debug("搜索的关键字" + rule.getData());
						log.debug("搜索的字段" + rule.getField());
						String field = rule.getField();
						String data = rule.getData();
						String op = rule.getOp();
						

						Criterion criterion = parseJgGridWhere(getEntityClass(),field, data, op);
						conjunction.add(criterion);
						criteria.add(conjunction);
					}
				} else if (StringUtils.endsWithIgnoreCase(filter.getGroupOp(),
						"OR")) {// 如果关系是或者
					log.debug("这是或者关系并且不是处理组的");
					Disjunction disjunction = Restrictions.disjunction();
					for (Rule rule : filter.getRules()) {
						String field = rule.getField();
						String data = rule.getData();
						String op = rule.getOp();

						Criterion criterion = parseJgGridWhere(getEntityClass(),field, data, op);
						disjunction.add(criterion);
						criteria.add(disjunction);
					}
				}

			}
			// 查询全部的页数
			Long lo = (Long) criteria.setProjection(Projections.rowCount())
					.uniqueResult();
			Integer totcount = lo.intValue();
			criteria.setProjection(null).setResultTransformer(
					Criteria.ROOT_ENTITY);
			log.debug("全部的记录数	" + totcount);
			list = criteria.setFirstResult((page - 1) * rows)
					.setMaxResults(rows).list();

			retValue.setPage(page);
			retValue.setRows(rows);
			retValue.setRecords(totcount);// 设置总记录数
			retValue.resetNextPage();
			retValue.setResults(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retValue;
	}

	

	

	/**
	 * 
	 * 根据单个或指定个数属性条件更新对象实体单个属性
	 * Parameters: conditionName WHERE子句条件的属性名称 conditionValue WHERE子句条件的属性值
	 * propertyName UPDATE子句属性名称 propertyValue UPDATE子句属性值
	 */
	public void updateByProperties(String[] conditionName,
			Object[] conditionValue, String[] propertyName,
			Object[] propertyValue) {
		if ((propertyName != null) && (propertyName.length > 0)
				&& (propertyValue != null) && (propertyValue.length > 0)
				&& (propertyName.length == propertyValue.length)
				&& (conditionValue != null) && (conditionValue.length > 0)) {
			StringBuffer sb = new StringBuffer();
			sb.append("update " + this.getEntityClass().getName() + " o set ");
			for (int i = 0; i < propertyName.length; i++) {
				sb.append(propertyName[i] + " = :p_" + propertyName[i] + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append(" where 1=1 ");
			appendQL(sb, conditionName, conditionValue);
			Query query = getSession().createQuery(sb.toString());
			for (int i = 0; i < propertyName.length; i++) {
				query.setParameter("p_" + propertyName[i], propertyValue[i]);
			}
			setParameter(query, conditionName, conditionValue);
			query.executeUpdate();
		} else {
			throw new IllegalArgumentException(
					"Method updateByProperties in BaseDao argument is illegal!");
		}
	}

	
	
	
	public static void main(String[] args) {
		// 获取实体类的所有属性，返回Field数组
		   Field[] fields = User.class.getDeclaredFields();
		   for (Field field1 : fields) {// --for() begin
			   System.out.println(field1.getName());
//			    System.out.println(field1.getGenericType().toString().equals("class java.util.Date"));//打印该类的所有属性类型
			    System.out.println(field1.getGenericType() instanceof Date);//打印该类的所有属性类型
		   }
		   
//		   
//		   Object object = new Date();
//		   System.out.println(object instanceof Date);
	}

	/**
	 * 根据多个id参数删除对象
	 * 
	 * @param id 多个id，以英文逗号隔开
	 * @return 返回true或者false
	 */
	public boolean deleteByIds(Serializable... id) {
		boolean result = false;
		if ((id != null) && (id.length > 0)) {
			for (int i = 0; i < id.length; i++) {
				T entity = get((ID)id[i]);
				if (entity != null) {
					getSession().delete(entity);
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * 以HQL的方式，根据单个属性删除对象实体
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 */
	public void deleteByProperties(String propName, Object propValue) {
		deleteByProperties(new String[] { propName }, new Object[] { propValue });
		
	}

	/**
	 * 以HQL的方式，根据多个属性删除对象实体
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 */
	public void deleteByProperties(String[] propName, Object[] propValue) {

		if ((propName != null) && (propName.length > 0) && (propValue != null) && (propValue.length > 0) && (propValue.length == propName.length)) {
			StringBuffer sb = new StringBuffer("delete from " + getEntityClass().getName() + " o where 1=1 ");
			appendQL(sb, propName, propValue);
			Query query = getSession().createQuery(sb.toString());
			setParameter(query, propName, propValue);
			query.executeUpdate();
		}
	}

	/**
	 * 根据单个属性条件更新对象实体多个属性
	 * 
	 * @param conditionName WHERE子句条件的属性数组名称
	 * @param conditionValue WHERE子句条件的属性数组值
	 * @param propertyName UPDATE子句属性名称
	 * @param propertyValue UPDATE子句属性值
	 */
	public void updateByProperties(String[] conditionName,
			Object[] conditionValue, String propertyName, Object propertyValue) {
		
		updateByProperties(conditionName, conditionValue, new String[] { propertyName }, new Object[] { propertyValue });
		
	}

	/**
	 * 根据多个属性条件更新对象实体单个属性
	 * 
	 * @param conditionName WHERE子句条件的属性名称
	 * @param conditionValue WHERE子句条件的属性值
	 * @param propertyName UPDATE子句属性数组名称
	 * @param propertyValue UPDATE子句属性数组值
	 */
	public void updateByProperties(String conditionName, Object conditionValue,
			String[] propertyName, Object[] propertyValue) {
		updateByProperties(new String[] { conditionName }, new Object[] { conditionValue }, propertyName, propertyValue);
		
	}

	/**
	 * 根据单个属性条件更新对象实体单个属性
	 * 
	 * @param conditionName WHERE子句条件的属性名称
	 * @param conditionValue WHERE子句条件的属性值
	 * @param propertyName UPDATE子句属性名称
	 * @param propertyValue UPDATE子句属性值
	 */
	public void updateByProperties(String conditionName, Object conditionValue,
			String propertyName, Object propertyValue) {
		updateByProperties(new String[] { conditionName }, new Object[] { conditionValue }, new String[] { propertyName }, new Object[] { propertyValue });
		
	}

	/**
	 * 先删除再插入去更新对象实体
	 * 
	 * @param entity 待更新的对象实体
	 * @param oldId 已存在的对象实体主键
	 */
	public void update(T entity, Serializable oldId) {
		deleteByIds(new Serializable[] { oldId });
		save(entity);
		
	}

	/**
	 * 根据属性数组获取单个对象实体
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @return 返回对象实体
	 */
	public T getByProerties(String[] propName, Object[] propValue) {
		return getByProerties(propName, propValue, null);
	}

	/**
	 * 根据属性数组和排序条件获取单个对象实体
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体
	 */
	public T getByProerties(String[] propName, Object[] propValue,
			Map<String, String> sortedCondition) {
		log.debug("根据属性数组和排序条件获取单个对象实体");
		if ((propName != null) && (propName.length > 0) && (propValue != null) && (propValue.length > 0) && (propValue.length == propName.length)) {
			log.debug("根据属性数组和排序条件获取单个对象实体not null");
			StringBuffer sb = new StringBuffer("select o from " + getEntityClass().getName() + " o where 1=1 ");
			appendQL(sb, propName, propValue);
			if ((sortedCondition != null) && (sortedCondition.size() > 0)) {
				sb.append(" order by ");
				for (Map.Entry<String, String> e : sortedCondition.entrySet()) {
					sb.append((String) e.getKey() + " " + (String) e.getValue() + ",");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
			Query query = getSession().createQuery(sb.toString());
			setParameter(query, propName, propValue);
			List<T> list = query.list();
			if ((list != null) && (((List) list).size() > 0)) {
				return list.get(0);
			}
		}
		log.debug("根据属性数组和排序条件获取单个对象实体null");
		return null;
	}
	
	

	/**
	 * 根据属性获取单个对象实体
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @return 返回对象实体
	 */
	public T getByProerties(String propName, Object propValue) {
		System.out.println("dao=="+propName+":"+propValue);
		return getByProerties(new String[] { propName }, new Object[] { propValue });
	}

	/**
	 * 根据属性和排序条件获取单个对象实体
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体
	 */
	public T getByProerties(String propName, Object propValue,
			Map<String, String> sortedCondition) {
		return getByProerties(new String[] { propName }, new Object[] { propValue }, sortedCondition);
	}
	
	/**
	 * 根据属性获取对象实体列表
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @return
	 */
	public List<T> queryByProerties(String[] propName, Object[] propValue){
		return queryByProerties(propName, propValue, null, null);
	}
	
	
	/**
	 * 根据属性、排序条件和要返回的记录数目获取对象实体列表
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param sortedCondition 排序条件
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String[] propName, Object[] propValue, Map<String, String> sortedCondition, Integer top){
		if ((propName != null) && (propValue != null) && (propValue.length == propName.length)) {
			StringBuffer sb = new StringBuffer("select o from " + getEntityClass().getName() + " o where 1=1 ");
			appendQL(sb, propName, propValue);
			if ((sortedCondition != null) && (sortedCondition.size() > 0)) {
				sb.append(" order by ");
				for (Map.Entry<String, String> e : sortedCondition.entrySet()) {
					sb.append((String) e.getKey() + " " + (String) e.getValue() + ",");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
			Query query = getSession().createQuery(sb.toString());
			setParameter(query, propName, propValue);
			if (top != null) {
				query.setFirstResult(0);
				query.setMaxResults(top.intValue());
			}
			return query.list();
		}
		return null;
	}

	/**
	 * 根据属性和排序条件获取对象实体列表
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String[] propName, Object[] propValue, Map<String, String> sortedCondition){
		return queryByProerties(propName, propValue, sortedCondition, null);
	}

	/**
	 * 根据属性和要返回的记录数目获取对象实体列表
	 * 
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String[] propName, Object[] propValue, Integer top){
		return queryByProerties(propName, propValue, null, top);
	}


	/**
	 * 根据属性、排序条件和要返回的记录数目获取对象实体列表
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param sortedCondition 排序条件
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String propName, Object propValue, Map<String, String> sortedCondition, Integer top){
		return queryByProerties(new String[] { propName }, new Object[] { propValue }, sortedCondition, top);
	}

	/**
	 * 根据属性和排序条件获取对象实体列表
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String propName, Object propValue, Map<String, String> sortedCondition){
		return queryByProerties(new String[] { propName }, new Object[] { propValue }, sortedCondition, null);
	}

	/**
	 * 根据属性和要返回的记录数目获取对象实体列表
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String propName, Object propValue, Integer top){
		return queryByProerties(new String[] { propName }, new Object[] { propValue }, null, top);
	}

	/**
	 * 根据属性获取对象实体列表
	 * 
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @return 返回对象实体列表
	 */
	public List<T> queryByProerties(String propName, Object propValue){
		return queryByProerties(new String[] { propName }, new Object[] { propValue }, null, null);
	}

}
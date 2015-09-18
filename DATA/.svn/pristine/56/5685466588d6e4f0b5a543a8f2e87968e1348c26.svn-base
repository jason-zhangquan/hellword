package com.qizhu.dao.base;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * BaseDaoImpl中扩展的辅助方法，在IBaseDao里没有的方法
 * @author Administrator
 *
 */
public class BaseDaoExt {
	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * 拼sql 属性值可以传数组或集合，通过in来拼接条件
	 * 
	 * @param sb
	 * @param propName
	 * @param propValue
	 */
	protected void appendQL(StringBuffer sb, String[] propName, Object[] propValue) {
		log.debug("拼sql 属性值可以传数组或集合，通过in来拼接条件");
		log.debug("拼sql 属性值可以传数组或集合，通过in来拼接条件=="+sb.toString());
		for (int i = 0; i < propName.length; i++) {
			String name = propName[i];
			Object value = propValue[i];
			if (((value instanceof Object[]))
					|| ((value instanceof Collection))) {
				Object[] arraySerializable = (Object[]) value;
				if ((arraySerializable != null)
						&& (arraySerializable.length > 0)) {
					sb.append(" and o." + name + " in (:"
							+ name.replace(".", "") + ")");
				}
			} else if (value == null) {
				sb.append(" and o." + name + " is null ");
			} else {
				sb.append(" and o." + name + "=:" + name.replace(".", ""));
			}
		}
	}

	/**
	 * 拼参数
	 * 
	 * @param query
	 * @param propName
	 * @param propValue
	 */
	protected void setParameter(Query query, String[] propName, Object[] propValue) {
		for (int i = 0; i < propName.length; i++) {
			String name = propName[i];
			Object value = propValue[i];
			if (value != null) {
				if ((value instanceof Object[])) {
					query.setParameterList(name.replace(".", ""),
							(Object[]) value);
				} else if ((value instanceof Collection)) {
					query.setParameterList(name.replace(".", ""),
							(Collection) value);
				} else {
					query.setParameter(name.replace(".", ""), value);
				}
			}
		}
	}
	
	
	/**
	 * 创建查询条件
	 * 
	 * @param field
	 * @param data
	 * @param op
	 * @return
	 */
	protected Criterion parseJgGridWhere(Class clazz,String field, String data, String op) {
		Criterion criterion =null;
		
		// 获取实体类的所有属性，返回Field数组
		   Field[] fields = clazz.getDeclaredFields();
		   for (Field fieldClass : fields) {// --for() begin
			   System.out.println(fieldClass.getName());
			   System.out.println(fieldClass.getGenericType());//打印该类的所有属性类型
			   System.out.println("要查询的属性"+field);//打印该类的所有属性类型
			   System.out.println(StringUtils.equalsIgnoreCase(field, fieldClass.getName()));
			   if(StringUtils.equalsIgnoreCase(field, fieldClass.getName())){
				   SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				   if(fieldClass.getGenericType().toString().equals("class java.sql.Timestamp")){
						criterion = getCriterion(field, data, op,1);
				   }else if (fieldClass.getGenericType().toString().equals("class java.util.Date")) {
					   log.debug("这是Date类型");
						criterion = getCriterion(field, data, op,2);
				   	}else{
				   		criterion = getCriterion(field, data, op,3);
				   	}
				   break;
			   }
		   }
		
		
		return criterion;
	}
	
	
	/**
	 * 拼Criterion
	 * @param field
	 * @param data
	 * @param op
	 * @param cmd
	 * @return
	 */
	protected Criterion getCriterion(String field, String data, String op,int cmd) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Criterion criterion =null;
		switch (cmd) {
		case 1:
			Timestamp createTime = null;
			try {
				Date date=format.parse(data);
				createTime = new Timestamp(date.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			criterion = Restrictions.eq(field, createTime);// 默认为相等
			// Restrictions.like(rule.getField(),
			// rule.getData(), MatchMode.ANYWHERE)
			if (StringUtils.equalsIgnoreCase(op, "eq")) {
				criterion = Restrictions.eq(field, createTime);
			} else if (StringUtils.equalsIgnoreCase(op, "ne")) {
				criterion = Restrictions.ne(field, createTime);
			} else if (StringUtils.equalsIgnoreCase(op, "lt")) {
				criterion = Restrictions.lt(field, createTime);
			} else if (StringUtils.equalsIgnoreCase(op, "le")) {
				criterion = Restrictions.le(field, createTime);
			} else if (StringUtils.equalsIgnoreCase(op, "gt")) {
				criterion = Restrictions.gt(field, createTime);
			} else if (StringUtils.equalsIgnoreCase(op, "ge")) {
				criterion = Restrictions.ge(field, createTime);
			} else if (StringUtils.equalsIgnoreCase(op, "cn")) {
					
					criterion = Restrictions.like(field, createTime);// 相当于等于
			} else if (StringUtils.equalsIgnoreCase(op, "nn")) {// 不为空
				criterion = Restrictions.isNotEmpty(field);
			} else if (StringUtils.equalsIgnoreCase(op, "nu")) {// 为空
				criterion = Restrictions.isEmpty(field);
			}
			break;
		case 2:
			log.debug("这是Date类型");
			Date date=null;
			try {
				 date=format.parse(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			criterion = Restrictions.eq(field, date);// 默认为相等
			// Restrictions.like(rule.getField(),
			// rule.getData(), MatchMode.ANYWHERE)
			if (StringUtils.equalsIgnoreCase(op, "eq")) {
				criterion = Restrictions.eq(field, date);
			} else if (StringUtils.equalsIgnoreCase(op, "ne")) {
				criterion = Restrictions.ne(field, date);
			} else if (StringUtils.equalsIgnoreCase(op, "lt")) {
				criterion = Restrictions.lt(field, date);
			} else if (StringUtils.equalsIgnoreCase(op, "le")) {
				log.debug("小于等于");
				criterion = Restrictions.le(field, date);
			} else if (StringUtils.equalsIgnoreCase(op, "gt")) {
				criterion = Restrictions.gt(field, date);
			} else if (StringUtils.equalsIgnoreCase(op, "ge")) {
				criterion = Restrictions.ge(field, date);
			} else if (StringUtils.equalsIgnoreCase(op, "cn")) {
					
					criterion = Restrictions.like(field, date);// 相当于等于
			} else if (StringUtils.equalsIgnoreCase(op, "nn")) {// 不为空
				criterion = Restrictions.isNotEmpty(field);
			} else if (StringUtils.equalsIgnoreCase(op, "nu")) {// 为空
				criterion = Restrictions.isEmpty(field);
			}
			break;
		case 3:
			criterion = Restrictions.eq(field, data);// 默认为相等
			// Restrictions.like(rule.getField(),
			// rule.getData(), MatchMode.ANYWHERE)
			if (StringUtils.equalsIgnoreCase(op, "eq")) {
				criterion = Restrictions.eq(field, data);
			} else if (StringUtils.equalsIgnoreCase(op, "ne")) {
				criterion = Restrictions.ne(field, data);
			} else if (StringUtils.equalsIgnoreCase(op, "lt")) {
				criterion = Restrictions.lt(field, data);
			} else if (StringUtils.equalsIgnoreCase(op, "le")) {
				criterion = Restrictions.le(field, data);
			} else if (StringUtils.equalsIgnoreCase(op, "gt")) {
				criterion = Restrictions.gt(field, data);
			} else if (StringUtils.equalsIgnoreCase(op, "ge")) {
				criterion = Restrictions.ge(field, data);
			} else if (StringUtils.equalsIgnoreCase(op, "cn")) {
					
					criterion = Restrictions.like(field, data,MatchMode.ANYWHERE);// MatchMode.ANYWHERE相当于两头加%%
			} else if (StringUtils.equalsIgnoreCase(op, "nn")) {// 不为空
				criterion = Restrictions.isNotEmpty(field);
			} else if (StringUtils.equalsIgnoreCase(op, "nu")) {// 为空
				criterion = Restrictions.isEmpty(field);
			}
			break;

		default:
			break;
		}
		
		return criterion;
	}
	
	
	/**
	 * 
	 * 设置每行批处理参数
	 * 
	 * @param ps
	 * @param pos
	 *            ?占位符索引，从0开始
	 * @param data
	 * @throws SQLException
	 * @see [类、类#方法、类#成员]
	 */
	protected void setParameter(PreparedStatement ps, int pos, Object data)
			throws SQLException {
		if (data == null) {
			ps.setNull(pos + 1, Types.VARCHAR);
			return;
		}
		Class dataCls = data.getClass();
		if (String.class.equals(dataCls)) {
			ps.setString(pos + 1, (String) data);
		} else if (boolean.class.equals(dataCls)) {
			ps.setBoolean(pos + 1, ((Boolean) data));
		} else if (int.class.equals(dataCls)) {
			ps.setInt(pos + 1, (Integer) data);
		} else if (double.class.equals(dataCls)) {
			ps.setDouble(pos + 1, (Double) data);
		} else if (Date.class.equals(dataCls)) {
			Date val = (Date) data;
			ps.setTimestamp(pos + 1, new Timestamp(val.getTime()));
		} else if (BigDecimal.class.equals(dataCls)) {
			ps.setBigDecimal(pos + 1, (BigDecimal) data);
		} else {
			// 未知类型
			ps.setObject(pos + 1, data);
		}

	}
}

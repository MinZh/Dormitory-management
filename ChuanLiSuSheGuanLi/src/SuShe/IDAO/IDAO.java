package SuShe.IDAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import SuShe.DAO.Page;
/**
 * 
 * @author phreez
 *  this is a DAO(Data Access Object) interface
 */
public interface IDAO  {
	public <T> boolean add(T entity,Object[] param) throws Exception;
    public <T> Integer addAndGetId4Integer(T entity) throws Exception;
    public <T> String addAndGetId4String(T entity) throws Exception;
    public int executeByHql(String hql) throws Exception;
    public <T> List<T> findByHql(String hql,Object[] val) throws Exception;
    public <T> List<T> findByHql(String hql) throws Exception;
    public int executeBySql(String sql) throws Exception;
    public <T> List<T> findBySql(String sql) throws Exception;
    public <T> boolean edit(T entity) throws Exception;
    public boolean edit(String hql) throws Exception;
    public int editByHql(String hql) throws Exception;
    public <T> boolean remove(T entity) throws Exception;
    public <T> T getById(Class<T> c, String id) throws Exception;
    public <T>  T getById(Class<T> c, Integer id) throws Exception;
    public <T> T get(Class<T> c, Serializable id) throws Exception;
    public <T> T get(String hql) throws Exception;
    public <T> List<T> getList(String hql) throws Exception;
    public boolean remove(String hql) throws Exception;
    public <T> List<T> getList(Class<T> c) throws Exception;
    public <T> List<T> getList(String hql, Object[] obj) throws Exception;
    public List<?> showPage(String queryHql, String queryCountHql, int firstResult, int maxResult) throws Exception;
    public <T> void showPage(String queryHql, String queryCountHql, Page<T> page) throws Exception;
    public List<?> showPage(String queryCountHql, DetachedCriteria cResult, int firstResult, int maxResult) throws Exception;
    public <T> void showPage(String queryCountHql, DetachedCriteria cResult, Page<T> page) throws Exception;
    public <T> List<T> find(DetachedCriteria dc) throws Exception;
    public Session session();
    public HibernateTemplate getTemplate();
}

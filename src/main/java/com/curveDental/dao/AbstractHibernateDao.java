package com.curveDental.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDao< T extends Serializable > {
 
   private Class< T > clazz;
 
   @Autowired
   SessionFactory sessionFactory;
 
   public final void setClazz( Class< T > clazzToSet ){
      this.clazz = clazzToSet;
   }
 
	public T findOne(long id) {
      return (T) getCurrentSession().get( clazz, id );
   }

	public T load(long id) {
		return (T) getCurrentSession().load(clazz, id);
	}

	@SuppressWarnings("unchecked")
   public List< T > findAll(){
      return getCurrentSession().createQuery( "from " + clazz.getName() ).list();
   }
 
	public Long create(T entity) {
		return (Long) getCurrentSession().save(entity);
   }
 
   public void update( T entity ){
		getCurrentSession().saveOrUpdate(entity);
   }
 
   public void delete( T entity ){
      getCurrentSession().delete( entity );
   }

	public void deleteById(long entityId) {
      T entity = findOne( entityId );
      delete( entity );
   }
 
   protected final Session getCurrentSession() {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
   }
}
package org.dao.imp;

import java.util.List;
import org.dao.intf.IGoodsDao;
import org.model.Goods;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class GoodsDao extends HibernateDaoSupport implements IGoodsDao{
	public List getNewGoods(){
		//Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		//Query query = session.createQuery("from goods where isNew = 1");
		//query.setFirstResult(0);
		//query.setMaxResults(5);
		//List<Goods> goods=query.list();
		//session.close();
		List<Goods> goods  = this.getHibernateTemplate().find("from Goods where isNew = 1");
		return goods;
	}
	public List<Goods> getGoodsByCategoryId(Integer categoryId){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("from Goods where category_id = ?");
		query.setParameter(0, categoryId);
		//query.setFirstResult(0);
		//query.setMaxResults(5);
		List<Goods> goods = query.list();
		session.close();
		return goods;
	}
	public Goods getGoodsById(Integer goodsId){
		Goods goods = (Goods)this.getHibernateTemplate().get(Goods.class, goodsId);
		return goods;
	}
}

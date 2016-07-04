package org.dao.imp;
import java.util.List;

import org.dao.intf.IShopcarDao;
import org.model.Shopcar;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ShopcarDao extends HibernateDaoSupport implements IShopcarDao{
	public List<Shopcar> getShopCar(Integer userId){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("from Shopcar where user.userid = ?");
		query.setParameter(0, userId);
		List<Shopcar> shopcar = query.list();
		return shopcar;
	}
	public boolean updateShopcar(Shopcar shopcar){
		try {
			this.getHibernateTemplate().save(shopcar);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public boolean insertShopcar(Shopcar shopcar) {
		try {
			this.getHibernateTemplate().save(shopcar);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}

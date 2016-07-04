package org.dao.imp;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.model.Category;
import org.dao.intf.ICategoryDao;

public class CategoryDao extends HibernateDaoSupport implements ICategoryDao{
	public List<Category> getAllCategory(){
		List<Category> categorys = (List)this.getHibernateTemplate().find("from Category");
		return categorys;
	}
}

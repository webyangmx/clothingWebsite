package org.service.imp;
import java.util.List;

import org.model.Category;
import org.dao.intf.ICategoryDao;
import org.service.intf.ICategoryService;
public class CategoryService implements ICategoryService{
	private ICategoryDao categoryDao;
	public void setCategoryDao(ICategoryDao categoryDao){
		this.categoryDao = categoryDao;
	}
	public List<Category> getAllCategory(){
		return categoryDao.getAllCategory();
	}
}

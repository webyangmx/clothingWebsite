package org.service.imp;

import java.util.List;
import org.dao.intf.IGoodsDao;
import org.service.intf.IGoodService;
import org.model.Goods;

public class GoodsService implements IGoodService {
	protected IGoodsDao goodsDao;
	
	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	public List<Goods> getNewGoods(){
		return goodsDao.getNewGoods();
	}
	public List<Goods> getGoodsByCategoryId(Integer categoryId){
		return goodsDao.getGoodsByCategoryId(categoryId);
	}
	public Goods getGoodsById(Integer goodsId){
		return goodsDao.getGoodsById(goodsId);
	}
}

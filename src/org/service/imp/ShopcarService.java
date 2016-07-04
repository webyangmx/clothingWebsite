package org.service.imp;
import java.util.List;

import org.model.Goods;
import org.model.Shopcar;
import org.dao.intf.IShopcarDao;
import org.service.intf.IShopcarService;
import org.service.intf.IGoodService;


public class ShopcarService implements IShopcarService{
	IShopcarDao shopcarDao;
	IGoodService goodService;
	String goodsId;

	public List<Shopcar> getShopcar(Integer userId){
		return shopcarDao.getShopCar(userId);
	}
	public boolean updateShopcar(Shopcar shopcar){
		return shopcarDao.updateShopcar(shopcar);
	}
	public Goods getGoodsById(Integer goodsId){
		return goodService.getGoodsById(goodsId);
	}
	public boolean insertShopcar(Shopcar shopcar) {
		return shopcarDao.insertShopcar(shopcar);
	}
	
	
	public IShopcarDao getShopcarDao() {
		return shopcarDao;
	}
	public void setShopcarDao(IShopcarDao shopcarDao) {
		this.shopcarDao = shopcarDao;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public IGoodService getGoodService() {
		return goodService;
	}
	public void setGoodService(IGoodService goodService) {
		this.goodService = goodService;
	}
	
}

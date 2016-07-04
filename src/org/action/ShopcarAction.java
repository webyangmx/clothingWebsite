package org.action;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.model.Shopcar;
import org.model.Goods;
import org.model.User;
import org.service.intf.IShopcarService;

import com.opensymphony.xwork2.ActionSupport;

public class ShopcarAction extends ActionSupport{
	private Integer userId;
	private Integer goodsId;
	
	IShopcarService shopcarService;
	
	public void setShopcarService(IShopcarService shopcarService) {
		this.shopcarService = shopcarService;
	}
	Map<String, Object> successInfo;
	List<Map<String, Object>> allShopcarInfo;
	Map<String, Object> shopcarInfoMap;
	
	public ShopcarAction(){
		successInfo = new HashMap<String, Object>();
		allShopcarInfo = new ArrayList<Map<String, Object>>();
		shopcarInfoMap = new HashMap<String,Object>();
	}
	public String getShopcar(){
		successInfo.clear();
		allShopcarInfo.clear();
		shopcarInfoMap.clear();
		try{
			List<Shopcar> shopcarList = shopcarService.getShopcar(userId);
			for(Shopcar tempShopcar:shopcarList){
				shopcarInfoMap.put("shopcarId", tempShopcar.getShopcarId());
				shopcarInfoMap.put("userId", tempShopcar.getUser().getUserid());
				shopcarInfoMap.put("goodsId", tempShopcar.getGoods().getGoodsId());
				shopcarInfoMap.put("goodsName", tempShopcar.getGoods().getGoodsName());
				shopcarInfoMap.put("goodsImg", tempShopcar.getGoods().getGoodsImage());
				shopcarInfoMap.put("goodsPrice", tempShopcar.getGoods().getGoodsPrice());
				
				allShopcarInfo.add(shopcarInfoMap);
				shopcarInfoMap = new HashMap<String,Object>();
			}
			System.out.println(allShopcarInfo);
			successInfo.put("success", true);
		}catch(Exception e){
			successInfo.put("success", false);
		}
		return SUCCESS;
	}

	public String insertShopcar(){
		successInfo.clear();
		Shopcar shopcar = new Shopcar();
		
		Goods goods = new Goods();
		goods.setGoodsId(goodsId);
		
		User user = new User();
		user.setUserid(userId);
		
		shopcar.setGoods(goods);
		shopcar.setUser(user);
		
		if(shopcarService.insertShopcar(shopcar)){
			successInfo.put("success", true);
		}else{
			successInfo.put("success", false);
		}
		return SUCCESS;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Map<String, Object> getSuccessInfo() {
		return successInfo;
	}
	public void setSuccessInfo(Map<String, Object> successInfo) {
		this.successInfo = successInfo;
	}
	public List<Map<String, Object>> getAllShopcarInfo() {
		return allShopcarInfo;
	}
	public void setAllShopcarInfo(List<Map<String, Object>> allShopcarInfo) {
		this.allShopcarInfo = allShopcarInfo;
	}
	public Map<String, Object> getShopcarInfoMap() {
		return shopcarInfoMap;
	}
	public void setShopcarInfoMap(Map<String, Object> shopcarInfoMap) {
		this.shopcarInfoMap = shopcarInfoMap;
	}
	public Integer getUserId() {
		return userId;
	}
	public IShopcarService getShopcarService() {
		return shopcarService;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
}

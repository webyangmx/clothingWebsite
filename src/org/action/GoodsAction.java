package org.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.model.Goods;
import org.service.intf.IGoodService;

import org.model.Category;
import org.service.intf.ICategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport{
	protected IGoodService goodsService;
	
	private Integer categoryId;
	private Integer goodsId;
	
	Map<String, Object> successInfo;
	List<Map<String, Object>> allGoodsInfo;
	Map<String, Object> goodsInfoMap;
	
	public GoodsAction(){
		successInfo=new HashMap<String, Object>();
		allGoodsInfo=new ArrayList<Map<String, Object>>();
		goodsInfoMap=new HashMap<String, Object>();
	}

	public String getNewGoods(){
		successInfo.clear();
		allGoodsInfo.clear();
		goodsInfoMap.clear();
		
		List<Goods> allGoodsList = goodsService.getNewGoods();
		for(Goods tempGoods: allGoodsList){
			goodsInfoMap.put("goodsId", tempGoods.getGoodsId());
			goodsInfoMap.put("goodsName", tempGoods.getGoodsName());
			goodsInfoMap.put("goodsImg", tempGoods.getGoodsImage());
			goodsInfoMap.put("goodsPrice", tempGoods.getGoodsPrice());
			
			allGoodsInfo.add(goodsInfoMap);
			goodsInfoMap = new HashMap<String,Object>();
		}
		successInfo.put("success", true);
		return SUCCESS;
	}
	
	public String getGoodsByCategoryId(){
		successInfo.clear();
		allGoodsInfo.clear();
		goodsInfoMap.clear();
		
		List<Goods> allGoodsList = goodsService.getGoodsByCategoryId(categoryId);
		for(Goods tempGoods: allGoodsList){
			goodsInfoMap.put("goodsId", tempGoods.getGoodsId());
			goodsInfoMap.put("goodsName", tempGoods.getGoodsName());
			goodsInfoMap.put("goodsImg", tempGoods.getGoodsImage());
			goodsInfoMap.put("goodsPrice", tempGoods.getGoodsPrice());
			goodsInfoMap.put("categoryId", tempGoods.getCategoryId());
			
			allGoodsInfo.add(goodsInfoMap);
			goodsInfoMap = new HashMap<String,Object>();
		}
		successInfo.put("success", true);
		return SUCCESS;
	}
	public String getGoodsById(){
		successInfo.clear();
		allGoodsInfo.clear();
		goodsInfoMap.clear();
		
		Goods tempGoods = goodsService.getGoodsById(goodsId);
		
		goodsInfoMap.put("goodsId", tempGoods.getGoodsId());
		goodsInfoMap.put("goodsName", tempGoods.getGoodsName());
		goodsInfoMap.put("goodsImg", tempGoods.getGoodsImage());
		goodsInfoMap.put("goodsPrice", tempGoods.getGoodsPrice());
		goodsInfoMap.put("categoryId", tempGoods.getCategoryId());		
		
		successInfo.put("success", true);
		return SUCCESS;
	}

	public void setGoodsService(IGoodService goodsService) {
		this.goodsService = goodsService;
	}
	
	public IGoodService getGoodsService() {
		return goodsService;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Map<String, Object> getSuccessInfo() {
		return successInfo;
	}

	public void setSuccessInfo(Map<String, Object> successInfo) {
		this.successInfo = successInfo;
	}

	public List<Map<String, Object>> getAllGoodsInfo() {
		return allGoodsInfo;
	}

	public void setAllGoodsInfo(List<Map<String, Object>> allGoodsInfo) {
		this.allGoodsInfo = allGoodsInfo;
	}

	public Map<String, Object> getGoodsInfoMap() {
		return goodsInfoMap;
	}

	public void setGoodsInfoMap(Map<String, Object> goodsInfoMap) {
		this.goodsInfoMap = goodsInfoMap;
	}
}

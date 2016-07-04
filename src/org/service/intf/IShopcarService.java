package org.service.intf;
import java.util.List;

import org.model.Shopcar;
import org.model.Goods;

public interface IShopcarService {
	public List<Shopcar> getShopcar(Integer userId);
	public boolean updateShopcar(Shopcar shopcar);
	public Goods getGoodsById(Integer goodsId);
	public boolean insertShopcar(Shopcar shopcar);
}

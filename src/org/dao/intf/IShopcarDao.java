package org.dao.intf;

import java.util.List;
import org.model.Shopcar;

public interface IShopcarDao {
	public List<Shopcar> getShopCar(Integer userId);
	public boolean updateShopcar(Shopcar shopcar);
	public boolean insertShopcar(Shopcar shopcar);
}

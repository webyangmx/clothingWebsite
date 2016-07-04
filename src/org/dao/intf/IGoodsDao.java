package org.dao.intf;
import java.util.List;
import org.model.Goods;

public interface IGoodsDao {
	public List<Goods> getNewGoods();
	public List<Goods> getGoodsByCategoryId(Integer categoryId);
	public Goods getGoodsById(Integer goodsId);
}

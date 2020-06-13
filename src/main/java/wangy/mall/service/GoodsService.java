package wangy.mall.service;

import java.util.List;
import wangy.mall.entity.Goods;
import wangy.mall.entity.Goodstype;

public interface GoodsService {

    List<Goods> queryAllGoods();

    Goods queryGoods(int id);

    List<Goods> queryTypeGoods(String typeName);

    Goods saveGoods(Goods goods);

    void deleteGoods(int id);

//    Goods updateGoods(Goods goods);

    Goodstype addGoodstype(Goodstype goodstype);

    List<Goodstype> queryGoodstype();

    void deleteGoodstype(int id);

    void addGoodsPicture(String fileName,int id);

    void deleteGoodsPicture(int id);

}

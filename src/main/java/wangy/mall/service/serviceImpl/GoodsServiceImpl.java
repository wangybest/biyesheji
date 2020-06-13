package wangy.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangy.mall.dao.GoodsRepository;
import wangy.mall.dao.GoodstypeRepository;
import wangy.mall.entity.Goods;
import wangy.mall.entity.Goodstype;
import wangy.mall.service.GoodsService;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    GoodstypeRepository goodstypeRepository;

    @Override
    public List<Goods> queryAllGoods() {
        return goodsRepository.findAll();
    }

    @Override
    public Goods queryGoods(int id) {
        return goodsRepository.findById(id).get();
    }

    @Override
    public List<Goods> queryTypeGoods(String typeName) {
        return goodsRepository.queryByTypeName(typeName);
    }

    @Override
    public Goods saveGoods(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public void deleteGoods(int id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public Goodstype addGoodstype(Goodstype goodstype) {
        return goodstypeRepository.save(goodstype);
    }

    @Override
    public List<Goodstype> queryGoodstype() {
        return goodstypeRepository.findAll();
    }

    @Override
    public void deleteGoodstype(int id) {
        goodstypeRepository.deleteById(id);
    }

    @Override
    public void addGoodsPicture(String fileName,int id) {
        goodsRepository.addPicture(fileName, id);
    }

    @Override
    public void deleteGoodsPicture(int id) {
            goodsRepository.deletePicture(id);
    }
}

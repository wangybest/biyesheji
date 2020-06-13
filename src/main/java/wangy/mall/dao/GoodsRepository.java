package wangy.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import wangy.mall.entity.Goods;
import wangy.mall.entity.Goodstype;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods,Integer> {

    @Transactional
    @Modifying
    @Query(value = "update goods set picture = ? where id = ?",nativeQuery = true )
    void addPicture(String fileName,int id);

    @Transactional
    @Modifying
    @Query(value = "update goods set picture = null where id = ?",nativeQuery = true )
    void deletePicture(int id);

    List<Goods> queryByTypeName(String name);
}

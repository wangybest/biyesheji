package wangy.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wangy.mall.entity.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByUserId(int userId);

//    void deleteByUserId(int userId);
}

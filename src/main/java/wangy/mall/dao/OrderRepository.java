package wangy.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import wangy.mall.entity.Orders;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {

    List<Orders> findByUserId(int userId);



}

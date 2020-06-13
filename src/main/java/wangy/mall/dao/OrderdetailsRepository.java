package wangy.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wangy.mall.entity.Orderdetails;

import java.util.List;

public interface OrderdetailsRepository extends JpaRepository<Orderdetails,Integer> {

    List<Orderdetails> findByOrderId(int orderId);
}

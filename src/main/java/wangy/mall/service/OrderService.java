package wangy.mall.service;

import wangy.mall.entity.Orders;
import wangy.mall.entity.Orderdetails;

import java.util.List;
import java.util.concurrent.BlockingDeque;

public interface OrderService {

    Orders saveOrder(Orders orders);

    List<Orders> queryAllOrders();

    List<Orders> queryOrder(int userId);

   // Order updateOrder(Order order);

    Boolean addOrderD(List<Orderdetails> orderdetails);

    List<Orderdetails> queryOrderD(int orderId);

//    Boolean diliver(Orders orders);



}

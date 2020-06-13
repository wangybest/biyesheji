package wangy.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangy.mall.dao.OrderRepository;
import wangy.mall.dao.OrderdetailsRepository;
import wangy.mall.entity.Orders;
import wangy.mall.entity.Orderdetails;
import wangy.mall.service.OrderService;

import java.util.Iterator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderdetailsRepository orderdetailsRepository;

    @Override
    public Orders saveOrder(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public List<Orders> queryAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Orders> queryOrder(int userId) {
        return orderRepository.findByUserId(userId);
    }

   /* @Override
    public Order updateOrder(Order order) {

    }*/

    @Override
    public Boolean addOrderD(List<Orderdetails> orderdetails) {
        if (orderdetailsRepository.saveAll(orderdetails) != null) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Orderdetails> queryOrderD(int orderId) {
        return orderdetailsRepository.findByOrderId(orderId);
    }



}

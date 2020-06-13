package wangy.mall.controller;

import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wangy.mall.entity.*;
import wangy.mall.service.GoodsService;
import wangy.mall.service.OrderService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    GoodsService goodsService;

    //生成订单
    @PostMapping
    public Result<String> addOrder(@RequestBody OrderAndDetails orderAndDetails, HttpSession httpSession) {
        Orders orders = orderAndDetails.getOrders();
        List<Orderdetails> orderdetailsList = orderAndDetails.getOrderdetailsList();
        orders.setStatus("待发货");
        User user = (User)httpSession.getAttribute("user");
        orders.setUserId(user.getId());
       Orders orders1= orderService.saveOrder(orders);
        for (Orderdetails orderdetails : orderdetailsList
        ) {
            //为订单项注入订单id
            orderdetails.setOrderId(orders1.getId());
            //每个产品减相应库存
            Goods goods = goodsService.queryGoods(orderdetails.getGoodsId());
            goods.setQuantity(goods.getQuantity() - orderdetails.getNumber());
            goodsService.saveGoods(goods);
        }
        if (orderService.addOrderD(orderdetailsList)) {
            return new Result<>("下单成功");
        } else {
            return new Result<>(400, "下单失败");
        }
    }

    //获取所有订单
    @GetMapping("all")
    public List<Orders> queryAllOrders() {
        return orderService.queryAllOrders();
    }

    //获取当前用户订单
    @GetMapping("a")
    public List<Orders> queryOrder(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        return orderService.queryOrder(user.getId());
    }
 /*   @GetMapping("a")
    public List<OrderAndDetails> queryOrder(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        List<OrderAndDetails> orderAndDetailsList = new ArrayList<>();
        List<Orders> ordersList = orderService.queryOrder(user.getId());
        for (Orders order : ordersList
        ) {
            orderAndDetailsList.add(new OrderAndDetails(order, this.queryOrderdetails(order.getId())));
        }
        return orderAndDetailsList;
    }*/

    //更新订单
    @PutMapping
    public Orders updateOrder(@RequestBody Orders orders) {
        return orderService.saveOrder(orders);
    }

    //添加订单项目
    @PostMapping("details")
    public Boolean addOrderdetails(@RequestBody List<Orderdetails> orderdetailsList) {

        return orderService.addOrderD(orderdetailsList);
    }

    //获取id订单的订单项目
    @GetMapping("details/{orderId}")
    public List<Orderdetails> queryOrderdetails(@PathVariable int orderId) {
        return orderService.queryOrderD(orderId);
    }
}

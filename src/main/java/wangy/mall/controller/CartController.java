package wangy.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wangy.mall.entity.Cart;
import wangy.mall.entity.Goods;
import wangy.mall.entity.Result;
import wangy.mall.entity.User;
import wangy.mall.service.CartService;
import wangy.mall.service.GoodsService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    GoodsService goodsService;

    //查询用户购物车
    @GetMapping("a")
    public List<Cart> queryCart(HttpSession httpSession) {
//        BigDecimal totalPrice = new BigDecimal("0");
        User user = (User) httpSession.getAttribute("user");
        List<Cart> cartList = cartService.queryCart(user.getId());
        for (Cart carts:cartList) {
            Goods goods = goodsService.queryGoods(carts.getGoodsId());
            carts.setPrice(goods.getPrice());
            carts.setPicture(goods.getPicture());
//            totalPrice = totalPrice.add(carts.getPrice().multiply(new BigDecimal(carts.getNumber())));
        }
        return cartList;
    }

    //结算购物车
    @PostMapping("count")
    public BigDecimal count(@RequestBody List<Cart> cartList) {
        BigDecimal totalPrice = new BigDecimal("0");
        for (Cart cart : cartList
        ) {
            totalPrice = totalPrice.add(cart.getPrice().multiply(new BigDecimal(cart.getNumber())));
        }
        return totalPrice;
    }


    //删除一项购物车
    @DeleteMapping("{id}")
    public void deleteCart(@PathVariable int id) {
        cartService.deleteCart(id);
    }


   //添加一项购物车
    @PostMapping
    public Result<String> addCart(@RequestBody Cart cart, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        cart.setUserId(user.getId());
        System.out.println(cart);
        Cart cart1=cartService.addCart(cart);
        if (cart1 != null) {
            return new Result<>("添加购物车成功");
        }else {
            return new Result<>(400, "添加失败");
        }
    }

}

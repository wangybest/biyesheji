package wangy.mall.service;

import wangy.mall.entity.Cart;

import java.util.List;

public interface CartService {

    List<Cart> queryCart(int userId);

    void deleteCart(int id);

    Cart addCart(Cart cart);

//    void clearCart(int userId);



}

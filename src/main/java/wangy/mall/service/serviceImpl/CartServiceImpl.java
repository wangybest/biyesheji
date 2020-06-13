package wangy.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangy.mall.dao.CartRepository;
import wangy.mall.entity.Cart;
import wangy.mall.service.CartService;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Cart> queryCart(int userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public void deleteCart(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

   /* @Override
    public void clearCart(int userId) {
        cartRepository.deleteByUserId(userId);
    }*/


}

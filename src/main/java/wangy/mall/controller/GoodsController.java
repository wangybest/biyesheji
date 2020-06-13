package wangy.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wangy.mall.entity.Cart;
import wangy.mall.entity.Goods;
import wangy.mall.entity.Goodstype;
import wangy.mall.entity.User;
import wangy.mall.service.CartService;
import wangy.mall.service.GoodsService;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "goods")
public class GoodsController {

    private String filePath = "D:/project/mall/src/main/resources/static/img/photos/"; //定义上传文件的存放位置

    @Autowired
    GoodsService goodsService;


    //添加商品
    @PostMapping
    public Goods addGoods(@RequestBody Goods goods) {
        return goodsService.saveGoods(goods);
    }

    //删除商品
    @DeleteMapping("{id}")
    public void deleteGoods(@PathVariable int id) {
        goodsService.deleteGoods(id);
    }

    //查询所有商品
    @GetMapping("all")
    public List<Goods> queryAllGoods() {
        return goodsService.queryAllGoods();
    }

    //查询某个商品
    @GetMapping("{id}")
    public Goods queryGoods(@PathVariable int id) {
        return goodsService.queryGoods(id);
    }

    //搜索商品
  /*  @GetMapping("{name}")
    public List<Goods> searchGoods(@PathVariable String name) {

    }*/

    //查询用户购物车商品
   /* @GetMapping("cart")
    public List<List> queryCart(HttpSession httpSession) {
        List<List> cartAndGoods = new ArrayList();
        User user = (User)httpSession.getAttribute("user");
        List<Cart> cart = cartService.queryCart(user.getId());
        cartAndGoods.add(cart);
        List<Goods> goods = new ArrayList<>();
        for (int i = 0; i < cart.size(); i++) {
            goods.add(this.queryGoods(cart.get(i).getGoodsId()));
        }
        cartAndGoods.add(goods);
        return cartAndGoods;
    }*/

    //查询某种类型的商品
    @GetMapping("type/{typename}")
    public List<Goods> queryTypeGoods(@PathVariable String typename) {
        return goodsService.queryTypeGoods(typename);
    }

    //更新商品
    @PutMapping
    public Goods updateGoods(@RequestBody Goods goods) {
        return goodsService.saveGoods(goods);
    }

    //添加商品类型
    @PostMapping("type")
    public Goodstype addGoodstype(@RequestBody Goodstype goodstype) {
        return goodsService.addGoodstype(goodstype);
    }

    //查询商品类型
    @GetMapping("type")
    public List<Goodstype> queryGoodstype() {
        return goodsService.queryGoodstype();
    }

    //删除商品类型
    @DeleteMapping("type/{id}")
    public void deleteGoodstype(@PathVariable int id) {
        goodsService.deleteGoodstype(id);
    }

    //添加商品图片
    @PostMapping("picture/{id}")
    public ResponseEntity<String> upLoadFile(MultipartFile picture, @PathVariable int id) {

        this.deletePicture(id);
        //判断文件夹是否存在,不存在则创建
        File file = new File(filePath);

        if (!file.exists()) {
            file.mkdirs();
        }
        String originalFileName = picture.getOriginalFilename();//获取原始图片的扩展名
        String newFileName = UUID.randomUUID() + originalFileName;
        String newFilePath = filePath + newFileName; //新文件的路径
        try {
            picture.transferTo(new File(newFilePath));//将传来的文件写入新建的文件
            System.out.println("上传图片成功");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(400).body("IllegalStateException");
        } catch (IOException e1) {
            return ResponseEntity.status(400).body("IOException");
        }
        goodsService.addGoodsPicture(newFileName, id);
        return ResponseEntity.ok("上传图片成功");
    }

    //删除商品图片
    @DeleteMapping("picture/{id}")
    public ResponseEntity<String> deletePicture(@PathVariable int id) {
        String fileName=goodsService.queryGoods(id).getPicture();
        String newFilePath=filePath+fileName;
        File delFile = new File(newFilePath);
        if(delFile.isFile() && delFile.exists()) {
            delFile.delete();
            goodsService.deleteGoodsPicture(id);
            return ResponseEntity.ok("删除成功");
        }else {
            return ResponseEntity.status(400).body("删除失败");
        }

    }
}

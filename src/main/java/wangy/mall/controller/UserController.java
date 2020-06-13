package wangy.mall.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.ResponseEntity;
import wangy.mall.entity.Result;
import wangy.mall.entity.User;
import wangy.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wangy.mall.utils.TokenUtil;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    //注册
    @PostMapping("register")
    public Result<String> register(@RequestBody User user){
        if (userService.saveUser(user)) {
            return new Result<>("恭喜你，注册成功");
        } else {

            return new Result<>(400, "用户已被注册");
        }
    }

    //登录
    @PostMapping("login")
    public Result<String> login(@RequestBody User user, HttpSession httpSession) {
        User user1 = userService.login(user);
        if (user1!= null) {
//            String token = TokenUtil.sign(user1.getId());
//            return new Result<>(token);
            httpSession.setAttribute("user", user1);
            return new Result<>("登录成功");
        }else {
            return new Result<>(400, "用户名或密码错误");
        }
    }

    //退出
    @PostMapping("loginout")
    public void loginout(HttpSession session) {
        session.removeAttribute("user");
    }

    //查询所有用户
    @GetMapping("all")
    public Result<List<User>> queryAllUsers() {
        return new Result<>(userService.queryAllUsers());
    }

    //查询本人信息
    @GetMapping("a")
    public Result<User> queryUser(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        return new Result<>(user);
    }

    //更新个人信息
    @PutMapping
    public Result<String> updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            return new Result<>("用户信息更新成功");
        } catch (Exception e) {
            return new Result<>(400,"用户名已被注册");
        }
    }

}

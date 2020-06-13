package wangy.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wangy.mall.entity.Admin;
import wangy.mall.entity.Result;
import wangy.mall.service.AdminService;
import wangy.mall.utils.TokenUtil;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("login")
    public Result<String> login(@RequestBody Admin admin, HttpSession httpSession) {
        Admin admin1 = adminService.login(admin);
        if (admin1!= null) {
//            String token = TokenUtil.sign(admin1.getId());
//            return ResponseEntity.ok(token);
            httpSession.setAttribute("admin", admin1);
            return new Result<>("登录成功");
        }else {
            return new Result<>(400, "用户名或密码错误");
        }

    }

    @PostMapping("loginout")
    public void loginout(HttpSession session) {
        session.removeAttribute("admin");
    }

}

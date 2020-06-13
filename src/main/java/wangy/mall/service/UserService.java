package wangy.mall.service;

import wangy.mall.entity.User;

import java.util.List;

public interface UserService {

    Boolean saveUser(User user);

    User login(User user);

    List<User> queryAllUsers();

    User queryUser(int id);

    User updateUser(User user);

}

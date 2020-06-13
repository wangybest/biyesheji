package wangy.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangy.mall.dao.UserRepository;
import wangy.mall.entity.User;
import wangy.mall.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean saveUser(User user) {
        if (userRepository.existsByName(user.getName())){
            return false;
        }else {
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public User login(User user) {
        return userRepository.findByNameAndPassword(user.getName(), user.getPassword());
    }

    @Override
    public List<User> queryAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User queryUser(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}

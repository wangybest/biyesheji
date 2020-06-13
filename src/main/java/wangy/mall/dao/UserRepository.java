package wangy.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wangy.mall.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Boolean existsByName(String name);

    User findByNameAndPassword(String name, String password);
}

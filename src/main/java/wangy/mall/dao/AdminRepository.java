package wangy.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wangy.mall.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findByNameAndPassword(String name, String password);
}

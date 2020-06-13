package wangy.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangy.mall.dao.AdminRepository;
import wangy.mall.entity.Admin;
import wangy.mall.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin login(Admin admin) {
        return adminRepository.findByNameAndPassword(admin.getName(), admin.getPassword());
    }
}

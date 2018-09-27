package cn.jhkj.springboot_mysql.service.impl;

import cn.jhkj.springboot_mysql.dao.UserRepository;
import cn.jhkj.springboot_mysql.domain.User;
import cn.jhkj.springboot_mysql.exception.UserException;
import cn.jhkj.springboot_mysql.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        //判断user表中该User是否已存在
        if (!userRepository.exists(Example.of(user))) {
            userRepository.save(user);
        }
    }

    @Override
    public User loginUser(String username, String password) {
        //获取用户信息
        User user = userRepository.findByUsernameAndPassword(username, password);

        //判断用户是否存在，如果不存在抛出异常作为返回值，用户存在则将设置登录时间
        if (user != null) {
            if (user.getLastLoginTime() == null) {
                user.setLastLoginTime("您是第一次登录。");
            } else {
                user.setLastLoginTime(new Date().toLocaleString());
            }
            user.setCurrentLoginTime(new Date().toLocaleString());
            userRepository.save(user);
            return user;
        } else {
            throw new UserException("用户不存在");
        }

    }
}

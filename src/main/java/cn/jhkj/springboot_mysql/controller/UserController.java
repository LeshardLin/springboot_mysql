package cn.jhkj.springboot_mysql.controller;

import cn.jhkj.springboot_mysql.domain.User;
import cn.jhkj.springboot_mysql.exception.UserException;
import cn.jhkj.springboot_mysql.service.BusinessService;
import cn.jhkj.springboot_mysql.service.impl.BusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    BusinessService businessService;

    @RequestMapping(value = "/registerController", method = RequestMethod.POST)
    public void registerUser(@RequestParam("username") String username,
                             @RequestParam("password") String password) {
        User user = new User(username, password);
        System.out.println("user" + user);
        businessService.registerUser(user);
    }

    @RequestMapping(value = "/loginController")
    public User loginUser(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        try {
            User user = businessService.loginUser(username, password);
            return user;
        } catch (UserException userException) {
            //todo 需要编写异常处理
            return new User();
        }
    }
}

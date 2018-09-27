package cn.jhkj.springboot_mysql.service;


import cn.jhkj.springboot_mysql.domain.User;

public interface BusinessService {

    /**
     * 用户注册
     * @param user
     */
    void registerUser(User user);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User loginUser(String username, String password);

}

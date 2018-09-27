package cn.jhkj.springboot_mysql;

import cn.jhkj.springboot_mysql.dao.UserRepository;
import cn.jhkj.springboot_mysql.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMysqlApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        userRepository.save(new User("test2", "123456"));
    }

}

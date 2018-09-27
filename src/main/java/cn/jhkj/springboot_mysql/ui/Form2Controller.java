package cn.jhkj.springboot_mysql.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Form2Controller {

    @RequestMapping(value = "/{form}")
    public String form2Controller(@PathVariable("form") String form) {
        return form;
    }

}

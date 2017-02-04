package com.blog.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by learnrace on 2017. 2. 3..
 */

@RestController
public class MenuController {

    @RequestMapping("/menu/list")
    @ResponseBody
    public String menuList(){
        return "Hello World!!";
    }

}

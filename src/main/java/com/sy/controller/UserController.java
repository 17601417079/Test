package com.sy.controller;

import com.sy.model.User;
import com.sy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Administrator
 * @Date: 2020/12/2 16:54
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/info.do")
    @ResponseBody
    public User findUser(int id) throws Exception{
        User byId = service.findById(id);
        return byId;
    }
    
    @RequestMapping("/list.do")
    public String showList(Model model) throws Exception{
        List<User> all = service.findAll();
        model.addAttribute("list",all);
        return "user/index";
    }

    /**
     * 查询用户名包含a字母的用户，返回第一页数据
     * pageNum 当前页
     * pageSize 每页容量
     * @return
     * @throws Exception
     */
    @RequestMapping("/page.do")
    public String showPage(User user,Integer pageNow,Integer pageSize,Model model) throws Exception{
        //匹配规则
        Pageable pageable = PageRequest.of(pageNow, pageSize);
        ExampleMatcher em = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        //Example模型
        Example example = Example.of(user,em);
        //username like '%a%'
        Page<User> page = service.findPage(example, pageable);
        model.addAttribute("list", page.getContent());
        return "user/index";
    }

    @RequestMapping("/page2.do")
    public String showPage2(User user,Integer pageNow,Integer pageSize,Model model) throws Exception{
        //匹配规则
        Pageable pageable = PageRequest.of(pageNow, pageSize);
        //username like '%a%'
        Page<User> page = service.findByUsernameContains(user.getUsername(), pageable);
        model.addAttribute("list", page.getContent());
        return "user/index";
    }
}

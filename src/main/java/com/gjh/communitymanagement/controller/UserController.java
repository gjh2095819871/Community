package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Building;
import com.gjh.communitymanagement.domain.User;
import com.gjh.communitymanagement.service.BuildingService;
import com.gjh.communitymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<User> userIPage = userService.search(searchMap);
        return new PageResult(true, StatusCode.OK, "用户列表查询成功", userIPage.getRecords(), userIPage.getTotal());
    }

    @PostMapping("/add")
    public Result addUser(@RequestBody User user){
        Boolean aBoolean = userService.add(user);
        return new Result(aBoolean,StatusCode.OK,"注册成功");
    }

    @PostMapping("/login")
    public Result Login(@RequestBody User user) {
        Boolean login = userService.login(user);
        if (login){
            System.out.println("success");
            return new Result(true, StatusCode.OK, "登录成功", user);
        }
        else {
            return new Result(false, StatusCode.ERROR, "用户名或密码错误", user);
        }
    }
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam Integer id) {
        int delete = userService.deleteById(id);
        return new Result(delete > 0 ? true : false, StatusCode.OK, MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }

    @GetMapping("/findByName")
    public Result findByName(@RequestParam String username){
        User byName = userService.findByName(username);
        return new Result(true,StatusCode.OK,"",byName);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        Boolean update = userService.update(user);
        return new Result(update, StatusCode.OK, MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }


}


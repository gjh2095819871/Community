package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.User;

import java.util.Map;


/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
public interface UserService extends IService<User> {

    IPage<User> search(Map searchMap);

    Boolean login(User user);

    Boolean add(User user);

    Boolean update(User user);

    User findByName(String username);

    int deleteById(int id);

}

package com.gjh.communitymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.gjh.communitymanagement.dao.UserDao;
import com.gjh.communitymanagement.domain.User;
import com.gjh.communitymanagement.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public IPage<User> search(Map searchMap) {
        //通用写法
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        int pageNum = 1;
        int pageSize = 2;
        if (!searchMap.isEmpty()) {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (StringUtil.isNotEmpty((String) searchMap.get("startTime"))) {
                Date startTime = new Date();
                try {
                    startTime = fmt.parse((String) searchMap.get("startTime"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String strStart = DateFormatUtils.format(startTime, "yyyy-MM-dd HH:mm:ss");
                queryWrapper.apply("UNIX_TIMESTAMP(create_time) >= (UNIX_TIMESTAMP('" + strStart + "')+28800)");
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("endTime"))) {
                Date endTime = new Date();
                try {
                    endTime = fmt.parse((String) searchMap.get("endTime"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String strEnd = DateFormatUtils.format(endTime, "yyyy-MM-dd HH:mm:ss");
                queryWrapper.apply("UNIX_TIMESTAMP(create_time) <= (UNIX_TIMESTAMP('" + strEnd + "')+115200)");
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("name"))) {
                queryWrapper.like("community_name", (String) searchMap.get("name"));
            }
            if (StringUtil.isNotEmpty(searchMap.get("pageNum").toString())) {
                pageNum = Integer.parseInt(searchMap.get("pageNum").toString());
            }
            if (StringUtil.isNotEmpty(searchMap.get("pageSize").toString())) {
                pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
            }

        }
        IPage<User> page = new Page<>(pageNum, pageSize);


        IPage<User> buildingIPage = userDao.selectPage(page, queryWrapper);
        return buildingIPage;
    }

    @Override
    public Boolean login(User user) {
        User user1 = findByName(user.getUsername());
        if (user1 != null) {
            if(StringUtils.equals(DigestUtils.md5Hex(user.getPassword()+user1.getSalt()),user1.getPassword())){
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public Boolean add(User user) {
        if (findByName(user.getUsername()) == null) {
            String salt= StringUtils.replace(UUID.randomUUID().toString(),"-","");
            user.setPassword(DigestUtils.md5Hex(user.getPassword()+salt));
            user.setSalt(salt);
            user.setCreateTime(new Date());
            userDao.insert(user);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public Boolean update(User user) {
        int i = userDao.updateById(user);
        return i > 0 ? true : false;
    }

    @Override
    public User findByName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userDao.selectOne(queryWrapper);
        return user;
    }

    @Override
    public int deleteById(int id) {
        int i = userDao.deleteById(id);
        return i;
    }

}

package com.gjh.communitymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.github.pagehelper.util.StringUtil;
import com.gjh.communitymanagement.domain.House;
import com.gjh.communitymanagement.dao.HouseDao;
import com.gjh.communitymanagement.service.HouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房屋表 服务实现类
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseDao, House> implements HouseService {


    @Autowired
    private HouseDao houseDao;

    @Override
    public IPage<House> search(Map searchMap) {
        //通用写法
        QueryWrapper<House> queryWrapper = new QueryWrapper<>();
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
                queryWrapper.apply("UNIX_TIMESTAMP(live_time) >= (UNIX_TIMESTAMP('" + strStart + "')+28800)");
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("endTime"))) {
                Date endTime = new Date();
                try {
                    endTime = fmt.parse((String) searchMap.get("endTime"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String strEnd = DateFormatUtils.format(endTime, "yyyy-MM-dd HH:mm:ss");
                queryWrapper.apply("UNIX_TIMESTAMP(live_time) <= (UNIX_TIMESTAMP('" + strEnd + "')+115200)");
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("name"))) {
                queryWrapper.like("name", (String) searchMap.get("name"));
            }
            if (StringUtil.isNotEmpty(searchMap.get("pageNum").toString())) {
                pageNum = Integer.parseInt(searchMap.get("pageNum").toString());
            }
            if (StringUtil.isNotEmpty(searchMap.get("pageSize").toString())) {
                pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
            }

        }
        IPage<House> page = new Page<>(pageNum, pageSize);


        IPage<House> houseIPage = houseDao.selectPage(page, queryWrapper);
        return houseIPage;
    }

    @Override
    public Boolean add(House house) {
        return null;
    }

    @Override
    public Boolean update(House house) {
        int i = houseDao.updateById(house);
        return i > 0 ? true : false;
    }

    @Override
    public House findById(int id) {
        House house = houseDao.selectById(id);
        return house;
    }

    @Override
    public int deleteById(int id) {
        int i = houseDao.deleteById(id);
        return i;
    }

    @Override
    public int deleteAll(List list) {
        return 0;
    }
}

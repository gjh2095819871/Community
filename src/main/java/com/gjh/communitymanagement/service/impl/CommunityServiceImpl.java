package com.gjh.communitymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.util.StringUtil;
import com.gjh.communitymanagement.dao.CommunityDao;
import com.gjh.communitymanagement.domain.Community;
import com.gjh.communitymanagement.service.CommunityService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityDao communityDao;



    @Override
    public List<Community> findAll() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select();
        List<Community> list = communityDao.selectList(queryWrapper);
        return list;
    }

    @Override
    public IPage<Community> search(Map searchMap) {

        //通用写法

        QueryWrapper<Community> queryWrapper = new QueryWrapper<>();
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
                queryWrapper.like("name", (String) searchMap.get("name"));
            }
            if (StringUtil.isNotEmpty(searchMap.get("pageNum").toString())) {
                pageNum = Integer.parseInt(searchMap.get("pageNum").toString());
            }
            if (StringUtil.isNotEmpty(searchMap.get("pageSize").toString())) {
                pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
            }

        }
        IPage<Community> page = new Page<>(pageNum, pageSize);


        IPage<Community> communityIPage = communityDao.selectPage(page, queryWrapper);
        return communityIPage;
    }

    @Override
    public Boolean add(Community community) {
        return communityDao.insert(community) > 0 ? true : false;
    }

    @Override
    public Boolean update(Community community) {
        community.setCreateTime(community.getUpdateTime());
        return communityDao.updateById(community) > 0 ? true : false;
    }

    @Override
    public Community findById(int id) {
        return communityDao.selectById(id);
    }

    @Override
    public int deleteById(int id) {
        return communityDao.deleteById(id);
    }

    @Override
    public int deleteAll(List list) {
        return communityDao.deleteBatchIds(list);
    }

    @Override
    public List<Map<String, Object>> findAllComm() {
        QueryWrapper<Community> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","name");
        List<Map<String, Object>> maps = communityDao.selectMaps(queryWrapper);
        return maps;
    }

    @Override
    public Map<String,Integer> searchCount() {
        QueryWrapper<Community> wrapper = new QueryWrapper<>();
        wrapper.select("SUM(total_buildings) as total_buildings","SUM(total_households) as total_households");//,"SUM(total_households)"
        List<Community> communityList= communityDao.selectList(wrapper);
        Integer buildingSum = communityList.get(0).getTotalBuildings();
        HashMap<String, Integer> integerHashMap = new HashMap<>();
        integerHashMap.put("buildingcount",buildingSum);
        Integer householdSum = communityList.get(0).getTotalHouseholds();
        integerHashMap.put("homecount",householdSum);

        return integerHashMap;
    }
}

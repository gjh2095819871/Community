package com.gjh.communitymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.gjh.communitymanagement.dao.OwnerDao;
import com.gjh.communitymanagement.domain.Building;
import com.gjh.communitymanagement.domain.Community;
import com.gjh.communitymanagement.domain.Owner;
import com.gjh.communitymanagement.service.OwnerService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @Author guojianhui
 * @ClassName: OwnerServiceImpl
 * @Version 1.0
 */
@Service
public class OwnerServiceImpl extends ServiceImpl<OwnerDao,Owner> implements OwnerService {

    @Autowired
    private OwnerDao ownerDao;

    @Override
    public IPage<Owner> search(Map searchMap) {
        //通用写法
        QueryWrapper<Owner> queryWrapper = new QueryWrapper<>();
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


        IPage<Owner> page = new Page<>(pageNum, pageSize);


        IPage<Owner> ownerIPage = ownerDao.selectPage(page, queryWrapper);
        return ownerIPage;
    }

    @Override
    public Boolean add(Owner owner) {
        return null;
    }

    @Override
    public Boolean update(Owner owner) {
        return null;
    }

    @Override
    public Owner findById(int id) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public int deleteAll(List list) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> findAllOwn() {
        QueryWrapper<Owner> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","name");
        List<Map<String, Object>> maps = ownerDao.selectMaps(queryWrapper);
        return maps;
    }


}

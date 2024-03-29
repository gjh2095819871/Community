package com.gjh.communitymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.gjh.communitymanagement.dao.ChargeItemDao;
import com.gjh.communitymanagement.domain.ChargeItem;
import com.gjh.communitymanagement.service.ChargeItemService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ChargeItemServiceImpl extends ServiceImpl<ChargeItemDao, ChargeItem> implements ChargeItemService {

    @Autowired
    private ChargeItemDao chargeItemDao;

    @Override
    public IPage<ChargeItem> search(Map searchMap) {
        //通用写法
        QueryWrapper<ChargeItem> queryWrapper = new QueryWrapper<>();
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
        IPage<ChargeItem> page = new Page<>(pageNum, pageSize);


        IPage<ChargeItem> chargeItemIPage = chargeItemDao.selectPage(page, queryWrapper);
        return chargeItemIPage;
    }

    @Override
    public Boolean add(ChargeItem chargeItem) {
        return chargeItemDao.insert(chargeItem) > 0 ? true : false;
    }

    @Override
    public Boolean update(ChargeItem chargeItem) {
        return chargeItemDao.updateById(chargeItem) > 0 ? true : false;
    }

    @Override
    public ChargeItem findById(int id) {
        return chargeItemDao.selectById(id);
    }

    @Override
    public int deleteById(int id) {
        return chargeItemDao.deleteById(id);
    }

    @Override
    public int deleteAll(List list) {
        return 0;
    }
}

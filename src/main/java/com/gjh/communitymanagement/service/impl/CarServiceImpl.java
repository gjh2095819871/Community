package com.gjh.communitymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.util.StringUtil;
import com.gjh.communitymanagement.dao.CarDao;
import com.gjh.communitymanagement.domain.Car;
import com.gjh.communitymanagement.domain.Owner;
import com.gjh.communitymanagement.service.CarService;
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
 * 车辆表 服务实现类
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarDao, Car> implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public IPage<Car> search(Map searchMap) {
        //通用写法
        QueryWrapper<Car> queryWrapper = new QueryWrapper<>();
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
                queryWrapper.like("carNumber", (String) searchMap.get("name"));
            }
            if (StringUtil.isNotEmpty(searchMap.get("pageNum").toString())) {
                pageNum = Integer.parseInt(searchMap.get("pageNum").toString());
            }
            if (StringUtil.isNotEmpty(searchMap.get("pageSize").toString())) {
                pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
            }

        }


        IPage<Car> page = new Page<>(pageNum, pageSize);


        IPage<Car> ownerIPage = carDao.selectPage(page, queryWrapper);
        return ownerIPage;
    }

    @Override
    public Boolean add(Car car) {
        int insert = carDao.insert(car);
        return insert > 0 ? true : false;
    }

    @Override
    public Boolean update(Car car) {
        return carDao.updateById(car) > 0 ? true : false;
    }

    @Override
    public Car findById(int id) {
        return carDao.selectById(id);
    }

    @Override
    public int deleteById(int id) {
        return carDao.deleteById(id);
    }

    @Override
    public int deleteAll(List list) {
        return 0;
    }
}

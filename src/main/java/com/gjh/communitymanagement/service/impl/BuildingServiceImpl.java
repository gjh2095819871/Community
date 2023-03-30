package com.gjh.communitymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.util.StringUtil;
import com.gjh.communitymanagement.service.BuildingService;
import com.gjh.communitymanagement.domain.Building;
import com.gjh.communitymanagement.dao.BuildingDao;
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
 * 楼栋表 服务实现类
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingDao, Building> implements BuildingService {

    @Autowired
    private BuildingDao buildingDao;

    @Override
    public IPage<Building> search(Map searchMap) {
        //通用写法
        QueryWrapper<Building> queryWrapper = new QueryWrapper<>();
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
        IPage<Building> page = new Page<>(pageNum, pageSize);


        IPage<Building> buildingIPage = buildingDao.selectPage(page, queryWrapper);
        return buildingIPage;
    }

    @Override
    public Boolean add(Building building) {
        return buildingDao.insert(building)> 0 ? true : false;
    }

    @Override
    public Boolean update(Building building) {
        int i = buildingDao.updateById(building);
        return i>0?true:false;
    }

    @Override
    public Building findById(int id) {
        Building building = buildingDao.selectById(id);
        return building;
    }

    @Override
    public int deleteById(int id) {
        int i = buildingDao.deleteById(id);
        return i;
    }

    @Override
    public int deleteAll(List list) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> findAllBuil(String cname) {
        QueryWrapper<Building> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("community_name",cname);
        queryWrapper.select("id","name");
        List<Map<String, Object>> maps = buildingDao.selectMaps(queryWrapper);
        return maps;
    }
}

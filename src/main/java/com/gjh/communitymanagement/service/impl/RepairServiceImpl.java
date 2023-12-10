package com.gjh.communitymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.gjh.communitymanagement.dao.RepairDao;
import com.gjh.communitymanagement.domain.Repair;
import com.gjh.communitymanagement.service.RepairService;
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
public class RepairServiceImpl extends ServiceImpl<RepairDao, Repair> implements RepairService {

    @Autowired
    private RepairDao repairDao;

    @Override
    public IPage<Repair> search(Map searchMap) {
        //通用写法
        // 创建查询条件对象
        QueryWrapper<Repair> queryWrapper = new QueryWrapper<>();

        // 设置分页参数
        int pageNum = 1; // 当前页码
        int pageSize = 2; // 每页数量

        // 判断搜索Map是否为空
        if (!searchMap.isEmpty()) {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // 判断startTime是否为空或非空
            if (StringUtil.isNotEmpty((String) searchMap.get("startTime"))) {
                Date startTime = new Date();
                try {
                    startTime = fmt.parse((String) searchMap.get("startTime"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // 将startTime格式化为字符串
                String strStart = DateFormatUtils.format(startTime, "yyyy-MM-dd HH:mm:ss");

                // 构造查询条件，UNIX_TIMESTAMP(live_time) >= (UNIX_TIMESTAMP('startTime')+28800)
                queryWrapper.apply("UNIX_TIMESTAMP(live_time) >= (UNIX_TIMESTAMP('" + strStart + "')+28800)");
            }

            // 判断endTime是否为空或非空
            if (StringUtil.isNotEmpty((String) searchMap.get("endTime"))) {
                Date endTime = new Date();
                try {
                    endTime = fmt.parse((String) searchMap.get("endTime"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // 将endTime格式化为字符串
                String strEnd = DateFormatUtils.format(endTime, "yyyy-MM-dd HH:mm:ss");

                // 构造查询条件，UNIX_TIMESTAMP(live_time) <= (UNIX_TIMESTAMP('endTime')+115200)
                queryWrapper.apply("UNIX_TIMESTAMP(live_time) <= (UNIX_TIMESTAMP('" + strEnd + "')+115200)");
            }

            // 判断name是否为空或非空
            if (StringUtil.isNotEmpty((String) searchMap.get("name"))) {
                // 查询条件中like device_name 列 like '%name%'
                queryWrapper.like("device_name", (String) searchMap.get("name"));
            }

            // 判断pageNum是否为空或非空
            if (StringUtil.isNotEmpty(searchMap.get("pageNum").toString())) {
                // 将pageNum转换为int类型
                pageNum = Integer.parseInt(searchMap.get("pageNum").toString());
            }

            // 判断pageSize是否为空或非空
            if (StringUtil.isNotEmpty(searchMap.get("pageSize").toString())) {
                // 将pageSize转换为int类型
                pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
            }
        }

        // 创建分页对象
        IPage<Repair> page = new Page<>(pageNum, pageSize);

        // 根据查询条件和分页对象获取数据
        IPage<Repair> repairIPage = repairDao.selectPage(page, queryWrapper);

        // 返回结果
        return repairIPage;

    }

    @Override
    public List<Repair> searchten() {
        QueryWrapper<Repair> repairQueryWrapper = new QueryWrapper<>();
        repairQueryWrapper.last("limit 10");
        List<Repair> repairs = repairDao.selectList(repairQueryWrapper);
        return repairs;
    }

    @Override
    public Boolean add(Repair repair) {
        return repairDao.insert(repair) > 0 ? true : false;
    }

    @Override
    public Boolean update(Repair repair) {
        return repairDao.updateById(repair) > 0 ? true : false;
    }

    @Override
    public Repair findById(int id) {
        return repairDao.selectById(id);
    }

    @Override
    public int deleteById(int id) {
        return repairDao.deleteById(id);
    }

    @Override
    public int deleteAll(List list) {
        return 0;
    }
}

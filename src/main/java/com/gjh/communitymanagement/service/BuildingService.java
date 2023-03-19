package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.domain.Building;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 楼栋表 服务类
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
public interface BuildingService extends IService<Building> {

    IPage<Building> search(Map searchMap);

    Boolean add(Building building);

    Boolean update(Building building);

    Building findById(int id);

    int deleteById(int id);

    int deleteAll(List list);

    List<Map<String, Object>> findAllBuil(String cname);
}

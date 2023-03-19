package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.domain.House;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房屋表 服务类
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
public interface HouseService {

    IPage<House> search(Map searchMap);

    Boolean add(House house);

    Boolean update(House house);

    House findById(int id);

    int deleteById(int id);

    int deleteAll(List list);

}

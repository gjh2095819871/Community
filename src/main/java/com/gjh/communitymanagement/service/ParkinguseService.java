package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.ParkingUse;
import com.gjh.communitymanagement.domain.Pet;

import java.util.List;
import java.util.Map;

/**
 * @Author guojianhui
 * @ClassName: ParkinguseService
 * @Version 1.0
 */
public interface ParkinguseService extends IService<ParkingUse> {
    IPage<ParkingUse> search(Map searchMap);

    Boolean add(ParkingUse parkingUse);

    Boolean update(ParkingUse parkingUse);

    ParkingUse findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}

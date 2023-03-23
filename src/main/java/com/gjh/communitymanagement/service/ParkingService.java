package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.Parking;
import com.gjh.communitymanagement.domain.Pet;

import java.util.List;
import java.util.Map;

/**
 * @Author guojianhui
 * @ClassName: ParkingService
 * @Version 1.0
 */
public interface ParkingService extends IService<Parking> {
    IPage<Parking> search(Map searchMap);

    Boolean add(Parking parking);

    Boolean update(Parking parking);

    Parking findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}

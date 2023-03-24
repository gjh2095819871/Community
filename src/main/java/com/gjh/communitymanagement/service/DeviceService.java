package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.Device;

import java.util.List;
import java.util.Map;

public interface DeviceService extends IService<Device> {

    IPage<Device> search(Map searchMap);

    Boolean add(Device device);

    Boolean update(Device device);

    Device findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}

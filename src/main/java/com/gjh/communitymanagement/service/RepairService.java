package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.Repair;

import java.util.List;
import java.util.Map;

public interface RepairService extends IService<Repair> {

    IPage<Repair> search(Map searchMap);

    Boolean add(Repair repair);

    Boolean update(Repair repair);

    Repair findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}

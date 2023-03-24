package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.ChargeDetail;

import java.util.List;
import java.util.Map;

public interface ChargeDetailService extends IService<ChargeDetail> {

    IPage<ChargeDetail> search(Map searchMap);

    Boolean add(ChargeDetail chargeDetail);

    Boolean update(ChargeDetail chargeDetail);

    ChargeDetail findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}

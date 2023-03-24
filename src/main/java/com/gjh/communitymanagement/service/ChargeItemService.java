package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.ChargeItem;

import java.util.List;
import java.util.Map;

public interface ChargeItemService extends IService<ChargeItem> {

    IPage<ChargeItem> search(Map searchMap);

    Boolean add(ChargeItem chargeItem);

    Boolean update(ChargeItem chargeItem);

    ChargeItem findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}

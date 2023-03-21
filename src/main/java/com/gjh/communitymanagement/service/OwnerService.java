package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.Owner;

import java.util.List;
import java.util.Map;

/**
 * @Author guojianhui
 * @ClassName: OwnerService
 * @Version 1.0
 */
public interface OwnerService extends IService<Owner> {

    IPage<Owner> search(Map searchMap);

    Boolean add(Owner owner);

    Boolean update(Owner owner);

    Owner findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}

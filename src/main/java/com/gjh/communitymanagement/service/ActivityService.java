package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService extends IService<Activity> {

    IPage<Activity> search(Map searchMap);

    Boolean add(Activity activity);

    Boolean update(Activity activity);

    Activity findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}

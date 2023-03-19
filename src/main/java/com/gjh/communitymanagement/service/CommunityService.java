package com.gjh.communitymanagement.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.domain.Community;

import java.util.List;
import java.util.Map;


public interface CommunityService {

    List<Community> findAll();

    IPage<Community> search(Map searchMap);

    Boolean add(Community community);

    Boolean update(Community community);

    Community findById(int id);

    int deleteById(int id);

    int deleteAll(List list);

    List<Map<String, Object>> findAllComm();
}

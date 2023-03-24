package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.Complaint;

import java.util.List;
import java.util.Map;

public interface ComplaintService extends IService<Complaint> {

    IPage<Complaint> search(Map searchMap);

    Boolean add(Complaint complaint);

    Boolean update(Complaint complaint);

    Complaint findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}

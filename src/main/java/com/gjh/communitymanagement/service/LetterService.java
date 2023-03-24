package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.Letter;

import java.util.List;
import java.util.Map;

public interface LetterService extends IService<Letter> {

    IPage<Letter> search(Map searchMap);

    Boolean add(Letter letter);

    Boolean update(Letter letter);

    Letter findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}

package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjh.communitymanagement.domain.Car;
import com.gjh.communitymanagement.domain.Pet;

import java.util.List;
import java.util.Map;

/**
 * @Author guojianhui
 * @ClassName: PetService
 * @Version 1.0
 */
public interface PetService extends IService<Pet> {

    IPage<Pet> search(Map searchMap);

    Boolean add(Pet pet);

    Boolean update(Pet pet);

    Pet findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}

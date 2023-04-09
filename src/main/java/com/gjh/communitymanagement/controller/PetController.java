package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Car;
import com.gjh.communitymanagement.domain.Pet;
import com.gjh.communitymanagement.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 宠物表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<Pet> petIPage = petService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, petIPage.getRecords(), petIPage.getTotal());
    }

    @PostMapping("/add")
    public Result add(@RequestBody Pet pet){
        Boolean add = petService.add(pet);
        return new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Pet pet){
        Boolean update = petService.update(pet);
        return new Result(update,StatusCode.OK,"");
    }

    @GetMapping("/findById")
    public Result findById(Integer id){
        Pet pet = petService.findById(id);
        return new Result(true,StatusCode.OK,"",pet);
    }

    @DeleteMapping ("/daleteById")
    public Result deleteById(@RequestParam Integer id){
        int i = petService.deleteById(id);
        return new Result(i > 0 ? true : false, StatusCode.OK, "");
    }
}


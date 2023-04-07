package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Community;
import com.gjh.communitymanagement.domain.Letter;
import com.gjh.communitymanagement.domain.Owner;
import com.gjh.communitymanagement.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业主表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<Owner> ownerIPage = ownerService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, ownerIPage.getRecords(), ownerIPage.getTotal());
    }

    @RequestMapping("/findAllOwn")
    public Result findAllOwn(){
        List<Map<String, Object>> allComm = ownerService.findAllOwn();
        return new Result(true,StatusCode.OK,"ok",allComm);
    }

    @GetMapping("/searchCount")
    public Result searchCount(){
        Map<String,Integer> stringIntegerMap=ownerService.searchCount();
        return new Result(true,StatusCode.OK,"ok",stringIntegerMap);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Owner owner){
        Boolean add = ownerService.add(owner);
        return new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Owner owner){
        Boolean update = ownerService.update(owner);
        return new Result(update,StatusCode.OK,"");
    }

    @GetMapping("/findById")
    public Result findById(Integer id){
        Owner owner = ownerService.findById(id);
        return new Result(true,StatusCode.OK,"",owner);
    }

    @DeleteMapping ("/daleteById")
    public Result deleteById(@RequestParam Integer id){
        int i = ownerService.deleteById(id);
        return new Result(i > 0 ? true : false, StatusCode.OK, "");
    }
}

